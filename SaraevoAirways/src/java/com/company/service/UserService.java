package com.company.service;

import com.company.model.User;
import java.util.Set;

public interface UserService {
    boolean create(User user);
    Set<User> read();
    boolean update(int id, String newLogin, String newPassword, String newLastName, String newFirstName, String newSurName, String newEmail);
    boolean delete(int id);
    User getById(int id);
    User login(String email, String password);
}
