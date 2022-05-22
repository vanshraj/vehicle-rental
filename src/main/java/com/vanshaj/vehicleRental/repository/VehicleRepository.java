package com.vanshaj.vehicleRental.repository;

import com.vanshaj.vehicleRental.model.Vehicle;

public interface VehicleRepository {
    public void add(Vehicle vehicle);
    public Vehicle getVehicle(String id);
}
