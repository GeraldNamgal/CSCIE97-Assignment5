package com.cscie97.ists.resource;

public abstract class Entity
{
    String id;
    String name;
    String description;
    
    public Entity(String id, String name, String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
