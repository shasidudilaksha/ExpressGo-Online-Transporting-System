package com.transport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.transport.model.Vehicle;
import com.transport.util.DBConnection;

public class VehicleDAO implements CrudOperations<Vehicle> {

    // Insert a new vehicle
    @Override
    public boolean insert(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (model, registration_number, capacity) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getModel());
            stmt.setString(2, vehicle.getRegistrationNumber());
            stmt.setInt(3, vehicle.getCapacity());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update an existing vehicle
    @Override
    public boolean update(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET model = ?, registration_number = ?, capacity = ? WHERE vehicle_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getModel());
            stmt.setString(2, vehicle.getRegistrationNumber());
            stmt.setInt(3, vehicle.getCapacity());
            stmt.setInt(4, vehicle.getVehicleId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a vehicle
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM vehicles WHERE vehicle_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get a vehicle by ID
    @Override
    public Vehicle getById(int id) {
        String sql = "SELECT * FROM vehicles WHERE vehicle_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("vehicle_id"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setRegistrationNumber(rs.getString("registration_number"));
                vehicle.setCapacity(rs.getInt("capacity"));
                return vehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public List<Vehicle> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
