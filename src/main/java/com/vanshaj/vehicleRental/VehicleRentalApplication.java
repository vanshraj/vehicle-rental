package com.vanshaj.vehicleRental;

import com.vanshaj.vehicleRental.executor.Executor;
import com.vanshaj.vehicleRental.executor.FileExecutor;
import com.vanshaj.vehicleRental.repository.BookingRepository;
import com.vanshaj.vehicleRental.repository.BranchRepository;
import com.vanshaj.vehicleRental.repository.VehicleRepository;
import com.vanshaj.vehicleRental.repository.impl.BookingRepositoryImpl;
import com.vanshaj.vehicleRental.repository.impl.BranchRepositoryImpl;
import com.vanshaj.vehicleRental.repository.impl.VehicleRepositoryImpl;
import com.vanshaj.vehicleRental.service.BookingService;
import com.vanshaj.vehicleRental.service.QueryService;
import com.vanshaj.vehicleRental.service.RegistrationService;
import com.vanshaj.vehicleRental.service.impl.BookingServiceImpl;
import com.vanshaj.vehicleRental.service.impl.QueryServiceImpl;
import com.vanshaj.vehicleRental.service.impl.RegistrationServiceImpl;

public class VehicleRentalApplication {
    public static void main(String[] args) {
        BranchRepository branchRepository = new BranchRepositoryImpl();
        VehicleRepository vehicleRepository = new VehicleRepositoryImpl();
        BookingRepository bookingRepository = new BookingRepositoryImpl();

        RegistrationService registrationService =
                new RegistrationServiceImpl(branchRepository,vehicleRepository);
        BookingService bookingService =
                new BookingServiceImpl(branchRepository,
                        vehicleRepository,bookingRepository);
        QueryService queryService = new QueryServiceImpl(branchRepository, bookingRepository);

        Executor executor =
                new FileExecutor(registrationService, bookingService, queryService, args[0]);
        executor.read();
    }
}
