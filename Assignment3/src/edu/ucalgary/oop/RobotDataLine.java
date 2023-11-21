package edu.ucalgary.oop;

import java.util.regex.Pattern;
import java.time.LocalDate;
import java.util.regex.Matcher;

public class RobotDataLine implements Cloneable {
	
	private String dataLine;
	
	private String robotID;
	
	private Sensor sensor;
	
	private Movement movement;
	
	private LocalDate date;
	
	
	private static final String DATE_REGEX = "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
	
	private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
	
	private static final String ROBOT_REGEX = "\\s([0-9]{3}[A-Z]{1})\\s";
	
	private static final Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);
	
	
	public RobotDataLine(String line) throws IllegalArgumentException {
		
        this.dataLine = line;

        Matcher robotMatch = ROBOT_PATTERN.matcher(this.dataLine);
        if(robotMatch.find()) this.robotID = robotMatch.group(1);
        else {
            throw new IllegalArgumentException();
        }

        this.sensor = new Sensor(this.dataLine);

        this.movement = new Movement(this.dataLine);
        
        Matcher dateMatch = DATE_PATTERN.matcher(this.dataLine);
        
        if (dateMatch.find()) {
        	
            int day = Integer.parseInt(dateMatch.group(1));
            int month = Integer.parseInt(dateMatch.group(2));
            int year = Integer.parseInt(dateMatch.group(3));
            
            try {
                this.date = LocalDate.of(year, month, day);
            }
            
            catch(Exception e) {
                throw new IllegalArgumentException();
            }
        }
		
	}
	
	public String getRobotID() {return this.robotID;}
	
	public String getDataLine() {return this.dataLine;}
	
	public Sensor getSensor() {return this.sensor;}
	
	public Movement getMovement() {return this.movement;}
	
	public LocalDate getDate() {return this.date;}

	@Override
	public Object clone() throws CloneNotSupportedException {
		RobotDataLine copy = (RobotDataLine)super.clone();
	    copy.sensor = (Sensor)this.sensor.clone();
	    copy.movement = (Movement)this.movement.clone();
	    copy.date = this.date;

		return copy;
	}
	
	
	
	
	
	
}