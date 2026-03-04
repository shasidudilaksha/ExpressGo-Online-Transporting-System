package com.transport.service;

import com.transport.dao.TripDAO;
import com.transport.model.Trip;

public class TripService {
    private TripDAO tripDAO = new TripDAO();
    public boolean addTrip(Trip trip) {
        return tripDAO.insert(trip);
    }
    public boolean updateTrip(Trip trip) {
        return tripDAO.update(trip);
    }
    public boolean deleteTrip(int id) {
        return tripDAO.delete(id);
    }
    public Trip getTripById(int id) {
        return tripDAO.getById(id);
    }
}