package com.cscie97.ists.resource;

public class Spaceship {

    public String id;
    public String model;
    public String name;
    public Integer maxSpeed;
    public String fuelType;
    public String type;
    public CargoShip cargoShip;
    public PassengerShip passengerShip;
    public Integer fuelCapacity;
    public Integer fuelLevel = 0;
    public String description;
    public Integer currentSpeed = 0;
    public String trajectory;
    public String coordinates;
    public String status;
        
        
        
    public String[] event(String perceivedEvent)
    {
        // Delimit event string on whitespace and add each value to an array
        String[] eventStrArr = perceivedEvent.split("\\s+");
        
        return eventStrArr;
    }
    
    
    
    // Cargo
    public Spaceship(String id, String model, String name, Integer maxSpeed, String fuelType, String cargoType
            , Integer fuelCapacity, String description)
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
            , String classType, Integer fuelCapacity, String description)
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
    public Spaceship(String id, String model, String name, Integer maxSpeed, String fuelType, Integer fuelCapacity, String description)
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
    
    
    
    public void addFuel(Integer amount)
    {
        fuelLevel = fuelLevel + amount;
    }
    
    public void consumeFuel(Integer amount)
    {
        fuelLevel = fuelLevel - amount;
    }
}
