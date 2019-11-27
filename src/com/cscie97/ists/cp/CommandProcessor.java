package com.cscie97.ists.cp;

public class CommandProcessor
{
    private com.cscie97.ists.authentication.CommandProcessor authenticatorCp;
    
    public CommandProcessor()
    {
        authenticatorCp = new com.cscie97.ists.authentication.CommandProcessor();
    }
    
    /* *
     * TODO
     */
    public void processCommandFile()
    {
        
    } 
    
    public void parseAndProcess(String input)
    {
        authenticatorCp.processCommand(input);
    }
}
