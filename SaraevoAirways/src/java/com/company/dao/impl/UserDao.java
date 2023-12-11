package com.company.dao.impl;

import com.company.dao.Dao;
import com.company.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import javax.sql.DataSource;

public class UserDao implements Dao<User> {
    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public int create(User user) {
        try (Connection conn = dataSource.getConnection()) { 
            int id;
            
            String sql = "INSERT INTO users(login, password, last_name, first_name, sur_name, email) values(?,?,?,?,?,?)"; 
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) { 
                preparedStatement.setString(1, user.getLogin()); 
                preparedStatement.setString(2,user.getPassword());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setString(4, user.getFirstName());
                preparedStatement.setString(5, user.getSurName());
                preparedStatement.setString(6, user.getEmail());
                int affectedRows = preparedStatement.executeUpdate(); 

                if (affectedRows == 0) { 
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                sql = "SELECT * FROM users ORDER BY id DESC LIMIT 1"; 
                try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                    if (rs.next()) { 
                        id = rs.getInt("id"); 
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained");
                    }
                }
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        } 
    }

    @Override
    public Set<User> read() {
        String req = "SELECT * from users";
        Set<User> users;
        try (Connection conn = dataSource.getConnection()) {            
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(req)) {
                users = new HashSet<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String login = rs.getString("login");
                    String password = rs.getString("password");
                    String lastName = rs.getString("last_name");
                    String firstName = rs.getString("first_name");
                    String surName = rs.getString("sur_name");
                    String email = rs.getString("email");
                    users.add(new User(id, login, password, lastName, firstName, surName, email));
                }
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } 
    }

    @Override
    public int update(User user) {
        try (Connection conn = dataSource.getConnection()) {
            String query = "UPDATE users SET login = ?, password = ?, last_name = ?, first_name = ?, sur_name = ?, email = ? WHERE id = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, user.getLogin());
                pst.setString(2, user.getPassword());
                pst.setString(3, user.getLastName());
                pst.setString(4, user.getFirstName());
                pst.setString(5, user.getSurName());
                pst.setString(6, user.getEmail());
                pst.setInt(7, user.getId());
                return pst.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(User user) {
        try (Connection conn = dataSource.getConnection()) {            
            String query = "DELETE FROM users WHERE id = ?";
            try (PreparedStatement preparedStmt = conn.prepareStatement(query)) {
                preparedStmt.setInt(1, user.getId());
                int res = preparedStmt.executeUpdate();
                return res;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}
