package com.cscie97.ists.resource;

public interface ResourceManagementService
{
    void definePerson(String id, String name, String role);
    void defineTeam(String id, String name, String type);
    void addEntityToTeam(String entityId, String teamId);
    void defineLaunchPad(String id, String name, String location);
    void defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, String cargoType
            , Integer fuelCapacity, String description);
    void defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, Integer capacity
            , String classType, Integer fuelCapacity, String description);
    void defineSpaceship(String id, String model, String name, Integer maxSpeed, String fuelType, Integer fuelCapacity, String description);
    void defineCommunicationSystem(String id);
    void defineComputerSystem(String id);
}
