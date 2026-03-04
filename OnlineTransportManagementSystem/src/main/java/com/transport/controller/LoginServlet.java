package com.transport.controller;

import com.transport.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminService adminService = new AdminService();

        try {
            if (adminService.validateAdmin(username, password)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("username", username);
                session.setAttribute("loggedIn", true);

                logger.log(Level.INFO, "Login successful for user: {0}", username);
                response.sendRedirect("drivers.jsp");
            } else {
                logger.log(Level.WARNING, "Invalid login attempt for user: {0}", username);
                response.sendRedirect("login.jsp?error=invalid");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Login error", e);
            response.sendRedirect("login.jsp?error=server");
        }
    }
}
