package com.cscie97.ists.manage;

import com.cscie97.ists.authentication.StoreAuthenticationService;
import com.cscie97.ists.resource.Observer;
import com.cscie97.ists.resource.ResourceManagementService;
import com.cscie97.ists.resource.Spaceship;
import com.cscie97.ists.resource.Subject;
import com.cscie97.ists.resource.UpdateEvent;
import com.cscie97.ists.manage.Command;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.cscie97.ists.authentication.AuthToken;


public class Manager implements Observer {

    /* Constructor */ 
    
    ResourceManagementService resourceImpl;
    StoreAuthenticationService authenticator;
    AuthToken myAuthToken;

    public Manager(Subject resourceImpl, StoreAuthenticationService authenticator)
    {       
        // Register Controller with Model Service
        resourceImpl.registerObserver(this);
        
        this.resourceImpl = (ResourceManagementService) resourceImpl;        
        this.authenticator = authenticator;
        
        // TODO: Can skip for design doc -- Login Manager
        //myAuthToken = authenticator.login("controller-pwd", "password");
    }
    
    @Override
    public void update(UpdateEvent event)
    {        
        handleEvent(event);
    }

    public void handleEvent(UpdateEvent event)
    {
        // Get event's string array
        String[] eventStrArr = event.getPerceivedEvent();
        
        String command = "";
        for (String string : eventStrArr)
        {
            command += string;
        }
       
        if (command.equals("Here."))
        {    
            System.out.println("");
            
            /*// Create new Emergency               
            Command emergency = new Emergency(event.getSourceDevice(), eventStrArr[1], eventStrArr[2]);
            
            System.out.println("\nEMERGENCY EVENT received. Emergency Command created and executing...");
            
            // Run the Command's execute method
            emergency.execute();*/
        }
    }
    
    public class Emergency extends Command
    {      
        /* Variables */
        
        
        
        public Emergency(Spaceship sourceDevice)
        {
            super(sourceDevice);            
        }

        public void execute()
        {
            
        }
            
    }
}
