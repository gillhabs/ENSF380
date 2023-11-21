package edu.ucalgary.oop;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.regex.*;
import java.util.*;

public class ScheduleTest {
    MedicalTask task1 = new MedicalTask(9, "Eyedrops", 25, 1);
    MedicalTask task2 = new MedicalTask(10, "Inspect broken leg", 5, 2);

    Animal animal1 = new Animal(1, "Loner", "coyote");
    Animal animal2 = new Animal(2, "Biter", "coyote");
    //test IllegalArgumentException

    Treatment treatment1 = new Treatment(animal1, task1, 22);
    Treatment treatment2 = new Treatment(animal1, task2, 10);

    Animal[] animals = {animal1, animal2};
    Treatment[] treatments = {treatment1, treatment2};
    MedicalTask[] tasks = {task1, task2};



    /*
    * Getters for the Animal class
    */

    @Test 
    public void testGetIDAnimal() {
        /*
         * Tests the return of getID() in animal class.
         */

        int expectedAnimalID1 = 1;
        int actualAnimalID = animal1.getID();

        assertEquals("Constructor or getter gave wrong value for animal id", 
        expectedAnimalID1, actualAnimalID);
    }

    @Test
    public void testGetName(){
        /*
         * Tests the return of getName().
         */

        String expectedAnimalName1 = "Loner";
        String actualAnimalName = animal1.getName();

        assertEquals("Constructor or getter gave wrong value for animal name", 
        expectedAnimalName1, actualAnimalName);
    }

    @Test 
    public void testGetSpecies() {
        /*
         * Tests the return of getSpecies().
         */

        String expectedAnimalSpecies1 = "Coyote";
        String actualAnimalSpecies = animal1.getSpecies();
  
        assertEquals("Constructor or getter gave wrong value for animal type", 
        expectedAnimalSpecies1, actualAnimalSpecies);
    }

    /*
    * Getters for the MedicalTask class
    */

    @Test 
    public void testGetDuration() {
        /*
         * Tests the return of getDuration().
        */

        int expectedDuration1 = 25;
        int actualDuration = task1.getDuration();

        assertEquals("Constructor or getter gave wrong value for duration", 
        expectedDuration1, actualDuration);
    }

    @Test
    public void testGetIDMedical() {
        /*
        * Tests the return of getID() in MedicalTask class.
        */

        int expectedTaskID1 = 9;
        int actualTaskID = task1.getID();

        assertEquals("Constructor or getter gave wrong value for task id", 
        expectedTaskID1, actualTaskID);
    }

    @Test
    public void testGetDescription() {
        /*
        * Tests the return of getDescription().
        */

        String expectedDescription1 = "Eyedrops";
        String actualDescription = task1.getDescription();

        assertEquals("Constructor or getter gave wrong value for description", 
        expectedDescription1, actualDescription);
    }

    @Test 
    public void testGetMaxWindow() {
        /*
        * Tests the return of getMaxWindow().
        */

        int expectedMaxWindow1 = 1;
        int actualMaxWindow = task1.getMaxWindow();

        assertEquals("Constructor or getter gave wrong value for maximum window", 
        expectedMaxWindow1, actualMaxWindow);
    }

    /*
    * Getters for the Treatment class
    */

    @Test
    public void testGetStartHour() {
        /*
        * Tests the return of getStartHour().
        */

        int expectedStartHour1 = 22;
        int actualStartHour = treatment1.getStartHour();

        assertEquals("Constructor or getter gave wrong value for starting hour", 
        expectedStartHour1, actualStartHour);
    }

    @Test 
    public void testGetMedical() {
        /*
        * Tests the return of getMedical().
        */

        MedicalTask expectedTask = task1;
        MedicalTask actualTask = treatment1.getMedical();

        assertEquals("Constructor or getter gave wrong value for medical task", 
        expectedTask, actualTask);
    }

    @Test 
    public void testGetAnimal() {
        /*
        * Tests the return of getAnimal().
        */

        Animal expectedAnimal = animal1;
        Animal actualAnimal = treatment1.getAnimal();

        assertEquals("Constructor or getter gave wrong value for animal", 
        expectedAnimal, actualAnimal);
    }

    /*
    * Getters for the AssignTime class
    */

    @Test
    public void testGetAvailableTime() {
        /*
        * Tests the return of getAvailableTime().
        */

//        try{
//            AssignTime assignTime = new AssignTime(animals, treatments);
//            int[] expectedAvailalableTime = ;
//            int[] actualAvailableTime = assignTime.getAvailableTime();
//
//            assertEquals("Constructor or getter gave wrong value for available time", 
//            expectedAvailableTime, actualAvailableTime);
//        }
//
//        catch(IllegalSchedule e) {}
    }

    @Test
    public void testGetSchedule() {
        /*
        * Tests the return of getSchedule().
        */

        try{
            AssignTime assignTime = new AssignTime(animals, treatments);
            HashMap<Integer, ArrayList<String>> expectedSchedule = new HashMap<Integer, ArrayList<String>>();

            ArrayList<String> cleanCages = new ArrayList<String>();
            cleanCages.add("Clean cage(coyote)");

            ArrayList<String> inspectLeg = new ArrayList<String>();
            inspectLeg.add("Inspect broken leg(Loner)");

            ArrayList<String> feed = new ArrayList<String>();
            feed.add("Feed coyote");

            ArrayList<String> eyedrops = new ArrayList<String>();
            eyedrops.add("Eyedrops(Loner)");

            expectedSchedule.put(0, cleanCages);
            expectedSchedule.put(10, inspectLeg);
            expectedSchedule.put(19, feed);
            expectedSchedule.put(22, eyedrops);

            HashMap<Integer, ArrayList<String>>  actualSchedule = assignTime.getSchedule();
    
            assertEquals("Constructor or getter gave wrong value for schedule", 
            expectedSchedule, actualSchedule);
        }

        catch(IllegalSchedule e) {}
    }

    @Test 
    public void testGetTreatmentFromDescription() {
        /*
        * Tests the return of getTreatmentFromDescription().
        */

        try {
            AssignTime assignTime = new AssignTime(animals, treatments);
            Treatment expectedTreatment = treatment1;
            Treatment actualTreatment = assignTime.getTreatmentFromDescription(treatments, "Eyedrops");
        
            assertEquals("Constructor or getter gave wrong value for animal", 
            expectedTreatment, actualTreatment);
        } 

        catch (IllegalSchedule e) {}
    }

    /*
    * Getters for the SchedulePrint class
    */

    @Test 
    public void testGetAssignTime() {
        /*
        * Tests the return of getAssignTime().
        */

        try{ 
            SchedulePrint schedulePrint = new SchedulePrint(animals, treatments);
            AssignTime expectedAssignTime = new AssignTime(animals, treatments);
            AssignTime actualAssignTime = schedulePrint.getAssignTime();

            assertEquals("Constructor or getter gave wrong value for animal", 
            expectedAssignTime, actualAssignTime);
        }

        catch(IllegalSchedule e) {}
    }

    /*
    * Methods for the AssignTime class
    */

    @Test 
    public void testFindLowestMaxWindowIndex() {
        /*
        * Tests the return of findLowestMaxIndex().
        * Test with multiple treatments and multiple max windows
        */
        //findLowestMaxWindowIndex: int
    }

    @Test
    public void testRemoveTreatment() {
        /*
        * Tests the return of removeTreatment().
        * Test with multiple treatments
        */
        //removeTreatment: Treatment[]
    }

    @Test
    public void testCalculateDuration() {
        /*
        * Tests the return of calculateDuration().
        * Test with multiple treatments, tasks and different
        * variations of species
        */
        //calculateDuration: int
    }

    /*
    * Methods for the SchedulePrint class
    */

    @Test 
    public void testPrintSchedule() {
         /*
        * Tests the return of printSchedule().
        * Tests with both a valid and invalid schedule to see if an IllegalSchedule is thrown.
        * Also test when a backup volunteer is both need and not needed (60 and 61 minutes of tasks).
        */
        //printSchedule: void
    }

    /*
    * Methods for the Animal class
    */

    @Test 
    public void testCheckAnimalSpecies() {
        /*
        * Tests the return of checkAnimalSpecies().
        * Tests with both a valid and invalid input of
        * the ennumeration.
        */
        //checkAnimalSpecies: boolean
    }

    /*
    * Methods for the AnimalSpecies class
    */
 
    @Test
    public void testCage() {
        /*
        * Tests the return of prep().
        * Tests with different number of cages for cleaning, 
        * and with the instance of orphans.
        */
        //cage: int
    }

    @Test
    public void testFeed() {
        /*
        * Tests the return of feed().
        * Tests with multiple animals.
        */
        //feed: int
    }

    @Test
    public void testPrep() {
        /*
        * Tests the return of prep().
        * Tests with multiple animals.
        */
        //prep: int
    }

    @Test
    public void testFeedWindow() {
        /*
        * Tests the return of feedWindow().
        * Tests with multiple animals, and multiple feed windows.
        */
        //feedWindow: int[]
    }
}
