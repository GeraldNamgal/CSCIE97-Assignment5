package com.cscie97.ists.customer;

public class ObjectFactory {

    public static Object getObject(String json) {
        //if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
        //else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);
        
        if(true) return new Book(null, null, null, null, null);
        
        // ...
        
        return null;
    }
}
