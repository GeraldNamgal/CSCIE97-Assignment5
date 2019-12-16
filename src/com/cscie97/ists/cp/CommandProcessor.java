package com.cscie97.ists.cp;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.cscie97.ists.authentication.AuthToken;
import com.cscie97.ists.authentication.AuthTokenTuple;
import com.cscie97.ists.authentication.Authenticator;
import com.cscie97.ists.authentication.StoreAuthenticationService;
import com.cscie97.ists.customer.CustomerImpl;
import com.cscie97.ists.customer.CustomerService;
import com.cscie97.ists.customer.Flight;
import com.cscie97.ists.manage.FlightManagementService;
import com.cscie97.ists.manage.Manager;
import com.cscie97.ists.resource.CommunicationSystem;
import com.cscie97.ists.resource.ResourceImpl;
import com.cscie97.ists.resource.ResourceManagementService;
import com.cscie97.ists.resource.Spaceship;
import com.cscie97.ists.resource.Subject;

public class CommandProcessor
{
    public com.cscie97.ists.authentication.CommandProcessor authenticatorCp;
    public com.cscie97.ledger.CommandProcessor ledgerCp;
    public AuthToken hardcodedUserAuthToken;
    public ResourceManagementService resourceImpl;    
    public FlightManagementService manager;
    public CustomerService customerImpl;
    
    public CommandProcessor()
    {        
        StoreAuthenticationService authenticator = new Authenticator();
        ledgerCp = new com.cscie97.ledger.CommandProcessor();        
        authenticatorCp = new com.cscie97.ists.authentication.CommandProcessor(authenticator, ledgerCp);
        // Login CommandProcessor with hardcoded User credentials so can operate Authenticator methods
        hardcodedUserAuthToken = authenticator.login(Authenticator.getHardcodedUserUsername(), Authenticator.getHardcodedUserPassword());
        
        resourceImpl = new ResourceImpl(ledgerCp, authenticator);        
        customerImpl = new CustomerImpl(ledgerCp, resourceImpl, authenticator);
        manager = new Manager((Subject) resourceImpl, customerImpl, authenticator);
    }
    
    /* *
     * TODO: CODE GOES HERE
     */
    public void processCommandFile()
    {
        // Create ledger, Blockchain account, and initial fund transactions
        parseAndProcess("Create-ledger ledger description \"for blockchaining\" seed \"CSCIE-97\"");
        parseAndProcess("create-account ists");
        parseAndProcess("process-transaction 0 amount 999999999 fee 10 payload \"fund account\" payer master receiver ists");
        
        // Create 9 more dummy txns
        parseAndProcess("create-account john");
        parseAndProcess("process-transaction 0 amount 2000 fee 10 payload \"fund account\" payer master receiver john");
        parseAndProcess("create-account mark");
        parseAndProcess("process-transaction 1 amount 2000 fee 10 payload \"fund account\" payer master receiver mark");
        parseAndProcess("create-account mary");
        parseAndProcess("process-transaction 2 amount 0 fee 10 payload \"fund account\" payer master receiver mary");
        parseAndProcess("create-account joseph");
        parseAndProcess("process-transaction 3 amount 2000 fee 10 payload \"fund account\" payer master receiver joseph");
        parseAndProcess("create-account stan");
        parseAndProcess("process-transaction 4 amount 2000 fee 10 payload \"fund account\" payer master receiver stan");
        parseAndProcess("create-account jalina");
        parseAndProcess("process-transaction 5 amount 2000 fee 10 payload \"fund account\" payer master receiver jalina");
        parseAndProcess("create-account sebastian");
        parseAndProcess("process-transaction 6 amount 2000 fee 10 payload \"fund account\" payer master receiver sebastian");
        parseAndProcess("create-account lisa");
        parseAndProcess("process-transaction 7 amount 2000 fee 10 payload \"fund account\" payer master receiver lisa");
        parseAndProcess("create-account art");
        parseAndProcess("process-transaction 8 amount 2000 fee 10 payload \"fund account\" payer master receiver art");
        
        resourceImpl.getBudget(new AuthTokenTuple(hardcodedUserAuthToken));
                
        /* TODO: Provisioning a new flight (sequence diagram) */        
        
        Flight flight1 = manager.defineFlight("id", "number", "spaceshipId", "time", "location", "destination", "duration", 2, 30, "crewId", 350, 21, null);
        
        /* TODO: Status (sequence diagram) */
        
        String spaceshipId = null;      
        resourceImpl.createEvent(spaceshipId, "status update reached destination", null);
        
        /* TODO: Booking a new flight (sequence diagram) */
        
        // On Select Flight event
        customerImpl.bookFlight("id", "flightNum", "destination", "passengerId", 360, "one-way", "departTime", "returnTime", new AuthTokenTuple(null));        
        
        /* TODO: Still need? -- // Get flights
        LinkedHashMap<String, Flight> flights = customerImpl.getFlights(new AuthTokenTuple(hardcodedUserAuthToken));
        
        // Print flights to the screen
        Flight flight;
        for (Entry<String, Flight> flightEntry : flights.entrySet())
        {
            flight = flightEntry.getValue();
            System.out.println(flight.id);
            System.out.println(flight.number);
            // ...
        }*/
        
        /* TODO: Emergency event (activity diagram) */
        
        resourceImpl.createEvent(spaceshipId, "emergency", new AuthTokenTuple(hardcodedUserAuthToken));
        
        
    } 
    
    public void parseAndProcess(String input)
    {
        authenticatorCp.processCommand(input);
    }
}
