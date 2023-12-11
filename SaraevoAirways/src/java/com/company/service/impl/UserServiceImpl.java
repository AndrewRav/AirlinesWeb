package com.company.service.impl;

import com.company.dao.Dao;
import com.company.model.User;
import com.company.service.UserService;
import java.util.Set;

public class UserServiceImpl implements UserService {
    Dao<User> userDao;

    public UserServiceImpl(Dao userDao) {
        this.userDao = userDao;
    }
    
    @Override
    public boolean create(User user) {
        return userDao.create(user) > 0;
    }

    @Override
    public Set<User> read() {
        return userDao.read();
    }
    
    @Override
    public boolean update(int id, String newLogin, String newPassword, String newLastName, String newFirstName, String newSurName, String newEmail) {
        User user = new User(id);
    	user.setLogin(newLogin);
        user.setPassword(newPassword);
        user.setLastName(newLastName);
        user.setFirstName(newFirstName);
        user.setSurName(newSurName);
        user.setEmail(newEmail);
        return userDao.update(user) > 0;
    }

    @Override
    public boolean delete(int id) {
        User user = new User(id);
        return userDao.delete(user) > 0;
    }

    @Override
    public User getById(int id) {
        return userDao.read().stream().filter(user -> id == user.getId())
                .findFirst().orElse(null);
    }
    
    @Override
    public User login(String login, String password) {
        return userDao.read().stream().filter(user -> login.equals(user.getLogin()) && password.equals(user.getPassword()))
                .findFirst().orElse(null);
    }
}
