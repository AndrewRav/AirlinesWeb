package com.company.service.impl;

import com.company.dao.Dao;
import com.company.model.Ticket;
import java.util.Set;
import com.company.service.TicketService;

public class TicketServiceImpl implements TicketService {
    Dao<Ticket> ticketDao;

    public TicketServiceImpl(Dao airplaneDao) {
        this.ticketDao = airplaneDao;
    }

    @Override
    public boolean create(Ticket ticket) {
        return ticketDao.create(ticket) > 0;
    }

    @Override
    public Set<Ticket> read() {
        return ticketDao.read();
    }
    
    @Override
    public boolean update(int id, int newFlightNumber, int newSeat, String newDeparturePoint, String newDestinationPoint, String newDepartureTime, String newArrivalTime, String newAirplaneType, String newTicketOwnerFirstName, String newTicketOwnerLastName, String newTicketOwnerSurName) {
        Ticket ticket = new Ticket(id);
        ticket.setFlightNumber(newFlightNumber);
        ticket.setSeat(newSeat);
        ticket.setDeparturePoint(newDeparturePoint);
        ticket.setDestinationPoint(newDestinationPoint);
        ticket.setDepartureTime(newDepartureTime);
        ticket.setArrivalTime(newArrivalTime);
        ticket.setAirplaneType(newAirplaneType);
        ticket.setTicketOwnerFirstName(newTicketOwnerFirstName);
        ticket.setTicketOwnerLastName(newTicketOwnerLastName);
        ticket.setTicketOwnerSurName(newTicketOwnerSurName);
        return ticketDao.update(ticket) > 0;
    }

    @Override
    public boolean delete(int id) {
        Ticket ticket = new Ticket(id);
        return ticketDao.delete(ticket) > 0;
    }
    
}
