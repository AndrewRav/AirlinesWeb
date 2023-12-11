package com.company.dao.impl;

import com.company.dao.Dao;
import com.company.model.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import javax.sql.DataSource;

public class TicketDao implements Dao<Ticket> {
    private final DataSource dataSource;
    
    public TicketDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public int create(Ticket ticket) {
        try (Connection conn = dataSource.getConnection()) {
            int id;
            
            String sql = "INSERT INTO tickets(flight_number, seat, departure_point, destination_point, departure_time, arrival_time, airplane_type, ticket_owner_first_name, ticket_owner_last_name, ticket_owner_sur_name) values(?,?,?,?,?,?,?,?,?,?)"; // Формирование запроса добавления
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) { 
                preparedStatement.setInt(1, ticket.getFlightNumber()); 
                preparedStatement.setInt(2, ticket.getSeat());
                preparedStatement.setString(3, ticket.getDeparturePoint());
                preparedStatement.setString(4, ticket.getDestinationPoint());
                preparedStatement.setString(5, ticket.getDepartureTime());
                preparedStatement.setString(6, ticket.getArrivalTime());
                preparedStatement.setString(7, ticket.getAirplaneType());
                preparedStatement.setString(8, ticket.getTicketOwnerFirstName());
                preparedStatement.setString(9, ticket.getTicketOwnerLastName());
                preparedStatement.setString(10, ticket.getTicketOwnerSurName());
                int affectedRows = preparedStatement.executeUpdate(); 

                if (affectedRows == 0) { 
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                sql = "SELECT * FROM tickets ORDER BY id DESC LIMIT 1";
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
    public Set<Ticket> read() {
        String req = "SELECT * from tickets";
        Set<Ticket> tickets;
        try (Connection conn = dataSource.getConnection()) {            
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(req)) {
                tickets = new HashSet<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int flightNumber = rs.getInt("flight_number");
                    int seat = rs.getInt("seat");
                    String departurePoint = rs.getString("departure_point");
                    String destinationPoint = rs.getString("destination_point");
                    String departureTime = rs.getString("departure_time");
                    String arrivalTime = rs.getString("arrival_time");
                    String airplaneType = rs.getString("airplane_type");
                    String ticketOwnerFirstName = rs.getString("ticket_owner_first_name");
                    String ticketOwnerLastName = rs.getString("ticket_owner_last_name");
                    String ticketOwnerSurName = rs.getString("ticket_owner_sur_name");
                    tickets.add(new Ticket(id, flightNumber, seat, departurePoint, destinationPoint, departureTime, arrivalTime, airplaneType, ticketOwnerFirstName, ticketOwnerLastName, ticketOwnerSurName));
                }
            }
            return tickets;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } 
    }

    @Override
    public int update(Ticket ticket) {
        try (Connection conn = dataSource.getConnection()) {
            String query = "UPDATE tickets SET flight_number = ?, seat = ?, departure_point = ?, destination_point = ?, departure_time = ?, arrival_time = ?, airplane_type = ?, ticket_owner_first_name = ?, ticket_owner_last_name = ?, ticket_owner_sur_name = ? WHERE id = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, ticket.getFlightNumber());
                pst.setInt(2, ticket.getSeat());
                pst.setString(3, ticket.getDeparturePoint());
                pst.setString(4, ticket.getDestinationPoint());
                pst.setString(5, ticket.getDepartureTime());
                pst.setString(6, ticket.getArrivalTime());
                pst.setString(7, ticket.getAirplaneType());
                pst.setString(8, ticket.getTicketOwnerFirstName());
                pst.setString(9, ticket.getTicketOwnerLastName());
                pst.setString(10, ticket.getTicketOwnerSurName());
                pst.setInt(11, ticket.getId());
                return pst.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Ticket ticket) {
        try (Connection conn = dataSource.getConnection()) {            
            String query = "DELETE FROM tickets WHERE id = ?";
            try (PreparedStatement preparedStmt = conn.prepareStatement(query)) {
                preparedStmt.setInt(1, ticket.getId());
                int res = preparedStmt.executeUpdate();
                return res;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
}
