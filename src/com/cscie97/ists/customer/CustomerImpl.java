package com.cscie97.ists.customer;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.Credential;


public class CustomerImpl implements CustomerService {

    LinkedHashMap<String, Passenger> passengers;
    LinkedHashMap<String, Passenger> credentialUserIndexes;
    LinkedHashMap<String, PointOfInterest> pointsOfInterest;
    // TODO: How to save hashes --
    LinkedHashMap<String, Passenger> travelDocHashes;
    
    
    @Override
    public Passenger registerPassenger(String id, String name, String account, String email) {

        Passenger passenger = new Passenger(id, name, account, email);
        
        // put passenger in passengers list
        
        return passenger;
    }
    
    @Override
    public void addUserCredential(String passengerId, String type, String value)
    { 
        // Create Credential
        Credential credential = null;
        if (type.equals("password"))
            credential = new Credential(passengerId + "-pwd", type, hashCalculator(value));
        if (type.equals("voiceprint"))
            credential = new Credential(passengerId + "-vp", type, hashCalculator(value));
        if (type.equals("faceprint"))
            credential = new Credential(passengerId + "-fp", type, hashCalculator(value));        
                
        // Add Credential to User's Credentials and to credentialUserIndexes list
        if (credential != null)
        {
            passengers.get(passengerId).credentials.put(credential.getId(), credential);
            credentialUserIndexes.put(credential.getId() + credential.getValue(), passengers.get(passengerId));
        }
    }
    
    @Override
    public PointOfInterest addPointOfInterest(String id, String name, String type, String description,
            String location) {

        // Add to pointsOfInterest list
        
        return null;
    }
    
    public String hashCalculator(String originalString)
    {
        try
        {
            // Create message digest
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Create hashed value
            byte[] encodedHash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));        
            
            // Convert hashed value from bytes to hexadecimal
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < encodedHash.length; i++)
            {
                String hex = Integer.toHexString(0xff & encodedHash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            
            // Return hash
            return hexString.toString();
        }
        
        catch (Exception exception)
        {
            exception.printStackTrace();    
            System.out.println(exception);            
            return null;
        }       
    }

    
}
