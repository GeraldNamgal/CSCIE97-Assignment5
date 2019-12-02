package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

public interface CustomerService {

    void pullFromIpfsRepo(String ipnsKeyName);
    void pushToIpfsRepo(String ipnsKeyName);
    Passenger registerPassenger(String id, String name, String account, String email);
    
    // TODO: getPassengers() // Admin only
    
    void addPassengerCredential(String passengerId, String type, String value);    
    PointOfInterest definePointOfInterest(String id, String name, String type, String description, String location); // Admin only
    LinkedHashMap<String, PointOfInterest> getPointsOfInterest(); // Anyone but only admin can modify/mutate it; others can only get
    Image defineImage(String ipnsKeyName, String id, String name, String description, String source);
    LinkedHashMap<String, Image> getImages(); // User-specific
    Note defineNote(String id, String description, String message);
    LinkedHashMap<String, Note> getNotes(); // User-specific     
    void bookFlight(String id, String flightNumber, String destination, String passengerId, Integer price, String type
            , String departureTime, String returnTime);
    
    // TODO: getFlightBookings() // Admin only
    
    void defineTravelDoc(String flightNumber, String ticketId, String passengerId, String destination, String dateTime, Integer price
            , String boardPassIpnsKeyName, String passportId, String visaId); // Admin only but user needs to add passport and visa (through getTravelDocs addPassport?)
    LinkedHashMap<String, TravelDocument> getTravelDocs(); // User-specific
    void defineWelcomePackage(String id, String name, String description); // Admin only
    LinkedHashMap<String, WelcomePackage> getWelcomePackages(); // Anyone but only admin can modify/mutate; others can only get    
    Movie defineMovie(String ipnsKeyName, String id, String name, String description, String source);
    LinkedHashMap<String, Movie> getMovies();
    AudioRecording defineAudioRecording(String ipnsKeyName, String id, String name, String description, String source);
    LinkedHashMap<String, AudioRecording> getAudioRecordings(); // User-specific
    VideoRecording defineVideoRecording(String ipnsKeyName, String id, String name, String description, String source);
    LinkedHashMap<String, VideoRecording> getVideoRecordings(); // User-specific
    ExperienceDocument defineExperienceDocument(String passengerId, String documentId, String name, String description);
    LinkedHashMap<String, ExperienceDocument> getExperienceDocuments(); // User-specific
    
    // TODO
    Note defineFeedback();
    // TODO: getFeedback() // User-specific
    
}
