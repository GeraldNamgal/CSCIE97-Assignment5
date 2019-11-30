package com.cscie97.ists.customer;

import java.util.ArrayList;

public class PointOfInterest {

    String id;
    String name;
    String type;
    String description;
    String location;
    ArrayList<String> images;
    ArrayList<String> notes;
    
    public PointOfInterest(String id, String name, String type, String description, String location)
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }
    
    public void addImage(String filePath)
    {
        
    }
    
    public void addNote(String note)
    {
        
    }
}
