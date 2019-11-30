package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.Credential;

public class Passenger {

    String id;
    String name;
    String account;
    String email;
    public LinkedHashMap<String, Credential> credentials;
    
    public Passenger(String id, String name, String account, String email)
    {
        this.id = id;
        this.name = name;
        this.account = account;
        this.email = email;
    }
}
