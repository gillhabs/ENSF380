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
This enum represents the different species of animals that can be admitted to the centre.
Each enum value has methods to get information about how to care for and feed the animal.
*/
package edu.ucalgary.oop;

public enum AnimalSpecies {
    COYOTE,
    FOX,
    PORCUPINE,
    BEAVER,
    RACOON;

    /**
     * Returns the time to clean the cage of an animal of this species.
     * 
     * @return the time to clean the cage of an animal of this species
     */
    public int cage() {
        switch(this) {
            case COYOTE:
                return 5;
            case FOX:
                return 5;
            case PORCUPINE:
                return 10;
            case BEAVER:
                return 5;
            default: //value checked before already, so there should not be an invalid enum, remaining would be RACOON
                return 5;
        }
    }

    /**
     * Returns the time needed to feed an animal of this species.
     * 
     * @return the time needed to feed an animal of this species
     */
    public int feed() {
        switch(this) {
            case COYOTE:
                return 5;
            case FOX:
                return 5;
            case PORCUPINE:
                return 5;
            case BEAVER:
                return 5;
            default: //value checked before already, so there should not be an invalid enum, remaining would be RACOON
                return 5;
        }
    }

    /**
     * Returns the amount of preparation time needed to prepare an animal of this species for feeding.
     * 
     * @return the amount of preparation time needed to prepare an animal of this species for feeding
     */
    public int prep() {
        switch(this) {
            case COYOTE:
                return 50;
            case FOX:
                return 5;
            case PORCUPINE:
                return 0;
            case BEAVER:
                return 0;
            default: //value checked before already, so there should not be an invalid enum, remaining would be RACOON
                return 0;
        }
    }

    /**
     * Returns an array containing the feeding window for an animal of this species, represented as the start
     * and end hours during which the animal can be fed.
     * 
     * @return an array containing the feeding window for an animal of this species
     */
    public int[] feedWindow() {
        switch(this) {
            case COYOTE:
                return new int[]{19,21};
            case FOX:
                return new int[]{0,2};
            case PORCUPINE:
                return new int[]{19,21};
            case BEAVER:
                return new int[]{8,11};
            default: //value checked before already, so there should not be an invalid enum, remaining would be RACOON
                return new int[]{0,2};
        }
    }
}
