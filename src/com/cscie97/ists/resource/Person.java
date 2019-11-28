package com.cscie97.ists.resource;

public class Person extends Entity
{
    String role;

    public Person(String id, String name, String description, String role)
    {
        super(id, name, description);
        
        this.role = role;
    }
}
