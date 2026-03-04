package com.transport.service;

import com.transport.dao.DriverDAO;
import com.transport.model.Driver;

import java.sql.SQLException;
import java.util.List;

public class DriverService {

    private DriverDAO driverDAO = new DriverDAO();

    // Add a new driver
    public void addDriver(int driverId, String name, String licenseNumber, String contact, String nic) throws SQLException {
        Driver driver = new Driver();
        driver.setDriverId(driverId);
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driver.setContact(contact);
        driver.setNic(nic);

        driverDAO.insert(driver);
    }

    // Update an existing driver
    public boolean updateDriver(int driverId, String name, String licenseNumber, String contact, String nic) throws SQLException {
        Driver driver = new Driver();
        driver.setDriverId(driverId);
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driver.setContact(contact);
        driver.setNic(nic);

        return driverDAO.updateDriver(driver); // Delegate to DAO
    }

    // Delete a driver by ID
    public void deleteDriver(int driverId) throws SQLException {
        driverDAO.delete(driverId);
    }

    // Get all drivers
    public List<Driver> getAllDrivers() {
        return driverDAO.getAll();
    }
    public Driver getDriverById(int driverId) {
        return driverDAO.getById(driverId);
    }

}
