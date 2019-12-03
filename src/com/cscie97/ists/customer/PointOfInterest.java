package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthTokenTuple;

public class PointOfInterest {

    String id;
    String name;
    String type;
    String description;
    String location;
    public LinkedHashMap<String, Image> images;
    public LinkedHashMap<String, Note> notes;
    
    public PointOfInterest(String id, String name, String type, String description, String location)
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.location = location;
    }
    
    /* Methods */
    
    public void addImage(Image image, AuthTokenTuple authTokenTuple)
    {
        // Add image to images list
    }
    
    public void addNote(Note note, AuthTokenTuple authTokenTuple)
    {
        // Add note to notes list
    }
}
