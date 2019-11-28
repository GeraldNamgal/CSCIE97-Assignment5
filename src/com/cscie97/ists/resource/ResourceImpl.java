package com.cscie97.ists.resource;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ResourceImpl implements ResourceManagementService, Subject
{
    LinkedHashMap<String, Entity> entities;
    LinkedHashMap<String, Launchpad> launchpads;
    LinkedHashMap<String, Spaceship> spaceships;
    CommunicationSystem communicationSystem;
    ComputerSystem computerSystem;
    LinkedHashMap<String, Fuel> fuels;
    com.cscie97.ledger.CommandProcessor ledgerCp;
    LinkedHashMap<String, Integer> prices;
    
    ArrayList<Observer> observers;
    
    
    
    public ResourceImpl(com.cscie97.ledger.CommandProcessor ledgerCp)
    {
        this.ledgerCp = ledgerCp;
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
    public void createEvent(String spaceshipId, String simulatedEvent)
    {        
        Spaceship sourceDevice = spaceships.get(spaceshipId);
        
        // Send simulated event to device's event method       
        String[] eventToSend = sourceDevice.event(simulatedEvent);
        
        // Notify observers of the event sent back from device
        notifyObservers(sourceDevice, eventToSend);   
    }
    
    @Override
    public Person definePerson(String id, String name, String role) {
        
        Person person = new Person(id, name, role);
        entities.put(id, person);
        
        return person;
    }
    
    @Override
    public Team defineTeam(String id, String name, String type) {
        
        Team team = new Team(id, name, type);
        entities.put(id, team);
        
        return team;
    } 
    
    @Override
    public void addEntityToTeam(String entityId, String teamId) {
        
        Team team = (Team) entities.get(teamId);
        team.entities.put(entityId, entities.get(entityId));
    }

    @Override
    public Launchpad defineLaunchPad(String id, String name, String location) {
        
        Launchpad launchpad = new Launchpad(id, name, location);
        launchpads.put(id, launchpad);
        
        return launchpad;
    }
    
    // Cargo
    @Override
    public Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType,
            String cargoType, Integer fuelCapacity, String description) {
        
        Spaceship spaceship = new Spaceship(id, model, name, maxSpeed, fuelType, cargoType, fuelCapacity, description);
        spaceships.put(id, spaceship);
        
        return spaceship;
    }

    // Passenger
    @Override
    public Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType,
            Integer capacity, String classType, Integer fuelCapacity, String description) {
        
        Spaceship spaceship = new Spaceship(id, model, name, maxSpeed, fuelType, capacity, classType, fuelCapacity, description);
        spaceships.put(id, spaceship);
        
        return spaceship;
    }

    // Rescue
    @Override
    public Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType,
            Integer fuelCapacity, String description) {
        
        Spaceship spaceship = new Spaceship(id, model, name, maxSpeed, fuelType, fuelCapacity, description);
        spaceships.put(id, spaceship);
        
        return spaceship;
    }

    @Override
    public void defineCommunicationSystem(String id) {
        
        CommunicationSystem communicationSystem = new CommunicationSystem(id);
        
        this.communicationSystem = communicationSystem;   
    }

    @Override
    public void defineComputerSystem(String id) {
        
        this.computerSystem = new ComputerSystem(id);       
    }    
    
    @Override
    public void giveSpaceshipFuel(String spaceshipId, Integer amount) {
        
        // TODO: Make sure amount doesn't go over capacity
        
        Spaceship spaceship = spaceships.get(spaceshipId);
        spaceship.addFuel(amount);
        fuels.get(spaceship.fuelType).deductFuelSupply(amount);
    }
    
    @Override
    public Fuel defineFuel(String typeId, Integer amount) {
        
        Fuel fuel = new Fuel(typeId, amount);
        fuels.put(typeId, fuel);
        
        return fuel;
    }

    @Override
    public Fuel defineFuel(String typeId) {
        
        Fuel fuel = new Fuel(typeId);
        fuels.put(typeId, fuel);
        
        return fuel;
    }     
    
    // To add and decrease fuel supply, ...?
    @Override
    public LinkedHashMap<String, Fuel> getFuels() {

        return fuels;
    }

    @Override
    public LinkedHashMap<String, Spaceship> getSpaceships() {
        return spaceships;
    }
    
    @Override
    public void addItemPrice(String itemName, Integer price) {
        
        prices.put(itemName, price);
    }
    
    @Override
    public void buyResource(String resourceName, Integer amount)
    {
        
        //String txnId = 
        ledgerCp.processTransaction("0", prices.get(resourceName) * amount, 10, "buying " + resourceName, "ists", "master");
    }
    
    @Override
    public Integer getBudget() {
        
        //System.out.println(Integer.parseInt(ledgerCp.getAccountBalance("ists")));
    
        return Integer.parseInt(ledgerCp.getAccountBalance("ists"));
    }    
}
