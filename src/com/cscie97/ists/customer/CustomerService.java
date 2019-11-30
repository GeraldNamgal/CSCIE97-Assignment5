package com.cscie97.ists.customer;

public interface CustomerService {

    Passenger registerPassenger(String id, String name, String account, String email);
    void addUserCredential(String passengerId, String type, String value);
    PointOfInterest addPointOfInterest(String id, String name, String type, String description, String location);
}
