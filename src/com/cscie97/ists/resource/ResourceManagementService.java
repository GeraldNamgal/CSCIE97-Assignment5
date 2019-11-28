package com.cscie97.ists.resource;

import java.util.LinkedHashMap;

public interface ResourceManagementService
{
    Person definePerson(String id, String name, String role);
    Team defineTeam(String id, String name, String type);
    void addEntityToTeam(String entityId, String teamId);
    Launchpad defineLaunchPad(String id, String name, String location);
    Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, String cargoType
            , Integer fuelCapacity, String description);
    Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, Integer capacity
            , String classType, Integer fuelCapacity, String description);
    Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, Integer fuelCapacity, String description);
    void defineCommunicationSystem(String id);
    void defineComputerSystem(String id);
    void giveSpaceshipFuel(String spaceshipId, Integer amount);
    Fuel defineFuel(String typeId, Integer amount);
    Fuel defineFuel(String typeId);    
    LinkedHashMap<String, Fuel> getFuels(); // To refill and decrease supply
    LinkedHashMap<String, Spaceship> getSpaceships();    
    void addItemPrice(String itemName, Integer price);    
    void buyResource(String resourceName, Integer amount);
    Integer getBudget();
    void createEvent(String spaceshipId, String simulatedEvent);
}
