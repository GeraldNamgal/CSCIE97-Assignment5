package com.cscie97.ists.cp;

import com.cscie97.ists.authentication.AuthToken;
import com.cscie97.ists.authentication.AuthTokenTuple;
import com.cscie97.ists.authentication.Authenticator;
import com.cscie97.ists.authentication.StoreAuthenticationService;
import com.cscie97.ists.manage.FlightManagementService;
import com.cscie97.ists.manage.Manager;
import com.cscie97.ists.resource.ResourceImpl;
import com.cscie97.ists.resource.ResourceManagementService;
import com.cscie97.ists.resource.Subject;

public class CommandProcessor
{
    com.cscie97.ists.authentication.CommandProcessor authenticatorCp;
    com.cscie97.ledger.CommandProcessor ledgerCp;
    ResourceManagementService resourceImpl;
    AuthToken hardcodedUserAuthToken;
    FlightManagementService manager;
    
    public CommandProcessor()
    {        
        ledgerCp = new com.cscie97.ledger.CommandProcessor();
        StoreAuthenticationService authenticator = new Authenticator();
        authenticatorCp = new com.cscie97.ists.authentication.CommandProcessor(authenticator, ledgerCp);
        // Login CommandProcessor with hardcoded User credentials so can operate Authenticator methods
        hardcodedUserAuthToken = authenticator.login(Authenticator.getHardcodedUserUsername(), Authenticator.getHardcodedUserPassword());
        
        resourceImpl = new ResourceImpl(ledgerCp, authenticator);
        manager = new Manager((Subject) resourceImpl, authenticator);
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
        
        String spaceshipId = null;
        resourceImpl.createEvent(spaceshipId, "Testing", new AuthTokenTuple(hardcodedUserAuthToken));
    } 
    
    public void parseAndProcess(String input)
    {
        authenticatorCp.processCommand(input);
    }
}
