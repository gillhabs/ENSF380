package edu.ucalgary.oop;

public class IllegalSchedule extends Exception {
    public IllegalSchedule() {
        super("Schedule cannot be generated");
    }
}
