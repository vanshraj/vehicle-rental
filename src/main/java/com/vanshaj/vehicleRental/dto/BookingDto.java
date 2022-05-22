package com.vanshaj.vehicleRental.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingDto {
    private String branchName;
    private String vehicleType;
    private int startTime;
    private int endTime;
}
