package edu.ucalgary.oop;
/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/


public class Pet {

    private final String NAME;

    private final String SPECIES;

    private final String BREED;

    private final String COLOUR;

    private boolean vaccineStatus = false;

    private Client owner;

    private EmergVet vet;

    private CareProfile care;

    public Pet(String name, String species, String breed, String colour, Client owner) {
        this.NAME = name;
        this.SPECIES = species;
        this.BREED = breed;
        this.COLOUR = colour;
        this.owner = owner;
    }

    public void setVet(EmergVet vet) {
    	this.vet = new EmergVet(vet.getName(), vet.getPhoneNum());
    }

    public EmergVet getVet() {
        return this.vet;
    }

    public void updateVaccineStatus(boolean change) {
    	this.vaccineStatus = change;
    }

    public boolean getVaccineStatus() {
        return this.vaccineStatus;
    }

    public void setCare(String[] meds, String medInstr, String feedingInstr) {
        this.care = new CareProfile(meds, medInstr, feedingInstr);
    }

    public String getCareSummary() {
    	StringBuilder careSum = new StringBuilder();
    	careSum.append("Care for " + this.NAME + ":\n");
    	careSum.append(care.summarizeCareInstructions());
    	return careSum.toString();
    }

    public Client getOwner() {
        return this.owner;
    }

    public void setOwner(Client updateOwner) {
        this.owner.setName(updateOwner.getName());
        this.owner.setPhoneNumber(updateOwner.getPhoneNumber());
        this.owner.setAddress(updateOwner.getAddress());
        this.owner.enrollRewards(updateOwner.getRewardsNumber());
        this.owner.updatePoints(updateOwner.getRewardsPoints());

    }

    public String getName() {
        return this.NAME;
    }

    public String getSpecies() {
        return this.SPECIES;
    }

    public String getBreed() {
        return this.BREED;
    }

    public String getColour() {
        return this.COLOUR;
    }





}
