package edu.ucalgary.oop;
/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/


public class CareProfile {

    private String[] medList;

    private String medInstructions;

    private String feedingInstructions;


    public CareProfile(String[] medList, String meds, String feeding) {
        this.medInstructions = meds;
        this.feedingInstructions = feeding;
        this.medList = medList;
    }

    public String summarizeCareInstructions() {
    
        StringBuilder careInstr = new StringBuilder();
        for (int i = 0; i < medList.length; i++){
            careInstr.append(medList[i]);
            if (i < medList.length - 1) {
                careInstr.append(", ");
            }
        }
        careInstr.append("\n" + medInstructions);
        careInstr.append("\n" + feedingInstructions);
        return careInstr.toString();
    }
}
