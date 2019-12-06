package com.cscie97.ists.manage;

import com.cscie97.ists.authentication.StoreAuthenticationService;
import com.cscie97.ists.customer.CustomerService;
import com.cscie97.ists.customer.Flight;
import com.cscie97.ists.resource.Entity;
import com.cscie97.ists.resource.Observer;
import com.cscie97.ists.resource.ResourceManagementService;
import com.cscie97.ists.resource.Spaceship;
import com.cscie97.ists.resource.Subject;
import com.cscie97.ists.resource.Team;
import com.cscie97.ists.resource.UpdateEvent;
import com.cscie97.ists.manage.Command;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthToken;
import com.cscie97.ists.authentication.AuthTokenTuple;


public class Manager implements Observer, FlightManagementService {

    /* Constructor */ 
    
    ResourceManagementService resourceImpl;
    CustomerService customerImpl;
    StoreAuthenticationService authenticator;
    AuthToken myAuthToken;    

    public Manager(Subject resourceImpl, CustomerService customerImpl, StoreAuthenticationService authenticator)
    {       
        // Register Controller with Model Service
        resourceImpl.registerObserver(this);
        
        this.resourceImpl = (ResourceManagementService) resourceImpl;
        this.customerImpl = customerImpl;
        this.authenticator = authenticator;
        
        // Login
        myAuthToken = null;
    }
    
    @Override
    public Flight defineFlight(String id, String number, String spaceshipId, String time, String location, String destination, String duration, Integer numStops
            , Integer capacity, String crewId, Integer ticketPrice, Integer passengerCount, AuthTokenTuple authTokenTuple)
    {        
        // Get spaceship
        LinkedHashMap<String, Spaceship> spaceships = resourceImpl.getSpaceships(new AuthTokenTuple(myAuthToken));
        Spaceship spaceship = spaceships.get(spaceshipId);
        
        // TODO: Check that spaceship isn't scheduled at the time requested?
        // for each flight
        //      if (time + duration overlaps flight.time + flight.duration) && (spaceship == flight.getSpaceship)
        //              throw new Exception
                        
        // Get team
        LinkedHashMap<String, Entity> entities = resourceImpl.getEntities(new AuthTokenTuple(myAuthToken));
        Team team = (Team) entities.get(crewId);
        
        // TODO: Check that crew isn't scheduled at the time requested?
        // for each flight
        //      if (time + duration overlaps flight.time + flight.duration) && (spaceship == flight.getSpaceship)
        //              throw new Exception
                
        // Create new flight
        Flight flight = new Flight(id, number, spaceship, time, location, destination, duration, numStops
                , capacity, team, ticketPrice, passengerCount);
        
        // Add flight to flights list in CustomerImpl
        LinkedHashMap<String, Flight> flights = customerImpl.getFlights(new AuthTokenTuple(myAuthToken));
        flights.put(id, flight);
        
        return flight;
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
        
        String eventString = "";
        for (String string : eventStrArr)
        {
            eventString += string + " ";
        }
        
        eventString = eventString.trim();
        
        if (eventString.equals("status update"))
        {        
            // Create new Emergency               
            Command statusUpdate = new StatusUpdateCommand(event.getSourceDevice(), "status string");            
            
            // Run the Command's execute method
            statusUpdate.execute();
        }
        
        if (eventString.equals("emergency"))
        {        
            // Create new Emergency               
            Command emergency = new EmergencyCommand(event.getSourceDevice());            
            
            // Run the Command's execute method
            emergency.execute();
        }        
        
        if (eventString.equals("Test ing"))
        {
            Command testCommand = new TestCommand(event.getSourceDevice());
            testCommand.execute();
        }
    }
    
    /* Nested classes */
    
    public class TestCommand extends Command
    {      
        /* Variables */        
        
        
        
        public TestCommand(Spaceship sourceDevice)
        {
            super(sourceDevice);            
        }

        public void execute()
        {
            
        }            
    }
    
    public class StatusUpdateCommand extends Command
    {      
        /* Variables */
        
        String status;
        
        public StatusUpdateCommand(Spaceship sourceDevice, String status)
        {
            super(sourceDevice);
            
            this.status = status;
        }

        public void execute()
        {
            // Change the flight's status            
            String currentFlightId = sourceDevice.getCurrentFlightId();
            LinkedHashMap<String, Flight> flights = customerImpl.getFlights(null);
            Flight flight = flights.get(currentFlightId);
            flight.setStatus(status, new AuthTokenTuple(myAuthToken));
            
            // If status update was "Reached destination" then also do ReachedDestinationCommand            
            if (status.equals("reached destination"))
            {             
                Command reachedDestination = new ReachedDestinationCommand(sourceDevice);            
                
                // Run the Command's execute method
                reachedDestination.execute();
            }
        }            
    }
    
    public class ReachedDestinationCommand extends Command
    {      
        /* Variables */
        
        
        
        public ReachedDestinationCommand(Spaceship sourceDevice)
        {
            super(sourceDevice);            
        }

        public void execute()
        {
            // TODO
            
            // Call Location Update command
            LocationUpdateCommand locationUpdate = new LocationUpdateCommand(sourceDevice, 0, "trajectory", "destinationCoordinates");
            locationUpdate.execute();
            
            // Push to IPFS
            String ipnsKeyName = customerImpl.getIpnsKeyName(new AuthTokenTuple(myAuthToken));
            customerImpl.pullFromIpfsRepo(new AuthTokenTuple(myAuthToken));
            customerImpl.pushToIpfsRepo(new AuthTokenTuple(myAuthToken));
        }            
    }
    
    public class LocationUpdateCommand extends Command
    {      
        /* Variables */        
        
        Integer speed;
        String trajectory;
        String coordinates;
        
        public LocationUpdateCommand(Spaceship sourceDevice, Integer speed, String trajectory, String coordinates)
        {
            super(sourceDevice);            
        }

        public void execute()
        {
            sourceDevice.setCurrentSpeed(speed, new AuthTokenTuple(myAuthToken));
            sourceDevice.setTrajectory(trajectory, new AuthTokenTuple(myAuthToken));
            sourceDevice.setCoordinates(coordinates, new AuthTokenTuple(myAuthToken));
        }            
    }
    
    public class EmergencyCommand extends Command
    {      
        /* Variables */        
        
        String emergencyType;
        
        public EmergencyCommand(Spaceship sourceDevice)
        {
            super(sourceDevice);            
        }

        public void execute()
        {
            // Get spaceship's location
            String coordinates = sourceDevice.coordinates;
            
            // Define rescue flight to send
            resourceImpl.defineSpaceship(null, null, null, null, null, null, null, null, null, null);
            Flight flight = defineFlight(null, null, null, null, null, null, null, null, null, null, null, null, null);
        }            
    }
    
    
}
