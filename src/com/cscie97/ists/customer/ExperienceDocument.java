package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

public class ExperienceDocument {

    String passengerId;
    String documentId;
    String name;
    String description;
    
    public LinkedHashMap<String, Image> images;
    public LinkedHashMap<String, Note> notes;
    public LinkedHashMap<String, VideoRecording> videoRecordings;
    public LinkedHashMap<String, AudioRecording> audioRecordings;
    
    public ExperienceDocument(String passengerId, String documentId, String name, String description)
    {
        this.passengerId = passengerId;
        this.documentId = documentId;
        this.name = name;        
        this.description = description;        
    }
    
    /* Methods */
    
    public void addImage(Image image)
    {
        // Add to list
    }
    
    public void addNote(Note note)
    {
        // Add to list
    }
    
    public void addVideoRecording(VideoRecording videoRecording)
    {
        // Add to list
    }
    
    public void addAudioRecording(AudioRecording audioRecording)
    {
        // Add to list
    }
}
