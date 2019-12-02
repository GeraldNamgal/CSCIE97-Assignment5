package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

public class TravelDocument {
    
    public LinkedHashMap<String, WelcomePackage> welcomePackages;

    public TravelDocument(String flightNumber, String ticketId, String passengerId, String destination, String dateTime, Integer price
            , String boardPassIpnsKeyName, String passportId, String visaId)
    {
        
    }
    
    /* Methods */
    
    public void addWelcomePackage(WelcomePackage welcomePackage)
    {
        // Add to list
    }
}
