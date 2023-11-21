package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movement implements Cloneable, FormattedOutput{
	
    private String action;
    
    private String direction;
    
    private final static String REGEX = "\"([A-Z]+) - ([A-Z]{1,2})";
    
    private final static Pattern PATTERN = Pattern.compile(REGEX);

    public Movement(String movement) throws IllegalArgumentException{
    	
        Matcher match = PATTERN.matcher(movement);
        
        if(match.find()) {
            this.action = match.group(1);
            this.direction = match.group(2);
        }
        
        else {
            throw new IllegalArgumentException();
        }

        boolean isAction = false;
        boolean isDirection = false;
        
        for(Directions direction: Directions.values()) {
            if (this.direction.equals(direction.name())) {
                isDirection = true;
     
            }
        }
        
        for(Actions action: Actions.values()) {
            if (this.action.equals(action.name())) {
                isAction = true;  
            }
        }

        if ((!isAction) || (!isDirection)) {
            throw new IllegalArgumentException();
        }
    }

    public String getFormatted() {
        String output = "";
        
        output += "Action: " + this.action + ", "; 
        
        Directions directionEnum;
        for(Directions direction: Directions.values()) {
            if (this.direction.equals(direction.name())) {
                directionEnum = direction;
                output += "Direction: " + directionEnum.toString();
                
            }
        }
                
        return output;
    }
    
	
    public String getAction() {return this.action;}
    public String getDirection() {return this.direction;}
    
	@Override
    public Object clone() throws CloneNotSupportedException{
        Movement copy = (Movement)super.clone(); 
        
        return copy;
	}
}