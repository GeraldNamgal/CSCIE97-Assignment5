package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthTokenTuple;

public class WelcomePackage extends Document {
    
    public LinkedHashMap<String, Image> images;    
    public LinkedHashMap<String, Movie> movies;
    
    public WelcomePackage(String id, String name, String description)
    {
        super(id, name, description);        
    }
    
    /* Methods */
    
    public void addImage(Image image, AuthTokenTuple authTokenTuple)
    {
        // Add to list
    }
       
    public void addMovie(Movie movie, AuthTokenTuple authTokenTuple)
    {
        // Add to list
    }
}
