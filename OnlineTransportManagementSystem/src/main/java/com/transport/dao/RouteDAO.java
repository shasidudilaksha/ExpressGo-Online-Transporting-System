package com.transport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.transport.model.Route;
import com.transport.util.DBConnection;

public class RouteDAO {

    // Insert a new route
    public boolean insert(Route route) throws SQLException {
        String sql = "INSERT INTO routes (start_location, end_location) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, route.getStartLocation());
            stmt.setString(2, route.getEndLocation());
            return stmt.executeUpdate() > 0;
        }
    }

    // Update an existing route
    public boolean update(Route route) throws SQLException {
        String sql = "UPDATE routes SET start_location = ?, end_location = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, route.getStartLocation());
            stmt.setString(2, route.getEndLocation());
            stmt.setInt(3, route.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    // Delete a route by ID
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM routes WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    // Get route by ID
    public Route getById(int id) {
        String sql = "SELECT * FROM routes WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Route route = new Route();
                route.setId(rs.getInt("id"));
                route.setStartLocation(rs.getString("start_location"));
                route.setEndLocation(rs.getString("end_location"));
                return route;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no route is found
    }
}
