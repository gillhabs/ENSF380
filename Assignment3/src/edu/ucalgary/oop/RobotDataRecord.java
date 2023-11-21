package edu.ucalgary.oop;

import java.util.ArrayList;


public class RobotDataRecord implements Cloneable{
	
	private ArrayList<RobotDataLine> log;
	
	public RobotDataRecord(String[] array) {
		
		this.log = new ArrayList<RobotDataLine>();
        
        for(String line: array) {
            try{
                RobotDataLine newLine = new RobotDataLine(line);
                log.add(newLine);
            }
            catch(IllegalArgumentException e) {} 
            
        }
    }
	
	public RobotDataLine getLine(int index) {
		return log.get(index);
	}
	
	public ArrayList<RobotDataLine> getDataRecord() {
		return this.log;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		RobotDataRecord copy = (RobotDataRecord)super.clone();
        copy.log = new ArrayList<RobotDataLine>();

        for(int i = 0; i < this.log.size(); i++){
            RobotDataLine newLine = (RobotDataLine)this.log.get(i).clone();
            copy.log.add(newLine); 
        }
        
        return copy;
    }
	
	
	
	
}