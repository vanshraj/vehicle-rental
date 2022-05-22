package com.vanshaj.vehicleRental.repository;

import com.vanshaj.vehicleRental.model.Branch;

import java.util.Set;

public interface BranchRepository {
    public void add(Branch branch);
    public Branch getBranch(String id);
    public Boolean supports(String branchName, String vehicleType);
    public Boolean containsVehicle(String branchName, String vehicleType, String vehicleId);
    public void addVehicle(String branchName,String vehicleType, String vehicleId);

    Set<String> getVehicles(String branchName, String vehicleType);
}
