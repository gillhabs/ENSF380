package edu.ucalgary.oop;

public class CommandArgumentNotProvidedException extends Exception{
	
    public CommandArgumentNotProvidedException() {
    	
        super("Error. Command line argument not provided.");
    }
}
