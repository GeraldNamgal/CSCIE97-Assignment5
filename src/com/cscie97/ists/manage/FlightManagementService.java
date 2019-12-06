package com.cscie97.ists.manage;

import com.cscie97.ists.authentication.AuthTokenTuple;
import com.cscie97.ists.customer.Flight;

public interface FlightManagementService {

    public Flight defineFlight(String id, String number, String spaceshipId, String time, String location, String destination, String duration, Integer numStops
            , Integer capacity, String crewId, Integer ticketPrice, Integer passengerCount, AuthTokenTuple authTokenTuple);
}
