package com.transport.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.transport.service.RouteService;

@WebServlet("/routes")
public class RouteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("routes.jsp").forward(request, response);
    }

    // Handle POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String action = request.getParameter("action");
        RouteService routeService = new RouteService();

        try {
            switch (action) {
                case "add":
                    String startLocation = request.getParameter("startLocation");
                    String endLocation = request.getParameter("endLocation");
                    routeService.addRoute(startLocation, endLocation);
                    response.sendRedirect("routes.jsp?message=Route added successfully");
                    break;
                case "update":
                    int routeId = Integer.parseInt(request.getParameter("routeId"));
                    String newStartLocation = request.getParameter("startLocation");
                    String newEndLocation = request.getParameter("endLocation");
                    routeService.updateRoute(routeId, newStartLocation, newEndLocation);
                    response.sendRedirect("routes.jsp?message=Route updated successfully");
                    break;
                case "delete":
                    int id = Integer.parseInt(request.getParameter("routeId"));
                    routeService.deleteRoute(id);
                    response.sendRedirect("routes.jsp?message=Route deleted successfully");
                    break;
                default:
                    response.sendRedirect("routes.jsp?error=Invalid action");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("routes.jsp?error=" + e.getMessage());
        }
    }
}
