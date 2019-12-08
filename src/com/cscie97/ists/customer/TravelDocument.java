package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthTokenTuple;

public class TravelDocument {
    
    public LinkedHashMap<String, WelcomePackage> welcomePackages;

    public TravelDocument(String id, String flightId, String ticketId, String passengerName, String destination, String dateTime, Integer price
            , String boardPassIpnsKeyName, String passportId, String visaId, WelcomePackage welcomePackage)
    {
        
    }
    
    /* Methods */
    
    public void addPassportId(String passengerId, String passportId, AuthTokenTuple authTokenTuple)
    {
        
    }
    
    public void addVisaId(String passengerId, String passportId, AuthTokenTuple authTokenTuple)
    {
        
    }
    
    public void addWelcomePackage(WelcomePackage welcomePackage, AuthTokenTuple authTokenTuple)
    {
        // Add to list
    }
}
