package com.cscie97.ists.customer;

public class FlightBooking {

    public FlightBooking(String id, Flight flight, String destination, Passenger passenger, Integer price, String type
            , String departureTime, String returnTime)
    {

        // Increase flight's passenger count
        flight.updatePassengerCount(1, null);
    }
}
