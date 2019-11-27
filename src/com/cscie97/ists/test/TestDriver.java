/* *
 * Gerald Arocena
 * CSCI E-97
 * Professor: Eric Gieseke
 * Assignment 4
 */

package com.cscie97.ists.test;

import com.cscie97.ists.cp.CommandProcessor;

/* *
 * Test driver class that contains main method that calls the Store Authenticator CommandProcessor class to exercise the Authenticator
 * and other services
 */
public class TestDriver
{
    /* *
     * Without a script file name argument, main method will run manual commands (otherwise will parse a script
     * file if it is given)
     */
    public static void main(String[] args)
    {
        // Create a command processor
        CommandProcessor cp = new CommandProcessor();
       
        // Call command processor with file name
        cp.processCommandFile();      
    }
}
