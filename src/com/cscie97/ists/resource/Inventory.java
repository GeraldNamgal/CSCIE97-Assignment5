/* *
 * Gerald Arocena
 * CSCI E-97
 * Professor: Eric Gieseke
 * Assignment 4 
 */

package com.cscie97.ists.resource;

/* *
 * Inventory class that represents inventory information for a product-shelf relationship
 */
public class Inventory
{
    /* API Variables */
    
    String inventoryId;
    String spaceshipId;
    String launchpadId;   
    
    public Inventory(String id, String launchpadId, String spaceshipId)
    {
        inventoryId = id;
        this.launchpadId = launchpadId;
        this.spaceshipId = spaceshipId;
    }     
}
