package com.vanshaj.vehicleRental.service.impl;

import com.vanshaj.vehicleRental.dto.DisplayDto;
import com.vanshaj.vehicleRental.model.Branch;
import com.vanshaj.vehicleRental.repository.BookingRepository;
import com.vanshaj.vehicleRental.repository.BranchRepository;
import com.vanshaj.vehicleRental.service.QueryService;

import java.util.*;
import java.util.stream.Collectors;

public class QueryServiceImpl implements QueryService {
    private BranchRepository branchRepository;
    private BookingRepository bookingRepository;

    public QueryServiceImpl(BranchRepository branchRepository,
                            BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public String displayVehicles(DisplayDto displayDto) {
        Branch branch = branchRepository.getBranch(displayDto.getBranchName());
        if(branch==null) return "";
        List<String> vehicles = new ArrayList<>();
        for (String supportedType : new ArrayList<>(branch.getSupportedType())) {
            Set<String> vehiclesOfType = branch.getVehiclesSet().get(supportedType);
            if (vehiclesOfType != null)
                vehicles.addAll(new ArrayList<>(vehiclesOfType));
        }
        List<String> availableVehicles = vehicles.stream()
                .filter(vehicleId -> bookingRepository.isSlotAvailable(vehicleId,
                        displayDto.getStartTime(),displayDto.getEndTime()))
                .collect(Collectors.toList());
        return String.join(",", availableVehicles);
    }
}
