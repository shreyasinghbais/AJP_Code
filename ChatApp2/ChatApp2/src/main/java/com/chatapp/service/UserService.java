package com.chatapp.service;

import com.chatapp.dao.UserDAO;
import com.chatapp.model.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name) {
        User user = new User();
        user.setName(name);
        userDAO.addUser(user);
    }

    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
