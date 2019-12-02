package com.cscie97.ists.customer;

public abstract class Medium {
    
    String ipnsKeyName;
    String id;
    String name;
    String description;
    String source;
    
    public Medium(String ipnsKeyName, String id, String name, String description, String source)
    {
        this.ipnsKeyName = ipnsKeyName;
        this.id = id;
        this.name = name;
        this.description = description;
        this.source = source;
    }
}
