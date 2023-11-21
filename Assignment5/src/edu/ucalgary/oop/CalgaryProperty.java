/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import java.util.*;
import java.util.regex.*;

/**
 * Class which describes a piece of property in Calgary, for use in multiple city applications.
**/
abstract class CalgaryProperty {

    protected final int TAX_ROLL_NUMBER;
    protected ZoningTypes zoning;
    protected int buildingNumber;
    protected String buildingAnnex = "";
    protected String streetName;
    protected String postCode;

    /** Getters and Setters **/
    public int getTaxRollNumber() { 
    	return this.TAX_ROLL_NUMBER; 
    }
    
    public String getZoning() { 
    	return zoning.name(); 
    }
    public int getBuildingNumber() { 
    	return this.buildingNumber; 
    }
    
    public String getBuildingAnnex() { 
    	return this.buildingAnnex; 
    }
    
    public String getStreetName() { 
    	return this.streetName;
    }
    
    public String getPostCode() { 
    	return this.postCode; 
    }
    
    public void setBuildingNumber(int number) { 
    	this.buildingNumber = number; 
    }
    
    public void setStreetName(String name) { 
    	this.streetName = name; 
    }
    
    public void setBuildingAnnex(String id) { 
    	this.buildingAnnex = id;
    }


    public void setZoning(String zone) throws IllegalArgumentException {
    	
        zone = zone.toUpperCase();
        String zones = "";
        
        for (ZoningTypes zoneType : ZoningTypes.values()) {
            if (zone.equals(zoneType.name())) {
                this.zoning = zoneType;
                return;
            }
            zones = zones + zoneType.name() + ", ";
        }
        zones = zones.replaceAll(", $", "");
        String error = String.format("'%s' is not an existing zoning type. "
        		+ "Zoning types are %s", zone, zones);
        throw new IllegalArgumentException(error);
    }

    

    public void setPostCode(String code) throws IllegalArgumentException {

        code = code.toUpperCase();
        code = code.replaceAll("[^\\w]", "");


        Pattern pattern = Pattern.compile("\\w");
        Matcher matcher = pattern.matcher(code);
        int matchCount = 0;
        while (matcher.find()) { matchCount++; }
        if (matchCount == 6) {
            this.postCode = code.substring(0,3) + " " + code.substring(3);
            return;
        }
        String error = String.format("Postcode '%s' is not 6 characters in length.", code);
        throw new IllegalArgumentException(error);
    }

    /** Constructors **/
    public CalgaryProperty(int taxRollNumber, String zoning, String streetName, int buildingNumber, 
    		String postCode, String buildingAnnex) throws IllegalArgumentException {
        this.TAX_ROLL_NUMBER = taxRollNumber;
        this.buildingAnnex = buildingAnnex;
        createProperty(zoning, streetName, buildingNumber, postCode);
    }

    public CalgaryProperty(int taxRollNumber, String zoning, String streetName, 
    		int buildingNumber, String postCode) throws IllegalArgumentException {
        createProperty(zoning, streetName, buildingNumber, postCode);
        this.TAX_ROLL_NUMBER = taxRollNumber;
    }

    /** Helpers **/
    private void createProperty(String zoning, String streetName, int buildingNumber, 
    		String postCode) throws IllegalArgumentException{
        setPostCode(postCode);
        setZoning(zoning);
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        return;
    }
}