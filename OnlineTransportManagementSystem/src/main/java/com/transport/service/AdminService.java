package com.transport.service;

import com.transport.dao.AdminDAO;
import com.transport.model.Admin;

public class AdminService {
   private final AdminDAO adminDAO = new AdminDAO();
   
 // Hardcoded dummy login check for demo
   public boolean validateAdmin(String username, String password) {
       // Replace with DB validation logic. This is just a placeholder.
       return "ishan".equals(username) && "ishan123".equals(password);
   }
  // Add a new admin
    public boolean addAdmin(Admin admin) {
        try {
            return adminDAO.insert(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update an existing admin
    public boolean updateAdmin(Admin admin) {
        try {
            return adminDAO.update(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete an admin by ID
    public boolean deleteAdmin(int id) {
        try {
            return adminDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get an admin by ID
    public Admin getAdminById(int id) {
        try {
            return adminDAO.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get admin by username (used in session/dashboard)
    public Admin getAdminByUsername(String username) {
        try {
            return adminDAO.getByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Validate admin credentials and return full Admin object (optional)
    public Admin login(String username, String password) {
        try {
            Admin admin = adminDAO.getByUsername(username);
            if (admin != null && admin.getPassword().equals(password)) {
                return admin;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

   
}
