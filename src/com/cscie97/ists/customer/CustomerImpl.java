package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.Credential;
import com.cscie97.ists.manage.FlightManagementService;


public class CustomerImpl implements CustomerService {

    String repositoryIpnsKeyName;
    FlightManagementService manager;
    com.cscie97.ledger.CommandProcessor ledgerCp;
    
    LinkedHashMap<String, Passenger> passengers;
    LinkedHashMap<String, Passenger> credentialUserIndexes;
    LinkedHashMap<String, PointOfInterest> pointsOfInterest;
    LinkedHashMap<String, Image> images;
    LinkedHashMap<String, Note> notes;
    LinkedHashMap<String, FlightBooking> flightBookings;
    LinkedHashMap<String, TravelDocument> travelDocuments;
    LinkedHashMap<String, WelcomePackage> welcomePackages;
    LinkedHashMap<String, ExperienceDocument> experienceDocuments;
    LinkedHashMap<String, Movie> movies;
    LinkedHashMap<String, VideoRecording> videoRecordings;
    LinkedHashMap<String, AudioRecording> audioRecordings;
        
    /* Constructor */
    
    public CustomerImpl(FlightManagementService manager, com.cscie97.ledger.CommandProcessor ledgerCp)
    {
        // TODO: ???
        
        this.manager = manager;
        this.ledgerCp = ledgerCp;
        
        // TODO: Create a database (i.e., text file?) on IPFS to store data and to retrieve repositoryIpnsKeyName
    }
    
    /* Utility Methods */
    
    // For hashing credentials
    public String hashCalculator(String originalString)
    {
        return null;       
    }
    
    public String objectToJson(Object object)
    {
        return null;
    }
    
    public Object jsonToObject(String json)
    {
        return null;
    }
    
    /* API Methods */
    
    @Override
    public void pullFromIpfsRepo(String ipnsKeyName) {
        
        // Downloads customer service data from the remote Ipfs repo to merge its state with customer service data workspace in
        // local memory; merge conflicts are handled...; database can be a json text file...; populates list of passengers, points
        // of interest, etc.; ...?
    }

    @Override
    public void pushToIpfsRepo(String ipnsKeyName) {
        
        // Uploads and merges local customer service data (including updates) to the central remote Ipfs repo; merge conflicts
        // are handled...; database can be a json text file...; ...?
    }
    
    @Override
    public Passenger registerPassenger(String id, String name, String account, String email) {

        Passenger passenger = new Passenger(id, name, account, email);
        
        // put passenger in passengers list
        
        return passenger;
    }
    
    @Override
    public void addPassengerCredential(String passengerId, String type, String value)
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
    public PointOfInterest definePointOfInterest(String id, String name, String type, String description,
            String location) {
        
        PointOfInterest ptOfInterest = new PointOfInterest(id, name, type, description, location);

        // Add to pointsOfInterest list
                
        return null;
    }

    @Override
    public Image defineImage(String ipnsKeyName, String id, String name, String description, String source) {

        Image image = new Image(ipnsKeyName, id, name, description, source);
        
        // Add to images list
        
        return null;
    }

    @Override
    public Note defineNote(String id, String description, String message) {

        Note note = new Note(id, description, message);
        
        // Add note to notes list
        
        return null;
    }
    
    @Override
    public LinkedHashMap<String, PointOfInterest> getPointsOfInterest() {
        
        return pointsOfInterest;
    }
    
    @Override
    public LinkedHashMap<String, Image> getImages() {
        
        return images;
    }

    @Override
    public LinkedHashMap<String, Note> getNotes() {
        
        return notes;
    }
    
    @Override
    public void bookFlight(String id, String flightNumber, String destination, String passengerId, Integer price, String type
            , String departureTime, String returnTime)
    {
        FlightBooking flightBooking = null;
        
        // Add to list of flightBookings
    }   
    
    @Override
    public void defineTravelDoc(String flightNumber, String ticketId, String passengerId, String destination, String dateTime, Integer price
            , String boardPassIpnsKeyName, String passportId, String visaId) {
        
        TravelDocument travelDocument = null;
        
        // Add to list of travelDocuments
    }
    
    @Override
    public void defineWelcomePackage(String id, String name, String description) {
        
        WelcomePackage welcomePackage = null;
        
        // Add to list of welcomePackages
    }

    @Override
    public LinkedHashMap<String, TravelDocument> getTravelDocs() {

        return travelDocuments;
    } 
    
    @Override
    public LinkedHashMap<String, WelcomePackage> getWelcomePackages() {
        
        return welcomePackages;
    }

    @Override
    public Movie defineMovie(String ipnsKeyName, String id, String name, String description, String source) {
        
        Movie movie = null;
        
        return movie;
    }

    @Override
    public LinkedHashMap<String, Movie> getMovies() {
        
        return movies;
    }
    
    @Override
    public AudioRecording defineAudioRecording(String ipnsKeyName, String id, String name, String description, String source) {
        
        AudioRecording audioRecording = null;
        
        return audioRecording;
    }

    @Override
    public LinkedHashMap<String, AudioRecording> getAudioRecordings() {
        
        return audioRecordings;
    }
    
    @Override
    public VideoRecording defineVideoRecording(String ipnsKeyName, String id, String name, String description,
            String source) {
        
        return null;
    }

    @Override
    public LinkedHashMap<String, VideoRecording> getVideoRecordings() {
       
        return videoRecordings;
    }
    
    @Override
    public ExperienceDocument defineExperienceDocument(String passengerId, String documentId, String name, String description) {
        
        ExperienceDocument document = null;
        
        // Add to list of documents
        
        return document;
    }

    @Override
    public LinkedHashMap<String, ExperienceDocument> getExperienceDocuments() {
        
        return experienceDocuments;
    }

    @Override
    public Note defineFeedback() {
        // TODO Auto-generated method stub
        return null;
    }

    

              
}
