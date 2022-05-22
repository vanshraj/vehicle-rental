package com.vanshaj.vehicleRental.repository.impl;

import com.vanshaj.vehicleRental.util.TimeSlot;
import com.vanshaj.vehicleRental.repository.BookingRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRepositoryImpl implements BookingRepository {
    Map<String, List<TimeSlot>> bookings = new HashMap<>();

    @Override
    public void book(String vehicleId, int startTime, int endTime) {
        List<TimeSlot> timeSlotList = bookings.computeIfAbsent(vehicleId, k -> new ArrayList<>());
        timeSlotList.add(new TimeSlot(startTime, endTime));
    }

    @Override
    public boolean isSlotAvailable(String vehicleId, int startTime, int endTime) {
        TimeSlot requestedSlot = new TimeSlot(startTime, endTime);
        List<TimeSlot> timeSlotList = bookings.getOrDefault(vehicleId, new ArrayList<>());
        return timeSlotList.stream().noneMatch(requestedSlot::intersects);
    }
}
