package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthTokenTuple;
import com.cscie97.ists.manage.Flight;

public interface CustomerService {

    void pullFromIpfsRepo(String ipnsKeyName, AuthTokenTuple authTokenTuple); // Any user
    void pushToIpfsRepo(String ipnsKeyName, AuthTokenTuple authTokenTuple); // Any user
    LinkedHashMap<String, Flight> getFlights(AuthTokenTuple authTokenTuple);
    Passenger registerPassenger(String id, String name, String account, String email, AuthTokenTuple authTokenTuple); // Public    
    LinkedHashMap<String, Passenger> getPassengers(AuthTokenTuple authTokenTuple); // User-specific   
    void addPassengerCredential(String passengerId, String type, String value, AuthTokenTuple authTokenTuple); // User-specific   
    PointOfInterest definePointOfInterest(String id, String name, String type, String description, String location, AuthTokenTuple authTokenTuple); // Admin only
    LinkedHashMap<String, PointOfInterest> getPointsOfInterest(AuthTokenTuple authTokenTuple); // Any user but only admin can modify/mutate it; others can only get
    Image defineImage(String ipnsKeyName, String id, String name, String description, String source, AuthTokenTuple authTokenTuple); // Any user
    LinkedHashMap<String, Image> getImages(AuthTokenTuple authTokenTuple); // User-specific
    Note defineNote(String id, String description, String message, AuthTokenTuple authTokenTuple); // Any user
    LinkedHashMap<String, Note> getNotes(AuthTokenTuple authTokenTuple); // User-specific     
    FlightBooking bookFlight(String id, String flightNumber, String destination, String passengerId, Integer price, String type
            , String departureTime, String returnTime, AuthTokenTuple authTokenTuple); // Any user    
    LinkedHashMap<String, FlightBooking> getFlightBookings(AuthTokenTuple authTokenTuple); // Admin only    
    TravelDocument defineTravelDoc(String id, String flightNumber, String ticketId, String passengerName, String destination, String dateTime, Integer price
            , String boardPassIpnsKeyName, String passportId, String visaId, AuthTokenTuple authTokenTuple); // Admin only but user needs to add passport and visa (through getTravelDocs addPassport?)
    LinkedHashMap<String, TravelDocument> getTravelDocs(AuthTokenTuple authTokenTuple); // User-specific
    WelcomePackage defineWelcomePackage(String id, String name, String description, AuthTokenTuple authTokenTuple); // Admin only
    LinkedHashMap<String, WelcomePackage> getWelcomePackages(AuthTokenTuple authTokenTuple); // Any user but only admin can modify/mutate; others can only get    
    Movie defineMovie(String ipnsKeyName, String id, String name, String description, String source, AuthTokenTuple authTokenTuple); // Admin
    LinkedHashMap<String, Movie> getMovies(AuthTokenTuple authTokenTuple); // Any user
    AudioRecording defineAudioRecording(String ipnsKeyName, String id, String name, String description, String source, AuthTokenTuple authTokenTuple); // Any user
    LinkedHashMap<String, AudioRecording> getAudioRecordings(AuthTokenTuple authTokenTuple); // User-specific
    VideoRecording defineVideoRecording(String ipnsKeyName, String id, String name, String description, String source, AuthTokenTuple authTokenTuple); // Any user
    LinkedHashMap<String, VideoRecording> getVideoRecordings(AuthTokenTuple authTokenTuple); // User-specific
    ExperienceDocument defineExperienceDocument(String id, String name, String description, AuthTokenTuple authTokenTuple); // Any user
    LinkedHashMap<String, ExperienceDocument> getExperienceDocuments(AuthTokenTuple authTokenTuple); // User-specific    
    Note defineFeedback(String id, String description, String message, AuthTokenTuple authTokenTuple); // Any user
    LinkedHashMap<String, Note> getFeedback(AuthTokenTuple authTokenTuple); // User-specific
    Book defineBook(String ipnsKeyName, String id, String name, String description, String source, AuthTokenTuple authTokenTuple); // Any user
    LinkedHashMap<String, Book> getBooks(AuthTokenTuple authTokenTuple); // Any user
    Music defineMusic(String ipnsKeyName, String id, String name, String description, String source, AuthTokenTuple authTokenTuple); // Any user
    LinkedHashMap<String, Music> getMusic(AuthTokenTuple authTokenTuple); // Any user
}
