package com.cscie97.ists.resource;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthTokenTuple;

public interface ResourceManagementService
{
    Person definePerson(String id, String name, String description, String role, AuthTokenTuple authTokenTuple);
    Team defineTeam(String id, String name, String description, String type, AuthTokenTuple authTokenTuple);
    Launchpad defineLaunchPad(String id, String name, String location, AuthTokenTuple authTokenTuple);
    Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, String cargoType
            , Integer fuelCapacity, String description, AuthTokenTuple authTokenTuple);
    Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, Integer capacity
            , String classType, Integer fuelCapacity, String description, AuthTokenTuple authTokenTuple);
    Spaceship defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, Integer fuelCapacity
            , String description, AuthTokenTuple authTokenTuple);
    CommunicationSystem defineCommunicationSystem(String id, AuthTokenTuple authTokenTuple);
    ComputerSystem defineComputerSystem(String id, AuthTokenTuple authTokenTuple);  
    void addResourcePrice(String resourceName, Integer price, AuthTokenTuple authTokenTuple);
    void buyResource(String resourceName, Integer amount, AuthTokenTuple authTokenTuple);
    Integer getBudget(AuthTokenTuple authTokenTuple);
    void createEvent(String spaceshipId, String simulatedEvent, AuthTokenTuple authTokenTuple);
    Fuel defineFuel(String typeId, Integer amount, AuthTokenTuple authTokenTuple);
    Fuel defineFuel(String typeId, AuthTokenTuple authTokenTuple);    
    LinkedHashMap<String, Fuel> getFuels(AuthTokenTuple authTokenTuple); 
    LinkedHashMap<String, Spaceship> getSpaceships(AuthTokenTuple authTokenTuple);    
    LinkedHashMap<String, Entity> getEntities(AuthTokenTuple authTokenTuple);
    LinkedHashMap<String, Launchpad> getLaunchpads(AuthTokenTuple authTokenTuple);
    CommunicationSystem getCommunicationSystem(AuthTokenTuple authTokenTuple);
    ComputerSystem getComputerSystem(AuthTokenTuple authTokenTuple);
    LinkedHashMap<String, Integer> getResourcePrices(AuthTokenTuple authTokenTuple);
    EntitiesVisitor getEntitiesVisitor(AuthTokenTuple authTokenTuple);
}
