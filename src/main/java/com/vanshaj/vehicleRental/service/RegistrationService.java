package com.vanshaj.vehicleRental.service;

import com.vanshaj.vehicleRental.dto.BranchDto;
import com.vanshaj.vehicleRental.dto.VehicleDto;

public interface RegistrationService {
    public Boolean addBranch(BranchDto branchDto);
    public Boolean addVehicle(VehicleDto vehicleDto);
}
