package com.vanshaj.vehicleRental.service.impl;

import com.vanshaj.vehicleRental.model.Branch;
import com.vanshaj.vehicleRental.model.Vehicle;
import com.vanshaj.vehicleRental.dto.BranchDto;
import com.vanshaj.vehicleRental.dto.VehicleDto;
import com.vanshaj.vehicleRental.repository.BranchRepository;
import com.vanshaj.vehicleRental.repository.VehicleRepository;
import com.vanshaj.vehicleRental.service.RegistrationService;

import java.util.*;

public class RegistrationServiceImpl implements RegistrationService {
    private final BranchRepository branchRepository;
    private final VehicleRepository vehicleRepository;

    public RegistrationServiceImpl(BranchRepository branchRepository, VehicleRepository vehicleRepository) {
        this.branchRepository = branchRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Boolean addBranch(BranchDto branchDto) {
        if (branchRepository.getBranch(branchDto.getName()) != null) {
            return false;
        }
        Branch branch = new Branch();
        branch.setName(branchDto.getName());
        branch.setSupportedType(branchDto.getSupportedType());
        branch.setVehiclesSet(new HashMap<>());
        branchRepository.add(branch);
        return true;
    }

    @Override
    public Boolean addVehicle(VehicleDto vehicleDto) {
        if(vehicleRepository.getVehicle(vehicleDto.getId())!=null)
            return false;
        if(!branchRepository.supports(vehicleDto.getBranchName(),vehicleDto.getType()))
            return false;
        if(branchRepository.containsVehicle(vehicleDto.getBranchName(),
                vehicleDto.getType(),vehicleDto.getId()))
            return false;
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDto.getId());
        vehicle.setPrice(vehicleDto.getPrice());
        vehicle.setType(vehicleDto.getType());
        vehicleRepository.add(vehicle);
        branchRepository.addVehicle(vehicleDto.getBranchName(),
                vehicleDto.getType(),vehicleDto.getId());
        return true;
    }
}
