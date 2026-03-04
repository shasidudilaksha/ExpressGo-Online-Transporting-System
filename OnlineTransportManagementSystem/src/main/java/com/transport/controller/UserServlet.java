package com.transport.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.transport.model.User;
import com.transport.service.UserService;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        UserService userService = new UserService();

        try {
            if ("add".equals(action)) {
                User user = new User();
                user.setUsername(request.getParameter("username"));
                user.setPassword(request.getParameter("password"));
                user.setRole(request.getParameter("role"));
                userService.addUser(user);
                response.sendRedirect("users.jsp");
            } else if ("update".equals(action)) {
                User user = new User();
                user.setUserId(Integer.parseInt(request.getParameter("userId")));
                user.setUsername(request.getParameter("username"));
                user.setPassword(request.getParameter("password"));
                user.setRole(request.getParameter("role"));
                userService.updateUser(user);
                response.sendRedirect("users.jsp");
            } else if ("delete".equals(action)) {
                int userId = Integer.parseInt(request.getParameter("userId"));
                userService.deleteUser(userId);
                response.sendRedirect("users.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
