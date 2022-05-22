package com.vanshaj.vehicleRental.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VehicleDto {
    private String id;
    private int price;
    private String type;
    private String branchName;
}
