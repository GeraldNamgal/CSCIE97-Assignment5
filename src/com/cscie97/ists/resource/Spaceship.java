package com.cscie97.ists.resource;

import java.util.ArrayList;

import com.cscie97.ists.authentication.AuthTokenTuple;

public class Spaceship {

    public String id;
    public String model;
    public String name;
    public Integer maxSpeed;
    public String fuelType;
    public String type;
    public CargoShip cargoShip;
    public PassengerShip passengerShip;
    public RescueShip rescueShip;
    public Integer fuelCapacity;
    public Integer fuelLevel = 0;
    public String description;
    public Integer currentSpeed = 0;
    public String trajectory;
    public String coordinates;
    public String status;
    public Integer crewCapacity;
    public ArrayList<String> passengerIds;
        
        
        
    public String[] event(String perceivedEvent)
    {
        // Delimit event string on whitespace and add each value to an array
        String[] eventStrArr = perceivedEvent.split("\\s+");
        
        return eventStrArr;
    }
    
    
    
    // Cargo
    public Spaceship(String id, String model, String name, Integer maxSpeed, String fuelType, String cargoType
            , Integer fuelCapacity, Integer crewCapacity, String description)
    {
        this.id = id;
        this.model = model;
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
        this.type = "cargo";
        this.fuelCapacity = fuelCapacity;
        this.description = description;
        this.status = "available";
       
        cargoShip = new CargoShip(cargoType);            
    }
    
    // Passenger
    public Spaceship(String id, String model, String name, Integer maxSpeed, String fuelType, Integer capacity
            , String classType, Integer fuelCapacity, Integer crewCapacity, String description)
    {
        this.id = id;
        this.model = model;
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
        this.type = "passenger";
        this.fuelCapacity = fuelCapacity;
        this.description = description;
        this.status = "available";
        
        passengerShip = new PassengerShip(capacity, classType);
    }
    
    // Rescue
    public Spaceship(String id, String model, String name, Integer maxSpeed, String fuelType, Integer fuelCapacity,
            Integer capacity, Integer crewCapacity, String description)
    {
        this.id = id;
        this.model = model;
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
        this.type = "rescue";
        this.fuelCapacity = fuelCapacity;
        this.description = description;
        this.status = "available";
        
        rescueShip = new RescueShip(capacity);
    }
    
    
    
    public class CargoShip
    {
        String cargoType;
        
        public CargoShip(String cargoType)
        {
            this.cargoType = cargoType;
        }
    }
    
    public class PassengerShip
    {
        Integer capacity;
        String classType;        
        
        public PassengerShip(Integer capacity, String classType)
        {
            this.capacity = capacity;
            this.classType = classType;
        }
    }
    
    public class RescueShip
    {
        Integer capacity;
        
        public RescueShip(Integer capacity)
        {
            this.capacity = capacity;
        }
    }
    
    
    public void addFuel(Integer amount, AuthTokenTuple authTokenTuple)
    {
        fuelLevel = fuelLevel + amount;
    }
    
    public void consumeFuel(Integer amount, AuthTokenTuple authTokenTuple)
    {
        fuelLevel = fuelLevel - amount;
    }

    public Integer getFuelLevel(AuthTokenTuple authTokenTuple) {
        return fuelLevel;

 
   }

    public void setFuelLevel(Integer fuelLevel, AuthTokenTuple authTokenTuple) {
        this.fuelLevel = fuelLevel;

    }

    public Integer getCurrentSpeed(AuthTokenTuple authTokenTuple) {
        return currentSpeed;

    }

    public void setCurrentSpeed(Integer currentSpeed, AuthTokenTuple authTokenTuple) {
        this.currentSpeed = currentSpeed;
    }

    public String getTrajectory(AuthTokenTuple authTokenTuple) {
        return trajectory;
    }

    public void setTrajectory(String trajectory, AuthTokenTuple authTokenTuple) {
        this.trajectory = trajectory;
    }

    public String getCoordinates(AuthTokenTuple authTokenTuple) {
        return coordinates;
    }

    public void setCoordinates(String coordinates, AuthTokenTuple authTokenTuple) {
        this.coordinates = coordinates;
    }

    public String getStatus(AuthTokenTuple authTokenTuple) {
        return status;
    }

    public void setStatus(String status, AuthTokenTuple authTokenTuple) {
        this.status = status;
    }  
}
