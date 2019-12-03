package com.cscie97.ists.manage;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthTokenTuple;

public interface FlightManagementService {

    public Flight defineFlight(String id, String number, String time, String location, String destination, String duration, Integer numStops
            , Integer capacity, String crewId, Integer ticketPrice, Integer passengerCount, AuthTokenTuple authTokenTuple);
    public LinkedHashMap<String, Flight> getFlights(AuthTokenTuple authTokenTuple);
}
