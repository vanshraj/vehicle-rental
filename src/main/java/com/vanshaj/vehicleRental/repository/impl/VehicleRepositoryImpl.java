package com.vanshaj.vehicleRental.repository.impl;

import com.vanshaj.vehicleRental.model.Vehicle;
import com.vanshaj.vehicleRental.repository.VehicleRepository;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepositoryImpl implements VehicleRepository {
    Map<String, Vehicle> vehicleMap;

    @Override
    public void add(Vehicle vehicle) {
        if (vehicleMap==null) vehicleMap = new HashMap<>();
        vehicleMap.put(vehicle.getId(),vehicle);
    }

    @Override
    public Vehicle getVehicle(String id) {
        if (vehicleMap==null) return null;
        return vehicleMap.get(id);
    }
}
