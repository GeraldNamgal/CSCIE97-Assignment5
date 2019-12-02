package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

public interface CustomerService {

    void pullFromIpfsRepo(String ipnsKeyName);
    void pushToIpfsRepo(String ipnsKeyName);
    Passenger registerPassenger(String id, String name, String account, String email);
    void addPassengerCredential(String passengerId, String type, String value);    
    PointOfInterest definePointOfInterest(String id, String name, String type, String description, String location);
    LinkedHashMap<String, PointOfInterest> getPointsOfInterest();
    Image defineImage(String ipnsKeyName, String id, String name, String description, String source);
    LinkedHashMap<String, Image> getImages();
    Note defineNote(String id, String description, String message);
    LinkedHashMap<String, Note> getNotes();     
    void bookFlight(String id, String flightNumber, String destination, String passengerId, Integer price, String type
            , String departureTime, String returnTime);    
    void defineTravelDoc();
    LinkedHashMap<String, TravelDocument> getTravelDocs();
    void defineWelcomePackage(String id, String name, String description);
    LinkedHashMap<String, WelcomePackage> getWelcomePackages();    
    Movie defineMovie(String ipnsKeyName, String id, String name, String description, String source);
    LinkedHashMap<String, Movie> getMovies();
    AudioRecording defineAudioRecording(String ipnsKeyName, String id, String name, String description, String source);
    LinkedHashMap<String, AudioRecording> getAudioRecordings();
    VideoRecording defineVideoRecording(String ipnsKeyName, String id, String name, String description, String source);
    LinkedHashMap<String, VideoRecording> getVideoRecordings();
    ExperienceDocument defineExperienceDocument(String passengerId, String documentId, String name, String description);
    LinkedHashMap<String, ExperienceDocument> getExperienceDocuments();   
    
    // TODO
    Note defineFeedback();
}
