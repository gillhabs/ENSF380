/**
@author 
    Halanna Le
    Grace Jang
    Christy Guirguis
    Gillian Habermehl
@version 5.0
@since 1.0
*/

/*
The SchedulePrint class is responsible for printing the daily schedule for treatments of animals to a file named "schedule.txt".
It uses the AssignTime class to generate the schedule.
*/
package edu.ucalgary.oop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;

public class SchedulePrint {
    private AssignTime assignTime;

    /**
     * Constructor for the SchedulePrint class.
     * @param animals an array of Animal objects to schedule treatments for.
     * @param treatments an array of Treatment objects to be scheduled for the animals.
     * @throws IllegalSchedule if the given arrays of animals and treatments cannot be scheduled together.
     */
    public SchedulePrint(Animal[] animals, Treatment[] treatments) throws IllegalSchedule {
        AssignTime assignTime = new AssignTime(animals, treatments);
        
        this.assignTime = assignTime;
    }

    /**
     * Prints the daily schedule for the centre to a file named "schedule.txt".
     */
    public void printSchedule() {
        LocalDate currentDate = LocalDate.now();
        String dateText = currentDate.toString();


        int startTime = 0;
        try{
            FileWriter writer = new FileWriter("schedule.txt", true);
            writer.write("Schedule for " + dateText + "\n");
            writer.close();

        }


        catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 24; i++) { 
            ArrayList<String> tasksInHour = assignTime.getSchedule().get(i);
            int[] hour = assignTime.getAvailableTime();
            int indexhour = hour[i];
            if (indexhour == 120){
                startTime = i;
            }
            try {
                FileWriter writer = new FileWriter("schedule.txt", true);
                if(indexhour == 120){
                    writer.write(startTime+":00" + " [+ backup volunteer]" +"\n");
                }
                else {
                    if(tasksInHour.size() !=0 ){
                        writer.write(i+":00" +"\n");
                    }
                }
                
                for (String task : tasksInHour) {
                    
                    writer.write("* " + task + "\n");
                }
                writer.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        System.out.println("Schedule written to schedule.txt");
    }

    /**
     * Gets the AssignTime object used to generate the schedule.
     * @return the AssignTime object.
     */
    public AssignTime getAssignTime() {
        return this.assignTime;
    }
}
