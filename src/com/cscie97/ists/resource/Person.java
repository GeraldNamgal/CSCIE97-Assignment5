package com.cscie97.ists.resource;

public class Person extends Entity
{
    String role;

    public Person(String id, String name, String role)
    {
        super(id, name);
        
        this.role = role;
    }
}
