package com.vanshaj.vehicleRental.executor;

import com.vanshaj.vehicleRental.service.BookingService;
import com.vanshaj.vehicleRental.service.QueryService;
import com.vanshaj.vehicleRental.service.RegistrationService;

import java.util.Locale;
import java.util.Scanner;

public class CommandExecutor extends Executor {
    public CommandExecutor(RegistrationService registrationService,
                           BookingService bookingService, QueryService queryService) {
        super(registrationService, bookingService, queryService);
    }

    @Override
    public void read() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String command = scanner.nextLine();
            executeCommand(command);
        }
        scanner.close();
    }

    @Override
    public void write(String output) {
        System.out.println(output.toUpperCase(Locale.ROOT));
    }
}
