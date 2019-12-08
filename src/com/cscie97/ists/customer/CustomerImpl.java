package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthTokenTuple;
import com.cscie97.ists.authentication.Credential;
import com.cscie97.ists.authentication.StoreAuthenticationService;
import com.cscie97.ists.resource.ResourceManagementService;


public class CustomerImpl implements CustomerService {

    String repositoryIpnsKeyName;    
    com.cscie97.ledger.CommandProcessor ledgerCp;
    ResourceManagementService resourceImpl;
    StoreAuthenticationService authenticator;
    
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
    LinkedHashMap<String, Note> feedback;
    LinkedHashMap<String, Music> music;
    LinkedHashMap<String, Book> books;
    LinkedHashMap<String, Flight> flights;
    LinkedHashMap<String, MissionReport> missionReports;
    LinkedHashMap<String, Discovery> discoveries;
        
    /* Constructor */
    
    public CustomerImpl(com.cscie97.ledger.CommandProcessor ledgerCp, ResourceManagementService resourceImpl
            , StoreAuthenticationService authenticator)
    {
        // TODO: ???
        
        this.ledgerCp = ledgerCp;
        this.resourceImpl = resourceImpl;
        this.authenticator = authenticator;
        
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
        // Returns an Object from a json
        return ObjectFactory.getObject("");
    }
    
    /* API Methods */
    
    @Override
    public void pullFromIpfsRepo(AuthTokenTuple authTokenTuple) {
        
        // Downloads customer service data from the remote Ipfs repo to merge its state with customer service data workspace in
        // local memory; merge conflicts are handled...; database can be a json text file...; populates list of passengers, points
        // of interest, etc.; ...?
        
        
    }

    @Override
    public void pushToIpfsRepo(AuthTokenTuple authTokenTuple) {
        
        // Uploads and merges local customer service data (including updates) to the central remote Ipfs repo; merge conflicts
        // are handled...; database can be a json text file...; ...?
        
        
    }
    
    @Override
    public String getIpnsKeyName(AuthTokenTuple authTokenTuple) {
        
        return repositoryIpnsKeyName;
    } 
    
    @Override
    public LinkedHashMap<String, Flight> getFlights(AuthTokenTuple authTokenTuple) {
        
        return flights;
    }
    
    @Override
    public Passenger registerPassenger(String id, String name, String account, String email, AuthTokenTuple authTokenTuple) {

        Passenger passenger = new Passenger(id, name, account, email);
        
        // put passenger in passengers list
        
        return passenger;
    }
    
    @Override
    public void addPassengerCredential(String passengerId, String type, String value, AuthTokenTuple authTokenTuple)
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
    public LinkedHashMap<String, Passenger> getPassengers(AuthTokenTuple authTokenTuple) {
        
        return passengers;
    }
    
    @Override
    public PointOfInterest definePointOfInterest(String id, String name, String type, String description,
            String location, AuthTokenTuple authTokenTuple) {
        
        PointOfInterest ptOfInterest = new PointOfInterest(id, name, type, description, location);

        // Add to pointsOfInterest list
                
        return null;
    }

    @Override
    public Image defineImage(String ipnsKeyName, String id, String name, String description, String source, AuthTokenTuple authTokenTuple) {

        Image image = new Image(ipnsKeyName, id, name, description, source);
        
        // Add to images list
        
        return null;
    }

    @Override
    public Note defineNote(String id, String description, String message, AuthTokenTuple authTokenTuple) {

        Note note = new Note(id, description, message);
        
        // Add note to notes list
        
        return null;
    }
    
    @Override
    public LinkedHashMap<String, PointOfInterest> getPointsOfInterest(AuthTokenTuple authTokenTuple) {
        
        return pointsOfInterest;
    }
    
    @Override
    public LinkedHashMap<String, Image> getImages(AuthTokenTuple authTokenTuple) {
        
        return images;
    }

    @Override
    public LinkedHashMap<String, Note> getNotes(AuthTokenTuple authTokenTuple) {
        
        return notes;
    }
    
    @Override
    public FlightBooking bookFlight(String id, String flightId, String destination, String passengerId, Integer price, String type
            , String departureTime, String returnTime, AuthTokenTuple authTokenTuple)
    {
        // Get flight 
        Flight flight = flights.get(flightId);       
        
        // Get Passenger
        Passenger passenger = passengers.get(passengerId);
        
        // Book flight
        FlightBooking flightBooking = new FlightBooking(id, flight, destination, passenger, price, type, departureTime, returnTime);
        
        // Add to list of flightBookings
        flightBookings.put(id, flightBooking);   
        
        // Create flight transaction
        String txnId = ledgerCp.processTransaction("txnId", price, 10, "description", passenger.getAccount(), "ists account");        
        
        // Get WelcomePackage
        WelcomePackage welcomePackage = welcomePackages.get(null);
        
        // Create Travel Doc
        TravelDocument travelDoc = new TravelDocument( "travelDocId",  flightId,  "ticketId",  "passengerName",  "destination",  "dateTime",  price
                ,  "boardPassIpnsKeyName",  "passportId",  "visaId", welcomePackage);        
        
        // Add travel doc to list
        travelDocuments.put("travelDocId", travelDoc);
        
        return flightBooking;
    }
    
    @Override
    public LinkedHashMap<String, FlightBooking> getFlightBookings(AuthTokenTuple authTokenTuple) {
        
        return flightBookings;
    }
    
    @Override
    public TravelDocument defineTravelDoc(String id, String flightNumber, String ticketId, String passengerName, String destination, String dateTime, Integer price
            , String boardPassIpnsKeyName, String passportId, String visaId, String welcomePackageId, AuthTokenTuple authTokenTuple) {
        
        // Get WelcomePackage
        WelcomePackage welcomePackage = null;        
        
        return null;
    }
    
    @Override
    public WelcomePackage defineWelcomePackage(String id, String name, String description, AuthTokenTuple authTokenTuple) {
        
        WelcomePackage welcomePackage = null;
        
        // Add to list of welcomePackages
        
        return welcomePackage;
    }

    @Override
    public LinkedHashMap<String, TravelDocument> getTravelDocs(AuthTokenTuple authTokenTuple) {

        return travelDocuments;
    } 
    
    @Override
    public LinkedHashMap<String, WelcomePackage> getWelcomePackages(AuthTokenTuple authTokenTuple) {
        
        return welcomePackages;
    }

    @Override
    public Movie defineMovie(String ipnsKeyName, String id, String name, String description, String source, AuthTokenTuple authTokenTuple) {
        
        Movie movie = null;
        
        // Add to list
        
        return movie;
    }

    @Override
    public LinkedHashMap<String, Movie> getMovies(AuthTokenTuple authTokenTuple) {
        
        return movies;
    }
    
    @Override
    public AudioRecording defineAudioRecording(String ipnsKeyName, String id, String name, String description, String source
            ,AuthTokenTuple authTokenTuple) {
        
        AudioRecording audioRecording = null;
        
        // Add to list
        
        return audioRecording;
    }

    @Override
    public LinkedHashMap<String, AudioRecording> getAudioRecordings(AuthTokenTuple authTokenTuple) {
        
        return audioRecordings;
    }
    
    @Override
    public VideoRecording defineVideoRecording(String ipnsKeyName, String id, String name, String description,
            String source, AuthTokenTuple authTokenTuple) {
        
        // Add to list
        
        return null;
    }

    @Override
    public LinkedHashMap<String, VideoRecording> getVideoRecordings(AuthTokenTuple authTokenTuple) {
       
        return videoRecordings;
    }
    
    @Override
    public ExperienceDocument defineExperienceDocument(String id, String name, String description
            , AuthTokenTuple authTokenTuple) {
        
        ExperienceDocument document = null;
        
        // Add to list of documents
        
        return document;
    }

    @Override
    public LinkedHashMap<String, ExperienceDocument> getExperienceDocuments(AuthTokenTuple authTokenTuple) {
        
        return experienceDocuments;
    }

    @Override
    public Note defineFeedback(String id, String description, String message, AuthTokenTuple authTokenTuple) {
         
        Note note = null;
        
        // Add to list of feedback
        
        return note;
    }

    @Override
    public LinkedHashMap<String, Note> getFeedback(AuthTokenTuple authTokenTuple) {
        
        return feedback;
    }

    @Override
    public Book defineBook(String ipnsKeyName, String id, String name, String description, String source,
            AuthTokenTuple authTokenTuple) {

        // Add to list
        
        return null;
    }
    
    @Override
    public LinkedHashMap<String, Book> getBooks(AuthTokenTuple authTokenTuple) {
        return books;
    }

    @Override
    public Music defineMusic(String ipnsKeyName, String id, String name, String description, String source,
            AuthTokenTuple authTokenTuple) {

        // Add to list
        
        return null;
    }   

    @Override
    public LinkedHashMap<String, Music> getMusic(AuthTokenTuple authTokenTuple) {
        return music;
    }

    @Override
    public MissionReport defineMissionReport(String id, String name, String description,
            AuthTokenTuple authTokenTuple) {

        MissionReport missionReport = null;
        
        // Add to list
        
        return missionReport;
    }

    @Override
    public LinkedHashMap<String, MissionReport> getMissionReports(AuthTokenTuple authTokenTuple) {
        return missionReports;
    }

    @Override
    public Discovery defineDiscovery(String id, String name, String description, String type,
            AuthTokenTuple authTokenTuple) {
        
        Discovery discovery = null;
        
        return discovery;
    }

    @Override
    public LinkedHashMap<String, Discovery> getDiscoveries(AuthTokenTuple authTokenTuple) {
        return discoveries;
    }                          
}
