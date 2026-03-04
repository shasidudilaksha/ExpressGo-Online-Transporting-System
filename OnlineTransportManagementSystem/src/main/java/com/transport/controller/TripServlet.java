package com.transport.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.transport.model.Trip;
import com.transport.service.TripService;

@WebServlet("/trips")
public class TripServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        TripService tripService = new TripService();

        try {
            if ("add".equals(action)) {
                Trip trip = new Trip();
                trip.setDriverId(Integer.parseInt(request.getParameter("driverId")));
                trip.setVehicleId(Integer.parseInt(request.getParameter("vehicleId")));
                trip.setRouteId(Integer.parseInt(request.getParameter("routeId")));
                trip.setDate(java.sql.Date.valueOf(request.getParameter("date")));
                tripService.addTrip(trip);
                response.sendRedirect("trips.jsp");
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("tripId"));
                tripService.deleteTrip(id);
                response.sendRedirect("trips.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
