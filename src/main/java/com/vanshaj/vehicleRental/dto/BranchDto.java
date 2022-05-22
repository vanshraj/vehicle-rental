package com.vanshaj.vehicleRental.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class BranchDto {
    private String name;
    private Set<String> supportedType;
}
