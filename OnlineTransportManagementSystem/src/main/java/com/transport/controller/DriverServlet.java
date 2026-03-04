package com.transport.controller;

import com.transport.model.Driver;
import com.transport.service.DriverService;
import com.transport.util.DriverPDFGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class DriverServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DriverService driverService = new DriverService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Load and show the driver list page
        List<Driver> driverList = driverService.getAllDrivers();
        request.setAttribute("driverList", driverList);
        request.getRequestDispatcher("/drivers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("printPDF".equals(action)) {
                List<Driver> driverList = driverService.getAllDrivers();

                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=driver_list.pdf");

                DriverPDFGenerator.generateDriverListPDF(driverList, response.getOutputStream());
                response.getOutputStream().flush();
                return;
            }

            // Safely parse input fields
            int driverId = parseInteger(request.getParameter("driver_id"));
            String name = request.getParameter("name");
            String license = request.getParameter("license_number");
            String contact = request.getParameter("contact");
            String nic = request.getParameter("nic");

            switch (action) {
                case "add":
                    driverService.addDriver(driverId, name, license, contact, nic);
                    break;

                case "update":
                    driverService.updateDriver(driverId, name, license, contact, nic);
                    break;

                case "delete":
                    driverService.deleteDriver(driverId);
                    break;

                default:
                    throw new IllegalArgumentException("Unknown action: " + action);
            }

            // After add/update/delete, fetch list and forward to Viewdriverdetails.jsp
            List<Driver> updatedList = driverService.getAllDrivers();
            request.setAttribute("driverList", updatedList);
            request.getRequestDispatcher("/Viewdriverdetails.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error processing driver data: " + e.getMessage());
            request.getRequestDispatcher("/drivers.jsp").forward(request, response);
        }
    }

    private int parseInteger(String str) {
        try {
            return (str != null && !str.isEmpty()) ? Integer.parseInt(str) : 0;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
