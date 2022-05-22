package com.vanshaj.vehicleRental.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimeSlot {
    int startTime;
    int endTime;

    public Boolean intersects(TimeSlot other) {
        return !((startTime <= other.getStartTime() && endTime <= other.getStartTime()) ||
                (startTime >= other.getEndTime() && endTime >= other.getEndTime()));
    }
}