/* *
 * Gerald Arocena
 * CSCI E-97
 * Professor: Eric Gieseke
 * Assignment 4
 */

package com.cscie97.ists.manage;

import com.cscie97.ists.resource.Spaceship;

/* *
 * Command class that represents the command event(s) classification gleaned from a specific type of update event.
 * It also represents the command in the Command design pattern
 */
public abstract class Command
{
    /* Variables */
    
    protected Spaceship sourceDevice;    
    
    /* Constructor */
    
    public Command(Spaceship sourceDevice)
    {
        this.sourceDevice = sourceDevice;               
    }
    
    /* Methods */
    
    /* *
     * Executes the actions for a Command
     */
    public abstract void execute();      
}
