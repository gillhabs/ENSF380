package edu.ucalgary.oop;
/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/


public class ReportCard {
	
	private final Booking REPORT;
	
	public ReportCard(Booking reportInfo) {
		this.REPORT = reportInfo;
	}
	
	public String printReport() {
		return(this.REPORT.getCaregiver().getName() + " enjoyed taking care of " 
				+ this.REPORT.getBookedPet().getName() + ". See you next time!");
	}
}
