package com.cscie97.ists.resource;

public class Fuel {

    String typeId;
    Integer amount = 0; // Amount in gallons
    
    public Fuel(String typeId)
    {
        this.typeId = typeId;  
    }
    
    public Fuel(String typeId, Integer amount)
    {
        this.typeId = typeId;
        this.amount = amount;        
    }
    
    
    
    public void addFuelSupply(Integer amount)
    {
        this.amount = this.amount + amount;
    }
    
    public void deductFuelSupply(Integer amount)
    {
        // TODO: Make sure amount doesn't go under zero
        
        this.amount = this.amount - amount;
    }    
}
