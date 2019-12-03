package com.cscie97.ists.resource;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthTokenTuple;

public class Team extends Entity
{
    String type;
    LinkedHashMap<String, Entity> entities;
    Team parentTeam;
    
    public Team(String id, String name, String description, String type)
    {
        super(id, name, description);

        this.type = type;
        entities = new LinkedHashMap<String, Entity>();
    }
    
    /* Methods */
    
    public void addEntity(Entity entity, AuthTokenTuple authTokenTuple)
    {
        // If entity is a team put this team on the entity's parentTeam 
        
        // Add to list
    }
}
