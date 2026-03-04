package com.transport.dao;

import com.transport.model.Driver;
import com.transport.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {

    // Insert new driver
    public int insert(Driver driver) {
    	
        String sql = "INSERT INTO drivers (driver_id, name, license_number, contact, nic) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
            stmt.setInt(1, driver.getDriverId());
            stmt.setString(2, driver.getName());
            stmt.setString(3, driver.getLicenseNumber());
            stmt.setString(4, driver.getContact());
            stmt.setString(5, driver.getNic());
            return stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Update existing driver
    public boolean updateDriver(Driver driver) {
        String sql = "UPDATE drivers SET name = ?, license_number = ?, contact = ?, nic = ? WHERE driver_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, driver.getName());
            stmt.setString(2, driver.getLicenseNumber());
            stmt.setString(3, driver.getContact());
            stmt.setString(4, driver.getNic());
            stmt.setInt(5, driver.getDriverId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Delete driver
    public int delete(int driverId) {
        String sql = "DELETE FROM drivers WHERE driver_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, driverId);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Get all drivers
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM drivers";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Driver d = new Driver();
                d.setDriverId(rs.getInt("driver_id"));
                d.setName(rs.getString("name"));
                d.setLicenseNumber(rs.getString("license_number"));
                d.setContact(rs.getString("contact"));
                d.setNic(rs.getString("nic"));
                drivers.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    // Get driver by ID
    public Driver getById(int id) {
        String sql = "SELECT * FROM drivers WHERE driver_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Driver driver = new Driver();
                    driver.setDriverId(rs.getInt("driver_id"));
                    driver.setName(rs.getString("name"));
                    driver.setLicenseNumber(rs.getString("license_number"));
                    driver.setContact(rs.getString("contact"));
                    driver.setNic(rs.getString("nic"));
                    return driver;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
