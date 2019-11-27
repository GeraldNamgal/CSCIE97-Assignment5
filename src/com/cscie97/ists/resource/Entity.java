package com.cscie97.ists.resource;

public abstract class Entity
{
    String id;
    String name;
    
    public Entity(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
}
