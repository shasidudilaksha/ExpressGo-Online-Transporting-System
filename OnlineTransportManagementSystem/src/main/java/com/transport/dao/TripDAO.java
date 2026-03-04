package com.transport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.transport.model.Trip;
import com.transport.util.DBConnection;

public class TripDAO implements CrudOperations<Trip> {

    // Insert a new trip
    @Override
    public boolean insert(Trip trip) {
        String sql = "INSERT INTO trips (driver_id, vehicle_id, route_id, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, trip.getDriverId());
            stmt.setInt(2, trip.getVehicleId());
            stmt.setInt(3, trip.getRouteId());
            stmt.setDate(4, trip.getDate());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update an existing trip
    @Override
    public boolean update(Trip trip) {
        String sql = "UPDATE trips SET driver_id = ?, vehicle_id = ?, route_id = ?, date = ? WHERE trip_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, trip.getDriverId());
            stmt.setInt(2, trip.getVehicleId());
            stmt.setInt(3, trip.getRouteId());
            stmt.setDate(4, trip.getDate());
            stmt.setInt(5, trip.getTripId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a trip by ID
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM trips WHERE trip_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get trip by ID
    @Override
    public Trip getById(int id) {
        String sql = "SELECT * FROM trips WHERE trip_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Trip trip = new Trip();
                trip.setTripId(rs.getInt("trip_id"));
                trip.setDriverId(rs.getInt("driver_id"));
                trip.setVehicleId(rs.getInt("vehicle_id"));
                trip.setRouteId(rs.getInt("route_id"));
                trip.setDate(rs.getDate("date"));
                return trip;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public List<Trip> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
