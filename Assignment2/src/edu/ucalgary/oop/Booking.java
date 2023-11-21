
package edu.ucalgary.oop;
/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/


public class Booking {
	
	private final String STARTDATE;
	
	private final String ENDDATE;
	
	private final Pet BOOKEDPET;
	
	private final Employee CAREGIVER;
	
	public Booking(Pet pet, Employee assigned, String startDate, String endDate) {
		this.BOOKEDPET = pet;
		this.CAREGIVER = assigned;
		this.STARTDATE = startDate;
		this.ENDDATE = endDate;
	}
	
	public String getStartDate() {
		return this.STARTDATE;
	}
	
	public String getEndDate() {
		return this.ENDDATE;
	}
	
	public Pet getBookedPet() {
		return this.BOOKEDPET;
	}
	
	public Employee getCaregiver() {
		return this.CAREGIVER;
	}

}
