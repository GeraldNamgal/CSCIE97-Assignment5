package com.cscie97.ists.resource;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthTokenTuple;
// TODO: Remove? -- import com.cscie97.ists.resource.Inventory;

public interface ResourceManagementService
{
    Person definePerson(String id, String name, String description, String role, AuthTokenTuple authTokenTuple);
    Team defineTeam(String id, String name, String description, String type, AuthTokenTuple authTokenTuple);
    void addEntityToTeam(String entityId, String teamId, AuthTokenTuple authTokenTuple);
    Launchpad defineLaunchPad(String id, String name, String location, AuthTokenTuple authTokenTuple);
    Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, String cargoType
            , Integer fuelCapacity, String description, AuthTokenTuple authTokenTuple);
    Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, Integer capacity
            , String classType, Integer fuelCapacity, String description, AuthTokenTuple authTokenTuple);
    Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, Integer fuelCapacity
            , String description, AuthTokenTuple authTokenTuple);
    // TODO: Remove? -- Inventory defineInventory(String id, String launchpadId, String spaceshipId);
    void defineCommunicationSystem(String id, AuthTokenTuple authTokenTuple);
    void defineComputerSystem(String id, AuthTokenTuple authTokenTuple);
    void giveSpaceshipFuel(String spaceshipId, Integer amount, AuthTokenTuple authTokenTuple);
    Fuel defineFuel(String typeId, Integer amount, AuthTokenTuple authTokenTuple);
    Fuel defineFuel(String typeId, AuthTokenTuple authTokenTuple);    
    LinkedHashMap<String, Fuel> getFuels(AuthTokenTuple authTokenTuple); // To refill and decrease supply
    LinkedHashMap<String, Spaceship> getSpaceships(AuthTokenTuple authTokenTuple);    
    void addItemPrice(String itemName, Integer price, AuthTokenTuple authTokenTuple);    
    void buyResource(String resourceName, Integer amount, AuthTokenTuple authTokenTuple);
    Integer getBudget(AuthTokenTuple authTokenTuple);
    void createEvent(String spaceshipId, String simulatedEvent, AuthTokenTuple authTokenTuple);
}
