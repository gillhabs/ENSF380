package edu.ucalgary.oop;
/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/


public class Client {

    private String name;

    private String phoneNumber;

    private String address;

    private RewardsProfile rewardsInfo;

    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean enrollRewards(String newNumber) {
    	try {
    		this.rewardsInfo = new RewardsProfile(newNumber);
    		return true;
    	}
    	catch (InvalidRewardsNumException e){
    		return false;
    	}
    		
    	}

    public int getRewardsPoints() {
    	if(rewardsInfo != null) {return this.rewardsInfo.getPoints();}
    	else{return 0;}
    }

    public String getRewardsNumber() {
        if(rewardsInfo != null) {return this.rewardsInfo.getNumber();}
        else {return "Not enrolled";}
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String num) {
        this.phoneNumber = num;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void updatePoints(int addPoints) {
        this.rewardsInfo.setPoints(addPoints);
    }
}
