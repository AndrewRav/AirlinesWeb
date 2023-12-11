package com.company.model;

import java.util.Objects;

public class Ticket {
    private int id, flightNumber, seat;
    private String departurePoint, destinationPoint, departureTime, arrivalTime, airplaneType, ticketOwnerFirstName, ticketOwnerLastName, ticketOwnerSurName;

    public Ticket(int id, int flightNumber, int seat, String departurePoint, String destinationPoint, String departureTime, String arrivalTime, String airplaneType, String ticketOwnerFirstName, String ticketOwnerLastName, String ticketOwnerSurName) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.seat = seat;
        this.departurePoint = departurePoint;
        this.destinationPoint = destinationPoint;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airplaneType = airplaneType;
        this.ticketOwnerFirstName = ticketOwnerFirstName;
        this.ticketOwnerLastName = ticketOwnerLastName;
        this.ticketOwnerSurName = ticketOwnerSurName;
    }
    
    public Ticket(int id) {
        this.id = id;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public String getTicketOwnerFirstName() {
        return ticketOwnerFirstName;
    }

    public void setTicketOwnerFirstName(String ticketOwnerFirstName) {
        this.ticketOwnerFirstName = ticketOwnerFirstName;
    }

    public String getTicketOwnerLastName() {
        return ticketOwnerLastName;
    }

    public void setTicketOwnerLastName(String ticketOwnerLastName) {
        this.ticketOwnerLastName = ticketOwnerLastName;
    }

    public String getTicketOwnerSurName() {
        return ticketOwnerSurName;
    }

    public void setTicketOwnerSurName(String ticketOwnerSurName) {
        this.ticketOwnerSurName = ticketOwnerSurName;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", flightNumber=" + flightNumber + ", seat=" + seat + ", departurePoint=" + departurePoint + ", destinationPoint=" + destinationPoint + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", airplaneType=" + airplaneType + ", ticketOwnerFirstName=" + ticketOwnerFirstName + ", ticketOwnerLastName=" + ticketOwnerLastName + ", ticketOwnerSurName=" + ticketOwnerSurName + '}';
    }

}
