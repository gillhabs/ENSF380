/**
@author 
    Halanna Le
    Grace Jang
    Christy Guirguis
    Gillian Habermehl
@version 1.2
@since 1.0
*/

/*
This class represents a treatment given to an animal. It includes information about 
the animal being treated, the medical task being performed, and the start hour of the treatment.
*/
package edu.ucalgary.oop;

public class Treatment {

    private Animal animal;
    private MedicalTask medical;
    private int startHour;

    /**
     * Initializes a new Treatment object with the specified animal, medical task, and start hour.
     * 
     * @param animal the animal being treated
     * @param task the medical task being performed
     * @param startHour the start hour of the treatment
     */
    Treatment(Animal animal, MedicalTask task, int startHour){
        this.animal = animal;
        this.medical = task;
        this.startHour = startHour;
    }

    /**
     * Returns the start hour of the treatment.
     * 
     * @return the start hour of the treatment
     */
    public int getStartHour() {
        return this.startHour;
    }

    /**
     * Returns the medical task being performed in the treatment.
     * 
     * @return the medical task being performed in the treatment
     */
    public MedicalTask getMedical() {
        return this.medical;
    }

    /**
     * Returns the animal being treated in the treatment.
     * 
     * @return the animal being treated in the treatment
     */
    public Animal getAnimal() {
        return this.animal;
    }
}
