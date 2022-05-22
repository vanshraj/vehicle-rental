package com.vanshaj.vehicleRental.service.impl;

import com.vanshaj.vehicleRental.dto.BookingDto;
import com.vanshaj.vehicleRental.model.Vehicle;
import com.vanshaj.vehicleRental.repository.BookingRepository;
import com.vanshaj.vehicleRental.repository.BranchRepository;
import com.vanshaj.vehicleRental.repository.VehicleRepository;
import com.vanshaj.vehicleRental.service.BookingService;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class BookingServiceImpl implements BookingService {
    private final BranchRepository branchRepository;
    private final VehicleRepository vehicleRepository;
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BranchRepository branchRepository,
                              VehicleRepository vehicleRepository,
                              BookingRepository bookingRepository) {
        this.branchRepository = branchRepository;
        this.vehicleRepository = vehicleRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Integer book(BookingDto bookingDto) {
        if(!branchRepository.supports(bookingDto.getBranchName(),bookingDto.getVehicleType())) return -1;
        Set<String> vehicles = branchRepository.getVehicles(bookingDto.getBranchName(),
                bookingDto.getVehicleType());
        if(vehicles==null) return -1;
        Optional<Vehicle> bestPriceVehicle = vehicles.stream()
                .filter(vehicleId -> bookingRepository.isSlotAvailable(vehicleId,
                        bookingDto.getStartTime(),bookingDto.getEndTime()))
                .map(vehicleRepository::getVehicle)
                .min(Comparator.comparingInt(Vehicle::getPrice));
        if(bestPriceVehicle.isEmpty()) return -1;
        bookingRepository.book(bestPriceVehicle.get().getId(),
                bookingDto.getStartTime(), bookingDto.getEndTime());
        return bestPriceVehicle.get().getPrice();
    }
}
