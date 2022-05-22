package com.vanshaj.vehicleRental.repository;

public interface BookingRepository {
    void book(String vehicleId, int startTime, int endTime);
    boolean isSlotAvailable(String vehicleId, int startTime, int endTime);
}
