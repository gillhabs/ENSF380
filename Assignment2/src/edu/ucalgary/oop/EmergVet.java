package edu.ucalgary.oop;
/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/


public class EmergVet {

    private String name;

    private String phoneNum;

    public EmergVet(String name, String phoneNuumber) {
        this.phoneNum = phoneNuumber;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

}

