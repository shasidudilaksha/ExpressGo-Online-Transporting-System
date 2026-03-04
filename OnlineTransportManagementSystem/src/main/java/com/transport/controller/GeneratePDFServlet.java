package com.transport.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.transport.model.Driver;
import com.transport.service.DriverService;
import com.transport.util.DriverPDFGenerator;
import java.util.List;

@WebServlet("/generateDriverPDF")
public class GeneratePDFServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DriverService driverService = new DriverService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Driver> drivers = driverService.getAllDrivers();

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=DriverList.pdf");

            DriverPDFGenerator.generateDriverListPDF(drivers, response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating PDF");
        }
    }
}
