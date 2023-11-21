package edu.ucalgary.oop;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Sensor implements Cloneable, FormattedOutput {
	
	private String sensor;
	
	private static final String REGEX = "\\(([a-z]+)\\)";
	
	private static final Pattern PATTERN = Pattern.compile(REGEX);
	
	
	public Sensor(String sensor) throws IllegalArgumentException {
		
		Matcher match = PATTERN.matcher(sensor);
        if(match.find()) {
            this.sensor = match.group(1);
        }
        else {
            throw new IllegalArgumentException();
        }
	}
	
	public String getSensor() {return this.sensor;}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Sensor copy = (Sensor)super.clone();
        copy.sensor = this.sensor;
		
		return copy;
	}
	

	public String getFormatted() {
		String output = "Sensor: " + this.sensor;
        return output;
	}
}