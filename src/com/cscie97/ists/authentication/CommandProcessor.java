/* *
 * Gerald Arocena
 * CSCI E-97
 * Professor: Eric Gieseke
 * Assignment 4
 */

package com.cscie97.ists.authentication;

import java.util.ArrayList;

/* *
 * Exercises the Authenticator and associates to Modeler, Controller, and Ledger's CommandProcessors
 */
public class CommandProcessor
{
    /* Variables */
    
    private StoreAuthenticationService authenticator;
    private com.cscie97.ledger.CommandProcessor ledgerCp;
    private AuthToken hardcodedUserAuthToken;
    private int lineNum = 0;
    
    /* Constructor */
    
    public CommandProcessor(StoreAuthenticationService authenticator, com.cscie97.ledger.CommandProcessor ledgerCp)
    {
        // Create Authenticator      
        this.authenticator = authenticator;
        
        // Create ledger cp
        this.ledgerCp = ledgerCp;
        
        // Login CommandProcessor with hardcoded User credentials so can operate Authenticator methods
        hardcodedUserAuthToken = authenticator.login(Authenticator.getHardcodedUserUsername(), Authenticator.getHardcodedUserPassword());
    }
    
    /* API Methods */

    /* *
     * Parses a string for valid CLI/DSL command syntax and calls corresponding Authenticator method
     * @command The input string to be parsed
     */
    public void processCommand(String command)
    {
        parseAndProcess(command);
    }    
    
    /* *
     * Parses a file of strings for valid CLI/DSL command syntax and calls corresponding Authenticator methods
     * for each string found    
     * @param commandFile the name of the file to be pased
     * Referenced https://www.journaldev.com/709/java-read-file-line-by-line
     */
    public void processCommandFile(String commandFile)
    {
        // Not needed
    }       
    
    /* Utility Methods */

    /* *
     * Utility method that parses a string for valid DSL/CLI command syntax and calls Authenticator methods
     * based on parsing result
     * @param input The line of string to be parsed
     */
    public void parseAndProcess(String input)
    {
        // Trim leading and trailing whitespace
        String trimmedInput = input.trim();

        // Check if input is a comment
        if (trimmedInput.charAt(0) == '#')
        {                         
            System.out.println(trimmedInput + " [line " + lineNum + " in file]");          
            return;
        }
        
        // Delimit input string on whitespace and add each value to array
        String[] splitInputArr = trimmedInput.split("\\s+");
        
        /* If input contained quotes, then validate their correct usage and fix array - code block BEGINNING */
        
        boolean openQuote = false;
        ArrayList<Integer> indicesOfOpeningQuotes = new ArrayList<Integer>();
        ArrayList<Integer> indicesOfClosingQuotes = new ArrayList<Integer>();
        
        for (int i = 0; i < splitInputArr.length; i++)
        {
            // If a stand-alone quote, must check if it's an opening or closing quote
            if ((splitInputArr[i].length() == 1) && (splitInputArr[i].charAt(0) == '"'))
            {
                if (openQuote == false)
                {
                    indicesOfOpeningQuotes.add(i);
                    openQuote = true;
                }

                else
                {
                    indicesOfClosingQuotes.add(i);
                    openQuote = false;
                }
            }    
                
            // If not a stand-alone quote
            else
            {
                // Checks string if has a quote as first character
                if (splitInputArr[i].charAt(0) == '"')
                {
                    if (openQuote == true)
                    {
                        try
                        {
                            if (lineNum == 0)
                                throw new CommandProcessorException("in processCommand method", "missing closing quote in user input");
        
                            else
                                throw new CommandProcessorException("in processCommandFile method", "missing closing quote in user input", lineNum);            
                        }
                            
                        catch (CommandProcessorException exception)
                        {
                            if (lineNum == 0)
                            {
                                System.out.println("-: " + trimmedInput);
                                System.out.println();
                                System.out.println(exception.getMessage());                                 
                                return;
                            }
                    
                            else
                            {
                                System.out.println("-: " + trimmedInput);
                                System.out.println();
                                System.out.println(exception.getMessageLine());                            
                                return;
                            }
                        }
                    }
                      
                    else
                    {
                        indicesOfOpeningQuotes.add(i);
                        openQuote = true;
                    }
                }
        
                // Checks string if has a quote as last character
                if (splitInputArr[i].charAt(splitInputArr[i].length() - 1) == '"')
                {
                    if (openQuote == true)
                    {
                        indicesOfClosingQuotes.add(i);
                        openQuote = false;
                    }
                      
                    else
                    {
                        try
                        {
                            if (lineNum == 0)
                                throw new CommandProcessorException("in processCommand method", "missing opening quote in user input");
        
                            else
                                throw new CommandProcessorException("in processCommandFile method", "missing opening quote in user input", lineNum);            
                        }
                            
                        catch (CommandProcessorException exception)
                        {
                            if (lineNum == 0)
                            {
                                System.out.println("-: " + trimmedInput);
                                System.out.println();
                                System.out.println(exception.getMessage());                                 
                                return;
                            }
                    
                            else
                            {
                                System.out.println("-: " + trimmedInput);
                                System.out.println();
                                System.out.println(exception.getMessageLine());                             
                                return;
                            }
                        }
                    }
                }
            }
        }
        
        // If there is an ultimate open quote without a matching closing quote then throw exception 
        if (openQuote == true)
        {
            try
            {
                if (lineNum == 0)
                    throw new CommandProcessorException("in processCommand method", "missing closing quote in user input");

                else
                    throw new CommandProcessorException("in processCommandFile method", "missing closing quote in user input", lineNum);            
            }
            
            catch (CommandProcessorException exception)
            {
                if (lineNum == 0)
                {
                    System.out.println("-: " + trimmedInput);
                    System.out.println();
                    System.out.println(exception.getMessage());                    
                    return;
                }
    
                else
                {
                    System.out.println("-: " + trimmedInput);
                    System.out.println();
                    System.out.println(exception.getMessageLine());                    
                    return;
                }
            }
        }
        
        // If input had quotes, string quoted input(s) back together
        if (indicesOfOpeningQuotes.size() > 0)
        {               
            // Create a modified splitInputArr, named splitStringQuotesArr, with quoted input(s) back together
            ArrayList<String> splitStringQuotesArr = new ArrayList<String>();
            
            // Initialize index counter for opening and closing quotes arrays
            int index = 0;
                
            // Initialize a quote string
            String quote = "";
                
            // Loop through splitInputArr to create new splitStringQuotesArr string array
            for (int i = 0; i < splitInputArr.length; i++)
            {
                // If found all quotes then just transfer the element to new array
                if (index >= indicesOfOpeningQuotes.size())                             
                    splitStringQuotesArr.add(splitInputArr[i]);                 
                        
                else
                {
                    if (openQuote == false)
                    {
                        if (i == indicesOfOpeningQuotes.get(index))                                     
                            openQuote = true;
                                                                        
                        else                                    
                            splitStringQuotesArr.add(splitInputArr[i]);                                 
                    }
                                        
                    if (openQuote == true)
                    {
                        // If element contains the closing quote
                        if (i == indicesOfClosingQuotes.get(index))
                        {
                            // Append element to quote string
                            quote += splitInputArr[i];
                                                
                            // Remove quotes from quote and trim its whitespace
                            StringBuffer sbf = new StringBuffer(quote);
                            quote = sbf.deleteCharAt(0).toString();
                            sbf = new StringBuffer(quote);
                            quote = sbf.deleteCharAt(quote.length() - 1).toString();
                            quote = quote.trim();
                                                
                            // Add quote to new array
                            splitStringQuotesArr.add(quote);                                            
                                                
                            // Set openQuote to false, increment counter, and reset quote string since found closing quote
                            openQuote = false;                                          
                            index++;
                            quote = "";
                        }
                                                                
                        else
                        {
                            // Append element to quote string with a space added
                            quote += splitInputArr[i] + " ";
                        }
                    }
                }
            }           
                
            // Redefine splitInputArr with new array
            splitInputArr = new String[splitStringQuotesArr.size()]; 
            splitStringQuotesArr.toArray(splitInputArr);                
        }
        
        /* code block END ("If input contained quotes, then validate their correct usage and fix array") */
        
        if ((splitInputArr.length == 5) && splitInputArr[0].equalsIgnoreCase("define") && splitInputArr[1].equalsIgnoreCase("permission"))
        {
            System.out.println("-: " + trimmedInput);
            authenticator.definePermission(splitInputArr[2], splitInputArr[3], splitInputArr[4], new AuthTokenTuple(hardcodedUserAuthToken));
            System.out.println();
        }
        
        else if ((splitInputArr.length == 5) && splitInputArr[0].equalsIgnoreCase("define") && splitInputArr[1].equalsIgnoreCase("role"))
        {
            System.out.println("-: " + trimmedInput);
            authenticator.defineRole(splitInputArr[2], splitInputArr[3], splitInputArr[4], new AuthTokenTuple(hardcodedUserAuthToken));
            System.out.println();
        }
        
        else if ((splitInputArr.length == 6) && splitInputArr[0].equalsIgnoreCase("add") && splitInputArr[1].equalsIgnoreCase("entitlement")
                && splitInputArr[2].equalsIgnoreCase("to") && splitInputArr[3].equalsIgnoreCase("role"))
        {
            System.out.println("-: " + trimmedInput);
            authenticator.addEntitlementToRole(splitInputArr[4], splitInputArr[5], new AuthTokenTuple(hardcodedUserAuthToken));
            System.out.println();
        }
        
        else if((splitInputArr.length == 4) && splitInputArr[0].equalsIgnoreCase("define") && splitInputArr[1].equalsIgnoreCase("user"))
        {
            System.out.println("-: " + trimmedInput);
            authenticator.defineUser(splitInputArr[2], splitInputArr[3], new AuthTokenTuple(hardcodedUserAuthToken));
            System.out.println();
        }
        
        else if ((splitInputArr.length == 6) && splitInputArr[0].equalsIgnoreCase("add") && splitInputArr[1].equalsIgnoreCase("user")
                && splitInputArr[2].equalsIgnoreCase("credential"))
        {
            System.out.println("-: " + trimmedInput);
            authenticator.addUserCredential(splitInputArr[3], splitInputArr[4], splitInputArr[5], new AuthTokenTuple(hardcodedUserAuthToken));
            System.out.println();
        }
        
        else if((splitInputArr.length == 4) && splitInputArr[0].equalsIgnoreCase("define") && splitInputArr[1].equalsIgnoreCase("resource"))
        {
            System.out.println("-: " + trimmedInput);
            authenticator.defineResource(splitInputArr[2], splitInputArr[3], new AuthTokenTuple(hardcodedUserAuthToken));
            System.out.println();
        }
        
        else if ((splitInputArr.length == 8) && splitInputArr[0].equalsIgnoreCase("define") && splitInputArr[1].equalsIgnoreCase("resource")
                && splitInputArr[2].equalsIgnoreCase("role"))
        {
            System.out.println("-: " + trimmedInput);
            authenticator.defineResourceRole(splitInputArr[3], splitInputArr[4], splitInputArr[5], splitInputArr[6], splitInputArr[7], new AuthTokenTuple(hardcodedUserAuthToken));
            System.out.println();
        }
        
        else if ((splitInputArr.length == 6) && splitInputArr[0].equalsIgnoreCase("add") && splitInputArr[1].equalsIgnoreCase("entitlement")
                && splitInputArr[2].equalsIgnoreCase("to") && splitInputArr[3].equalsIgnoreCase("user"))
        {
            System.out.println("-: " + trimmedInput);
            authenticator.addEntitlementToUser(splitInputArr[4], splitInputArr[5], new AuthTokenTuple(hardcodedUserAuthToken));
            System.out.println();
        }
        
        else if((splitInputArr.length == 2) && splitInputArr[0].equalsIgnoreCase("print") && splitInputArr[1].equalsIgnoreCase("inventory"))
        {
            System.out.println("-: " + trimmedInput);
            authenticator.printInventory();
            System.out.println();
        }
        
        // Else route the command to the Ledger Service's CommandProcessor
        else
        {            
            ledgerCp.processCommand(input);
        }
    }
    
    /* Getters and Setters */
    
    public int getLineNum()
    {
        return lineNum;
    }
}
