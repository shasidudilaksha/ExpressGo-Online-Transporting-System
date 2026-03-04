package com.transport.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.transport.model.Vehicle;
import com.transport.service.VehicleService;

@WebServlet("/vehicles")
public class VehicleServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        VehicleService vehicleService = new VehicleService();

        try {
            if ("add".equals(action)) {
                Vehicle vehicle = new Vehicle();
                vehicle.setModel(request.getParameter("model"));
                vehicle.setRegistrationNumber(request.getParameter("registrationNumber"));
                vehicle.setCapacity(Integer.parseInt(request.getParameter("capacity")));
                vehicleService.addVehicle(vehicle);
                response.sendRedirect("vehicles.jsp");
            } else if ("update".equals(action)) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(Integer.parseInt(request.getParameter("vehicleId")));
                vehicle.setModel(request.getParameter("model"));
                vehicle.setRegistrationNumber(request.getParameter("registrationNumber"));
                vehicle.setCapacity(Integer.parseInt(request.getParameter("capacity")));
                vehicleService.updateVehicle(vehicle);
                response.sendRedirect("vehicles.jsp");
            } else if ("delete".equals(action)) {
                int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
                vehicleService.deleteVehicle(vehicleId);
                response.sendRedirect("vehicles.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
