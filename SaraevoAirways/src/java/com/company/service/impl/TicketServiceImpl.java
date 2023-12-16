package com.company.service.impl;

import com.company.dao.Dao;
import com.company.model.Ticket;
import java.util.Set;
import com.company.service.TicketService;
import static java.util.stream.Collectors.toSet;

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
    
    @Override
    public Ticket getById(int id) {
        return ticketDao.read().stream().filter(ticket -> id == ticket.getId())
                .collect(toSet()).iterator().next();
    }
    
    @Override
    public Set<Ticket> getByFlightNumber(int flightNumber) {
        return ticketDao.read().stream().filter(ticket -> flightNumber == ticket.getFlightNumber())
                .collect(toSet());
    }
    
    @Override
    public Set<Ticket> getByLastName(String ticketOwnerLastName) {
        return ticketDao.read().stream().filter(ticket -> ticketOwnerLastName.equals(ticket.getTicketOwnerLastName()))
                .collect(toSet());
    }
    
}
