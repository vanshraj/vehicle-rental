package com.vanshaj.vehicleRental.executor;

import com.vanshaj.vehicleRental.service.BookingService;
import com.vanshaj.vehicleRental.service.QueryService;
import com.vanshaj.vehicleRental.service.RegistrationService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class FileExecutor extends Executor {
    private String filePath;
    public FileExecutor(RegistrationService registrationService,
                        BookingService bookingService,
                        QueryService queryService, String filePath) {
        super(registrationService,bookingService,queryService);
        this.filePath = filePath;
    }

    @Override
    public void read() {
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()){
                String command = scanner.nextLine();
                executeCommand(command);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            write("File not found "+e);
        }
    }

    @Override
    public void write(String output) {
        System.out.println(output.toUpperCase(Locale.ROOT));
    }
}
