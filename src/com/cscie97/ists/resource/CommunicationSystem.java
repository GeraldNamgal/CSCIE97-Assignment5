package com.cscie97.ists.resource;

import com.cscie97.ists.authentication.AuthTokenTuple;

public class CommunicationSystem {

    String id;
    String status;
    Integer upTime; // Time in minutes
    
    public CommunicationSystem(String id)
    {
        this.id = id;
        
    }
    
    public String[] createEvent(Spaceship sourceDevice, String simulatedEvent)
    {
        String[] eventToSend = sourceDevice.event(simulatedEvent);
        
        return eventToSend;
    }
}
