package com.vanshaj.vehicleRental.model;

import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class Branch {
    private String name;
    private Set<String> supportedType;
    private Map<String, Set<String>> vehiclesSet;
}
