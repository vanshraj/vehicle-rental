package com.vanshaj.vehicleRental.executor;

import com.vanshaj.vehicleRental.dto.BookingDto;
import com.vanshaj.vehicleRental.dto.BranchDto;
import com.vanshaj.vehicleRental.dto.DisplayDto;
import com.vanshaj.vehicleRental.dto.VehicleDto;
import com.vanshaj.vehicleRental.service.BookingService;
import com.vanshaj.vehicleRental.service.QueryService;
import com.vanshaj.vehicleRental.service.RegistrationService;

import java.util.Set;

public abstract class Executor {
    private BranchDto branchDto;
    private VehicleDto vehicleDto;
    private BookingDto bookingDto;
    private DisplayDto displayDto;

    private RegistrationService registrationService;
    private BookingService bookingService;
    private QueryService queryService;

    public Executor(RegistrationService registrationService, BookingService bookingService, QueryService queryService) {
        this.bookingService = bookingService;
        this.registrationService = registrationService;
        this.queryService = queryService;
    }

    public abstract void read();
    public abstract void write(String output);

    public void executeCommand(String command) {
        String[] args = command.split(" ");
        switch (args[0]) {
            case "ADD_BRANCH":
                branchDto = BranchDto.builder()
                        .name(args[1])
                        .supportedType(Set.of(args[2].split(",")))
                        .build();
                Boolean result = registrationService.addBranch(branchDto);
                write(result.toString());
                break;
            case "ADD_VEHICLE":
                vehicleDto = VehicleDto.builder()
                        .branchName(args[1])
                        .type(args[2])
                        .id(args[3])
                        .price(Integer.parseInt(args[4].trim()))
                        .build();
                result = registrationService.addVehicle(vehicleDto);
                write(result.toString());
                break;
            case "BOOK":
                bookingDto = BookingDto.builder()
                        .branchName(args[1])
                        .vehicleType(args[2])
                        .startTime(Integer.parseInt(args[3].trim()))
                        .endTime(Integer.parseInt(args[4].trim()))
                        .build();
                Integer bookingPrice = bookingService.book(bookingDto);
                write(bookingPrice.toString());
                break;
            case "DISPLAY_VEHICLES":
                displayDto = DisplayDto.builder()
                        .branchName(args[1])
                        .startTime(Integer.parseInt(args[2].trim()))
                        .endTime(Integer.parseInt(args[3].trim()))
                        .build();
                String allVehicles = queryService.displayVehicles(displayDto);
                write(allVehicles);
                break;
        }
    }
}
