/**
@author 
    Halanna Le
    Grace Jang
    Christy Guirguis
    Gillian Habermehl
@version 1.1
@since 1.0
*/

/*
The MedicalTask class represents a medical task that can be performed on an animal. It includes information about the task's ID, 
description, duration, and maximum window.
*/
package edu.ucalgary.oop;

public class MedicalTask {
    private String description;
    private int duration;
    private int taskID;
    private int maxWindow;

    /**
     * Initializes a new MedicalTask object with the specified ID, description, duration, and maximum window.
     * 
     * @param id the ID of the medical task
     * @param description the description of the medical task
     * @param duration the duration of the medical task in hours
     * @param maxWindow the maximum window of time in hours that the medical task can be performed
     */
    public MedicalTask(int id, String description, int duration, int maxWindow) {
        this.taskID = id;
        this.description = description;
        this.duration = duration;
        this.maxWindow = maxWindow;
    }
    
    /**
     * Returns the description of the medical task.
     * 
     * @return the description of the medical task
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the duration of the medical task in hours.
     * 
     * @return the duration of the medical task in hours
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Returns the ID of the medical task.
     * 
     * @return the ID of the medical task
     */
    public int getID() {
        return this.taskID;
    }

    /**
     * Returns the maximum window of time in hours that the medical task can be performed.
     * 
     * @return the maximum window of time in hours that the medical task can be performed
     */
    public int getMaxWindow() {
        return this.maxWindow;
    }
}
