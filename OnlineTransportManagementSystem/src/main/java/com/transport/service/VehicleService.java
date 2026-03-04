package com.transport.service;

import com.transport.dao.VehicleDAO;
import com.transport.model.Vehicle;

public class VehicleService {
    private VehicleDAO vehicleDAO = new VehicleDAO();

    public boolean addVehicle(Vehicle vehicle) {
        return vehicleDAO.insert(vehicle);
    }

    public boolean updateVehicle(Vehicle vehicle) {
        return vehicleDAO.update(vehicle);
    }

    public boolean deleteVehicle(int id) {
        return vehicleDAO.delete(id);
    }

    public Vehicle getVehicleById(int id) {
        return vehicleDAO.getById(id);
    }
}
