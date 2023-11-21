package edu.ucalgary.oop;

import java.util.Arrays;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/


public class Employee {

    private String name;

    private final String IDNUMBER;

    private String managerID;

    private Employee[] supervisedEmployees;

    public Employee(String name, String idNumber) {
        this.name = name;
        this.IDNUMBER = idNumber;
    }

    public Employee(String name, String idNumber, String managerID) {
        this.name = name;
        this.IDNUMBER = idNumber;
        this.managerID = managerID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDNumber() {
        return this.IDNUMBER;
    }

    public String getManagerID() {
        return this.managerID;
    }

    public void setManagerID(String newManager) {
        this.managerID = newManager;
    }

    public void addEmployee(Employee newEmployee) {
    	if(supervisedEmployees != null && supervisedEmployees.length > 0) {
    		Employee[] allSupervisedEmployees = Arrays.copyOf(supervisedEmployees, supervisedEmployees.length + 1);
    		allSupervisedEmployees[allSupervisedEmployees.length - 1] = newEmployee;
    		this.supervisedEmployees = allSupervisedEmployees;
    	}
    	else if(supervisedEmployees == null){
    		Employee [] allSupervisedEmployees = {newEmployee};
    		this.supervisedEmployees = allSupervisedEmployees;
    	}
    }

    public Employee[] getEmployees() {
    	return this.supervisedEmployees;

    }

}
