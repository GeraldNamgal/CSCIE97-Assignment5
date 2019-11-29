package com.cscie97.ists.manage;

public interface FlightManagementService {

    public Flight defineFlight(String id, String number, String time, String location, String destination, String duration, Integer numStops
            , Integer capacity, String crewId, Integer ticketPrice, Integer passengerCount);
}
