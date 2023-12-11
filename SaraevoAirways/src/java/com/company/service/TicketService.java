package com.company.service;

import com.company.model.Ticket;
import java.util.Set;

public interface TicketService {
    boolean create(Ticket ticket);
    Set<Ticket> read();
    boolean update(int id, int newFlightNumber, int newSeat, String newDeparturePoint, String newDestinationPoint, String newDepartureTime, String newArrivalTime, String newAirplaneType, String newTicketOwnerFirstName, String newTicketOwnerLastName, String newTicketOwnerSurName);
    boolean delete(int id);
}
