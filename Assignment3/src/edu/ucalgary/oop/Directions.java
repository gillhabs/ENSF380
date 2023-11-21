package edu.ucalgary.oop;

public enum Directions {
	
        E {
        	public String toString() {return "East";}
        },
        
        N {
        	public String toString() {return "North";}
        },
        
        NE {
        	public String toString() {return "Northeast";}
        },
        
        NW {
        	public String toString() {return "Northwest";}
        },
        
        S {
        	public String toString() {return "South";}
        },
        
        SE {
        	public String toString() {return "Southeast";}
        },
        
        SW {
        	public String toString() {return "Southwest";}
        },
        
        W {
        	public String toString() {return "West";}
        };
		
		public abstract String toString();
		
		
	}