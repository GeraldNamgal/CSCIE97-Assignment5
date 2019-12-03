package com.cscie97.ists.resource;

import com.cscie97.ists.authentication.AuthTokenTuple;

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
    
    
    
    public void addFuelSupply(Integer amount, AuthTokenTuple authTokenTuple)
    {
        this.amount = this.amount + amount;
    }
    
    public void deductFuelSupply(Integer amount, AuthTokenTuple authTokenTuple)
    {
        // TODO: Make sure amount doesn't go under zero
        
        this.amount = this.amount - amount;
    }    
}
