package com.cscie97.ists.resource;

import java.util.LinkedHashMap;

public class Team extends Entity
{
    String type;
    LinkedHashMap<String, Entity> entities;
    
    public Team(String id, String name, String description, String type)
    {
        super(id, name, description);

        this.type = type;
        entities = new LinkedHashMap<String, Entity>();
    }
}
