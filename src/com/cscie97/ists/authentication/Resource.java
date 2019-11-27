/* *
 * Gerald Arocena
 * CSCI E-97
 * Professor: Eric Gieseke
 * Assignment 4
 */

package com.cscie97.ists.authentication;

/* *
 * Represents a resource in the Store 24X7 System
 */
public class Resource
{
    private String id;
    private String description;
    
    public Resource(String id, String description)
    {
        this.id = id;
        this.description = description;
    }
    
    public String getId()
    {
        return id;        
    }
    
    public String getDescription()
    {
        return description;
    }
}
