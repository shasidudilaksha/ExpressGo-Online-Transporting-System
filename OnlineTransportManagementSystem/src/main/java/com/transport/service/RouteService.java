package com.transport.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.transport.dao.RouteDAO;
import com.transport.model.Route;
import com.transport.util.DBConnection;

public class RouteService {
    private RouteDAO routeDAO = new RouteDAO();

    // Add a route using Route object
    public boolean addRoute(Route route) {
        try {
            return routeDAO.insert(route);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update route using Route object
    public boolean updateRoute(Route route) {
        try {
            return routeDAO.update(route);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete route by ID
    public boolean deleteRoute(int id) {
        try {
            return routeDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get route by ID
    public Route getRouteById(int id) {
        return routeDAO.getById(id);
    }

    // Add a new route (directly using start and end location)
    public boolean addRoute(String startLocation, String endLocation) {
        String sql = "INSERT INTO routes (start_location, end_location) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, startLocation);
            stmt.setString(2, endLocation);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update an existing route by ID
    public boolean updateRoute(int id, String startLocation, String endLocation) {
        String sql = "UPDATE routes SET start_location = ?, end_location = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, startLocation);
            stmt.setString(2, endLocation);
            stmt.setInt(3, id);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a route by ID
    public boolean deleteRouteById(int id) {
        String sql = "DELETE FROM routes WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
