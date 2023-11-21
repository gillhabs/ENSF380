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
This class represents an animal in the Example Wildlife Rescue Centre.
*/

package edu.ucalgary.oop;
import java.util.*;

public class Animal {
    private String name;
    private String species;
    private int animalID;

    /**
     * Creates a new `Animal` object with the specified ID, name, and species.
     * 
     * @param id the ID of the animal
     * @param name the name of the animal
     * @param species the species of the animal
     * @throws IllegalArgumentException if the species is not valid
     */
    public Animal(int id, String name, String species) throws IllegalArgumentException{
        this.name = name;
        this.animalID = id;
        if (!checkAnimalSpecies(species)) {
            throw new IllegalArgumentException("Invalid species");
        }
        this.species = species;
    }

    /**
     * Returns the name of the animal.
     * 
     * @return the name of the animal
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the species of the animal.
     * 
     * @return the species of the animal
     */
    public String getSpecies() {
        return this.species;
    }

    /**
     * Returns the ID of the animal.
     * 
     * @return the ID of the animal
     */
    public int getID() {
        return this.animalID;
    }

    /**
     * Checks if the specified animal species is valid.
     * 
     * @param species the species to check
     * @return true if the species is valid, false otherwise
     */
    public boolean checkAnimalSpecies( String species) {
        for (int i=0; i < AnimalSpecies.values().length; i++) {
            if (Objects.equals(species, AnimalSpecies.values()[i].toString().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
