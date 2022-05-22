package com.vanshaj.vehicleRental.model;

import lombok.Data;

@Data
public class Booking {
    private String branchId;
    private String vehicleId;
    //List<Pair<Integer,Integer>> bookings;
}
