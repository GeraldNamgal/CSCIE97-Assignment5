package com.cscie97.ists.customer;

import java.util.LinkedHashMap;

import com.cscie97.ists.authentication.AuthTokenTuple;

public class ExperienceDocument extends Document {
    
    public LinkedHashMap<String, Image> images;    
    public LinkedHashMap<String, VideoRecording> videoRecordings;
    public LinkedHashMap<String, AudioRecording> audioRecordings;
    
    public ExperienceDocument(String id, String name, String description)
    {
        super(id, name, description);     
    }
    
    /* Methods */
    
    public void addImage(Image image, AuthTokenTuple authTokenTuple)
    {
        // Add to list
    }
       
    public void addVideoRecording(VideoRecording videoRecording, AuthTokenTuple authTokenTuple)
    {
        // Add to list
    }
    
    public void addAudioRecording(AudioRecording audioRecording, AuthTokenTuple authTokenTuple)
    {
        // Add to list
    }
}
