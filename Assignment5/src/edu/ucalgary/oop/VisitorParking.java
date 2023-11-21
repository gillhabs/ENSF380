package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.TreeSet;  
import java.util.*;

public class VisitorParking {
    private HashMap<String, TreeSet<LocalDate>> parkingRecord 
    	= new HashMap<String, TreeSet<LocalDate>>();


    public VisitorParking() throws IllegalArgumentException{

    }

    public VisitorParking(String licence) throws IllegalArgumentException {
        addVisitorReservation(licence);
    }

    public VisitorParking(String licence, LocalDate date) throws IllegalArgumentException {
        addVisitorReservation(licence, date);
    }

    public void addVisitorReservation(String licence) throws IllegalArgumentException {
    	
        int vehicles = 0;
        LocalDate date = LocalDate.now();
        String validLicence = Parking.standardizeAndValidateLicence(licence);
        
        for (HashMap.Entry<String, TreeSet<LocalDate>> entry : parkingRecord.entrySet()) {
            TreeSet<LocalDate> dates = entry.getValue();
            Iterator<LocalDate> iterator = dates.iterator();
            
            while (iterator.hasNext()) {
                LocalDate treeDate = iterator.next();
                if (date.isEqual(treeDate) || date.isEqual(treeDate.plusDays(1)) || date.isEqual(treeDate.plusDays(2))) {
                    vehicles++;
                }
            }
        }

        if (vehicles == 2) {
            throw new IllegalArgumentException();
        } 

        if (parkingRecord.containsKey(validLicence)) {
        	
            if (licenceIsRegisteredForDate(validLicence)) {
                throw new IllegalArgumentException();
            } 
            
            else {
                parkingRecord.get(validLicence).add(date);
            }
        } 
        
        else {
            if (vehicles < 2) {
            	
                TreeSet<LocalDate> dates = new TreeSet<LocalDate>(Collections.reverseOrder());
                dates.add(date);
                this.parkingRecord.put(validLicence, dates);
            }
        }
    }

    public void addVisitorReservation(String licence, LocalDate myDate) 
    		throws IllegalArgumentException {
    	
        int vehicles = 0;
        String validLicence = Parking.standardizeAndValidateLicence(licence);
        
        for (HashMap.Entry<String, TreeSet<LocalDate>> entry : parkingRecord.entrySet()) {
            TreeSet<LocalDate> dates = entry.getValue();
            Iterator<LocalDate> iterator = dates.iterator();

            while (iterator.hasNext()) {
			    LocalDate date = iterator.next();
			    if (myDate.isEqual(date) || myDate.isEqual(date.plusDays(1)) || myDate.isEqual(date.plusDays(2))) {
				    vehicles++; 
			    }
		    }
        }

        LocalDate currDate = LocalDate.now();
        if (myDate.isBefore(currDate) || vehicles ==2) {
            throw new IllegalArgumentException();
        }

        if (parkingRecord.containsKey(validLicence)) {
            if (licenceIsRegisteredForDate(validLicence, myDate)) {
                throw new IllegalArgumentException();
            } else {
                parkingRecord.get(validLicence).add(myDate);
            }
        } else {
            if (vehicles < 2) {
                TreeSet<LocalDate> dates = new TreeSet<LocalDate>(Collections.reverseOrder());
                dates.add(myDate);
                this.parkingRecord.put(validLicence, dates);
            }
        }
    }

    public boolean licenceIsRegisteredForDate(String licence) 
    		throws IllegalArgumentException {
    	
        boolean flag = false;
        String validLicence = Parking.standardizeAndValidateLicence(licence);
        LocalDate myDate = LocalDate.now();

        if (parkingRecord.containsKey(validLicence)) {
            TreeSet<LocalDate> dates = parkingRecord.get(validLicence);
            Iterator<LocalDate> iterator = dates.iterator();

            while (iterator.hasNext()) {
                LocalDate date = iterator.next();
                if (myDate.isEqual(date) || myDate.isEqual(date.plusDays(1)) || myDate.isEqual(date.plusDays(2))) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate myDate) 
    		throws IllegalArgumentException {
    	
        boolean isDate = false;
        String validLicence = Parking.standardizeAndValidateLicence(licence);
        
        if (parkingRecord.containsKey(validLicence)) {
            TreeSet<LocalDate> dates = parkingRecord.get(validLicence);
			Iterator<LocalDate> iterator =  dates.iterator();
			
            while (iterator.hasNext()) {
				LocalDate date = iterator.next();
				if(myDate.isEqual(date)|| myDate.isEqual(date.plusDays(1)) || myDate.isEqual(date.plusDays(2))){
					isDate = true;
					return isDate; 
				}
			}
        }
        return isDate;
    }

    public ArrayList<String> getLicencesRegisteredForDate() 
    		throws IllegalArgumentException {
    	
		ArrayList<String> list = new ArrayList<>();
        
		for (HashMap.Entry<String, TreeSet<LocalDate>> entry : parkingRecord.entrySet()) {
			if (licenceIsRegisteredForDate(entry.getKey())) {
                list.add(entry.getKey());
            }
		}
	    return list; 
	}
	
    public ArrayList<String> getLicencesRegisteredForDate(LocalDate myDate) 
    		throws IllegalArgumentException {
    	
		ArrayList<String> list = new ArrayList<>(); 
		
        for (HashMap.Entry<String, TreeSet<LocalDate>> entry : parkingRecord.entrySet()) {
			if (licenceIsRegisteredForDate(entry.getKey(), myDate)) {
                list.add(entry.getKey());
            }
		}			
        return list;
    }
	

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence) {
    	
	    ArrayList<LocalDate> list = new ArrayList<>();
		String validLicence = Parking.standardizeAndValidateLicence(licence);
		
        if (parkingRecord.containsKey(validLicence)) {
        	
			TreeSet<LocalDate> date = parkingRecord.get(validLicence);
			Iterator<LocalDate> iterator = date.descendingIterator();

			while (iterator.hasNext()) {
				LocalDate newDate = iterator.next(); 
				list.add(newDate);
				list.add(newDate.plusDays(1));
				list.add(newDate.plusDays(2)); 
			}
		}
        return list; 
	}

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence) 
    		throws IllegalArgumentException {
    	
		ArrayList<LocalDate> list = new ArrayList<>();
		String validLicence = Parking.standardizeAndValidateLicence(licence);
		
        if (parkingRecord.containsKey(validLicence)) {
        	
			TreeSet<LocalDate> dates = parkingRecord.get(validLicence); 
			Iterator<LocalDate> iterator = dates.descendingIterator();

			while (iterator.hasNext()) {
				LocalDate date = iterator.next();
				list.add(date); 
			}
		}
        return list; 
	}

    public HashMap<String,TreeSet<LocalDate>> getParkingRecord() {
		return this.parkingRecord; 
	}

}
