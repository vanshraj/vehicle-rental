package com.vanshaj.vehicleRental.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DisplayDto {
    private String branchName;
    private int startTime;
    private int endTime;
}
