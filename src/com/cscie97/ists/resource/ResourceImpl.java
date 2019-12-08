package com.cscie97.ists.resource;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthTokenTuple;
import com.cscie97.ists.authentication.StoreAuthenticationService;

public class ResourceImpl implements ResourceManagementService, Subject, Visitable
{
    LinkedHashMap<String, Entity> entities;
    LinkedHashMap<String, Launchpad> launchpads;
    LinkedHashMap<String, Spaceship> spaceships;
    CommunicationSystem communicationSystem;
    ComputerSystem computerSystem;
    LinkedHashMap<String, Fuel> fuels;
    com.cscie97.ledger.CommandProcessor ledgerCp;
    LinkedHashMap<String, Integer> prices;
    StoreAuthenticationService authenticator;
    
    ArrayList<Observer> observers;
    
    
    
    public ResourceImpl(com.cscie97.ledger.CommandProcessor ledgerCp, com.cscie97.ists.authentication.StoreAuthenticationService authenticator)
    {
        this.ledgerCp = ledgerCp;
        this.authenticator = authenticator;
        
        observers = new ArrayList<Observer>();
    }
    
    
    
    @Override
    public void registerObserver(Observer newObserver) {
     
        observers.add(newObserver);
    }

    @Override
    public void deregisterObserver(Observer observerToRemove) {
        
        observers.remove(observerToRemove);        
    }

    @Override
    public void notifyObservers(Spaceship sourceDevice, String[] eventToSend) {
        
        for (Observer observer : observers)
        {
            observer.update(new UpdateEvent(sourceDevice, eventToSend));
        }
    }    
    
    
    
    @Override
    public void createEvent(String spaceshipId, String simulatedEvent, AuthTokenTuple authTokenTuple)
    {        
        /*// Check that given AuthToken has permission to access this method
        GetPermissionsVisitor getPermissionsVisitor = authenticator.getUserPermissions(authTokenTuple.getAuthToken());
        if ((getPermissionsVisitor == null) || !getPermissionsVisitor.hasPermission(authTokenTuple.getPermissionTuple().setPermissionId("use Modeler API")))        
            return;*/
        
        Spaceship sourceDevice = spaceships.get(spaceshipId);
        
        String[] eventToSend = communicationSystem.createEvent(sourceDevice, simulatedEvent);
        
        // Notify observers of the event sent back from device
        notifyObservers(sourceDevice, eventToSend);   
    }
    
    @Override
    public Person definePerson(String id, String name, String description, String role, AuthTokenTuple authTokenTuple) {
        
        Person person = new Person(id, name, description, role);
        entities.put(id, person);
        
        return person;
    }
    
    @Override
    public Team defineTeam(String id, String name, String description, String type, AuthTokenTuple authTokenTuple) {
        
        Team team = new Team(id, name, description, type);
        entities.put(id, team);
        
        return team;
    } 

    @Override
    public Launchpad defineLaunchPad(String id, String name, String location, AuthTokenTuple authTokenTuple) {
        
        Launchpad launchpad = new Launchpad(id, name, location);
        launchpads.put(id, launchpad);
        
        return launchpad;
    }
    
    // Cargo
    @Override
    public Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType,
            String cargoType, Integer fuelCapacity, String description, AuthTokenTuple authTokenTuple) {
        
        Spaceship spaceship = null;
        spaceships.put(id, spaceship);
        
        return spaceship;
    }

    // Passenger
    @Override
    public Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType,
            Integer capacity, String classType, Integer fuelCapacity, String description, AuthTokenTuple authTokenTuple) {
        
        Spaceship spaceship = null;
        spaceships.put(id, spaceship);
        
        return spaceship;
    }

    // Rescue
    @Override
    public Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType,
            Integer fuelCapacity, String description, AuthTokenTuple authTokenTuple) {
        
        Spaceship spaceship = null;
        spaceships.put(id, spaceship);
        
        return spaceship;
    }
    
    @Override
    public CommunicationSystem defineCommunicationSystem(String id, AuthTokenTuple authTokenTuple) {
        
        CommunicationSystem communicationSystem = new CommunicationSystem(id);
        
        this.communicationSystem = communicationSystem;
        
        return communicationSystem;
    }

    @Override
    public ComputerSystem defineComputerSystem(String id, AuthTokenTuple authTokenTuple) {
        
        this.computerSystem = new ComputerSystem(id);
        
        return computerSystem;
    }      
    
    @Override
    public Fuel defineFuel(String typeId, Integer amount, AuthTokenTuple authTokenTuple) {
        
        Fuel fuel = new Fuel(typeId, amount);
        fuels.put(typeId, fuel);
        
        return fuel;
    }

    @Override
    public Fuel defineFuel(String typeId, AuthTokenTuple authTokenTuple) {
        
        Fuel fuel = new Fuel(typeId);
        fuels.put(typeId, fuel);
        
        return fuel;
    }     
    
    // To add and decrease fuel supply, ...?
    @Override
    public LinkedHashMap<String, Fuel> getFuels(AuthTokenTuple authTokenTuple) {

        return fuels;
    }

    @Override
    public LinkedHashMap<String, Spaceship> getSpaceships(AuthTokenTuple authTokenTuple) {
        return spaceships;
    }
    
    @Override
    public void addResourcePrice(String itemName, Integer price, AuthTokenTuple authTokenTuple) {
        
        prices.put(itemName, price);
    }
    
    @Override
    public void buyResource(String resourceName, Integer amount, AuthTokenTuple authTokenTuple)
    {
        
        //String txnId = 
        ledgerCp.processTransaction("0", prices.get(resourceName) * amount, 10, "buying " + resourceName, "ists", "master");
    }
    
    @Override
    public Integer getBudget(AuthTokenTuple authTokenTuple) {
        
        //System.out.println(Integer.parseInt(ledgerCp.getAccountBalance("ists")));
    
        return Integer.parseInt(ledgerCp.getAccountBalance("ists"));
    }

    @Override
    public LinkedHashMap<String, Entity> getEntities(AuthTokenTuple authTokenTuple) {
        return entities;
    }



    @Override
    public LinkedHashMap<String, Launchpad> getLaunchpads(AuthTokenTuple authTokenTuple) {
        return launchpads;
    }



    @Override
    public CommunicationSystem getCommunicationSystem(AuthTokenTuple authTokenTuple) {
        return communicationSystem;
    }



    @Override
    public ComputerSystem getComputerSystem(AuthTokenTuple authTokenTuple) {
        return computerSystem;
    }

    @Override
    public LinkedHashMap<String, Integer> getResourcePrices(AuthTokenTuple authTokenTuple) {
        return prices;
    }

    
    

    @Override
    public void acceptVisitor(Visitor visitor) {

        visitor.visitResourceImpl(this);
    }

    @Override
    public EntitiesVisitor getEntitiesVisitor(AuthTokenTuple authTokenTuple) {
        
        EntitiesVisitor entitiesVisitor = null;
        this.acceptVisitor(entitiesVisitor);
        
        return entitiesVisitor;
    } 
}
