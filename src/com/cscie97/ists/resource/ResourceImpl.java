package com.cscie97.ists.resource;

import java.util.LinkedHashMap;

public class ResourceImpl implements ResourceManagementService
{
    LinkedHashMap<String, Entity> entities;
    LinkedHashMap<String, Launchpad> launchpads;
    LinkedHashMap<String, Spaceship> spaceships;
    CommunicationSystem communicationSystem;
    ComputerSystem computerSystem;
    
    @Override
    public void definePerson(String id, String name, String role) {
        
        Person person = new Person(id, name, role);
        entities.put(id, person);
    }
    
    @Override
    public void defineTeam(String id, String name, String type) {
        
        Team team = new Team(id, name, type);
        entities.put(id, team);
    } 
    
    @Override
    public void addEntityToTeam(String entityId, String teamId) {
        
        Team team = (Team) entities.get(teamId);
        team.entities.put(entityId, entities.get(entityId));
    }

    @Override
    public void defineLaunchPad(String id, String name, String location) {
        // TODO Auto-generated method stub
        
        Launchpad launchpad = new Launchpad(id, name, location);
        launchpads.put(id, launchpad);
    }
    
    // Cargo
    @Override
    public void defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType,
            String cargoType, Integer fuelCapacity, String description) {
        // TODO Auto-generated method stub
        
        Spaceship spaceship = new Spaceship(id, model, name, maxSpeed, fuelType, cargoType, fuelCapacity, description);
        spaceships.put(id, spaceship);
    }

    // Passenger
    @Override
    public void defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType,
            Integer capacity, String classType, Integer fuelCapacity, String description) {
        // TODO Auto-generated method stub
        
        Spaceship spaceship = new Spaceship(id, model, name, maxSpeed, fuelType, capacity, classType, fuelCapacity, description);
        spaceships.put(id, spaceship);
    }

    // Rescue
    @Override
    public void defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType,
            Integer fuelCapacity, String description) {
        // TODO Auto-generated method stub
        
        Spaceship spaceship = new Spaceship(id, model, name, maxSpeed, fuelType, fuelCapacity, description);
        spaceships.put(id, spaceship);
    }

    @Override
    public void defineCommunicationSystem(String id) {
        // TODO Auto-generated method stub
        
        CommunicationSystem communicationSystem = new CommunicationSystem(id);
        
        this.communicationSystem = communicationSystem;
    }

    @Override
    public void defineComputerSystem(String id) {
        // TODO Auto-generated method stub
        
        this.computerSystem = new ComputerSystem(id);
    }      
}
