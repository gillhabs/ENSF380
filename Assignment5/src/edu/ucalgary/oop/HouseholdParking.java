/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;
import java.time.LocalDate;
import java.util.*;
import java.util.Collections;

public class HouseholdParking extends CalgaryProperty {
	
    private int maxLicences = 1;
    private String residentLicence;
    private VisitorParking visitors = new VisitorParking();
    
    
    public HouseholdParking(int taxRollNumber, String zoning, String streetName, 
    		int buildingNumber, String postCode, String buildingAnnex) throws IllegalArgumentException {
        super(taxRollNumber,zoning,streetName,buildingNumber,postCode,buildingAnnex);
    }

    public HouseholdParking(int taxRollNumber, String zoning, 
    		String streetName, int buildingNumber, String postCode) throws IllegalArgumentException {
        super(taxRollNumber,zoning,streetName,buildingNumber,postCode);
    }

    /*
     * Add a licence to the first empty spot in residentLicence, or replace the most recent
     * Ignore if the licence is already stored
     * @param licence - The licence plate to be added
     * @throws IllegalArgumentException if licence plate isn't a valid Alberta licence
    */
    public void addOrReplaceResidentLicence(String licence) throws IllegalArgumentException {
        licence = Parking.standardizeAndValidateLicence(licence); 
        residentLicence = licence;
    }

    /*
     * Remove all listed licences
     * @return whether the operation succeeded or not
    */
    public boolean removeResidentLicence() {
        residentLicence = "";
        return true;
    }

    
    public String getResidentLicence() {
       return this.residentLicence;
    }

    public void addVisitorReservation(String licence) {
        visitors.addVisitorReservation(licence);
    }

    public void addVisitorReservation(String licence, LocalDate date) {
        visitors.addVisitorReservation(licence, date);
    }

    public VisitorParking getVisitors() {
        return this.visitors;
    }

    public ArrayList<String> getLicencesRegisteredForDate() {
        return visitors.getLicencesRegisteredForDate();
    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate date) {
        return visitors.getLicencesRegisteredForDate(date);
    }

    public boolean licenceIsRegisteredForDate(String licence) {
        return visitors.licenceIsRegisteredForDate(licence);
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate date) {
        return visitors.licenceIsRegisteredForDate(licence, date);
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence) {
        return visitors.getAllDaysLicenceIsRegistered(licence);
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence) {
        ArrayList<LocalDate> myDateLicences = visitors.getStartDaysLicenceIsRegistered(licence);
        return myDateLicences;
    }

}
