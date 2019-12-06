package com.cscie97.ists.customer;

import com.cscie97.ists.authentication.AuthTokenTuple;
import com.cscie97.ists.resource.Spaceship;
import com.cscie97.ists.resource.Team;

public class Flight {

    public String id;
    public String number;
    public Spaceship spaceship;
    public String time;
    public String location;
    public String destination;
    public String duration;
    public Integer numStops;
    public Integer capacity;
    public Team crewId;
    public Integer ticketPrice;
    public Integer passengerCount = 0;
    public String status;
    
    public Flight(String id, String number, Spaceship spaceship, String time, String location, String destination, String duration, Integer numStops
            , Integer capacity, Team crewId, Integer ticketPrice, Integer passengerCount)
    {
        this.id = id;
        this.number = number;
        this.spaceship = spaceship;
        this.time = time;
        this.location = location;
        this.destination = destination;
        this.duration = duration;
        this.numStops = numStops;
        this.capacity = capacity;
        this.crewId = crewId;
        this.ticketPrice = ticketPrice;
        this.passengerCount = passengerCount;
    }
    
    /* Methods */
    
    public void updatePassengerCount(Integer amount, AuthTokenTuple authTokenTuple)
    {
        // Update count
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }   
}
