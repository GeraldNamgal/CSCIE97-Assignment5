package com.cscie97.ists.customer;

public class Discovery extends ExperienceDocument {
    
    String type;

    public Discovery(String id, String name, String description, String type) {
        super(id, name, description);
        
        this.type = type;
    }    
}
