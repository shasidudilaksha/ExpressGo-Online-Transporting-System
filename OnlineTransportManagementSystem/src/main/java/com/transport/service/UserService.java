package com.transport.service;

import com.transport.dao.UserDAO;
import com.transport.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public boolean addUser(User user) {
        return userDAO.insert(user);
    }

    public boolean updateUser(User user) {
        return userDAO.update(user);
    }

    public boolean deleteUser(int id) {
        return userDAO.delete(id);
    }

    public User getUserById(int id) {
        return userDAO.getById(id);
    }
}
