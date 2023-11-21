package edu.ucalgary.oop;

public class ArgFileNotFoundException extends Exception{
	
    public ArgFileNotFoundException() {
    	
        super("Error. File not found.");
    }
}