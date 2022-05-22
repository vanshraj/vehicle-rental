package com.vanshaj.vehicleRental.repository.impl;

import com.vanshaj.vehicleRental.model.Branch;
import com.vanshaj.vehicleRental.repository.BranchRepository;
import lombok.Data;

import java.util.*;

@Data
public class BranchRepositoryImpl implements BranchRepository {
    Map<String, Branch> branchMap;

    @Override
    public void add(Branch branch) {
        if(branchMap==null) branchMap = new HashMap<>();
        branchMap.put(branch.getName(),branch);
    }

    @Override
    public Branch getBranch(String name) {
        if(branchMap==null) return null;
        return branchMap.get(name);
    }

    @Override
    public Boolean supports(String branchName, String vehicleType) {
        if(branchMap==null) return false;
        Branch branch = branchMap.get(branchName);
        return (branch!=null && branch.getSupportedType().contains(vehicleType));
    }

    @Override
    public Boolean containsVehicle(String branchName, String vehicleType, String vehicleId) {
        if(!supports(branchName,vehicleType)) return false;
        if(branchMap.get(branchName).getVehiclesSet().get(vehicleType)==null) return false;
        return branchMap.get(branchName).getVehiclesSet().get(vehicleType).contains(vehicleId);
    }

    @Override
    public void addVehicle(String branchName, String vehicleType, String vehicleId) {
        Branch branch = getBranch(branchName);
        Map<String, Set<String>> vehiclesSet = branch.getVehiclesSet();
        if (!vehiclesSet.containsKey(vehicleType)) {
            vehiclesSet.put(vehicleType, new HashSet<>());
        }
        vehiclesSet.get(vehicleType).add(vehicleId);
    }

    @Override
    public Set<String> getVehicles(String branchName, String vehicleType) {
        return branchMap.get(branchName).getVehiclesSet().get(vehicleType);
    }
}
