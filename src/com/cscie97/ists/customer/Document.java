package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

public abstract class Document {
    
    String id;
    String name;
    String description;    
   
    public LinkedHashMap<String, Note> notes;    
    
    public Document(String id, String name, String description)
    {
        this.id = id;
        this.name = name;        
        this.description = description;        
    }
    
    /* Methods */
        
    public void addNote(Note note)
    {
        // Add to list
    }   
}
