package com.cscie97.ists.manage;

import com.cscie97.ists.authentication.AuthTokenTuple;
import com.cscie97.ists.resource.Spaceship;

public class Flight {

    String id;
    String number;
    Spaceship spaceship;
    String time;
    String location;
    String destination;
    String duration;
    Integer numStops;
    Integer capacity;
    String crewId;
    Integer ticketPrice;
    Integer passengerCount = 0;
    
    public Flight(String id, String number, Spaceship spaceship, String time, String location, String destination, String duration, Integer numStops
            , Integer capacity, String crewId, Integer ticketPrice, Integer passengerCount)
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
}
