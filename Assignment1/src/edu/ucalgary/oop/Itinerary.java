package edu.ucalgary.oop;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/

/*
Gillian Habermehl
30145994
 */

import java.util.Arrays;

public class Itinerary {
    private Trip[] trips = new Trip[20];

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        return(value + " (" + key + ")");
    }

    // Constructor
    public Itinerary(String[][] myTrips) {
        for(int i = 0; i < myTrips.length; i++){
            trips[i] = new Trip(myTrips[i]);
        }
    }

    // Getter
    public Trip[] getTrips() {
        return trips;
    }

    public String formatByArrival() {
        String year;
        String yearFormatting;
        String month;
        String monthFormatting;
        String place;

        String formatting = "";

        int count = 0;
        int index = 0;
        while(trips[index] != null){
            count++;
            index++;
        }

        int[][] twoDimensionalArray = new int[count][2];

        for(int i = 0; i < count; i++){
            String arrive = trips[i].getArrival();

            int monthArray = Trip.getMonth(arrive) - 1;
            int yearArray = Trip.getYear(arrive) - 2021;

            twoDimensionalArray[i][0] = yearArray;
            twoDimensionalArray[i][1] = monthArray;
        }

        for(int j = 0; j < 3; j++){
            int yearCount = 0;
            for(int k = 0; k < 12; k++){
                int monthCount = 0;
                for(int l = 0; l < count; l++){
                    if(twoDimensionalArray[l][0] == j && twoDimensionalArray[l][1] == k){
                        if(yearCount == 0){
                            year = String.valueOf(twoDimensionalArray[l][0] + 2021);
                            yearFormatting = year + " (Year)\n";
                            formatting = formatting.concat(yearFormatting);
                            yearCount++;
                        }
                        if(monthCount == 0){
                            month = String.valueOf(twoDimensionalArray[l][1] + 1);
                            monthFormatting = "--" + month + " (Month)\n";
                            formatting = formatting.concat(monthFormatting);
                            monthCount++;
                        }

                        place = "----" + trips[l].getCity() + " (City), "
                                + trips[l].getCountry() + " (Country)\n";
                        formatting = formatting.concat(place);
                    }
                }
            }
        }
        return formatting;
    }

    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate() {
        int maxNumberElements = 0;
        int year;
        int month;

        for (Trip trip : trips){
            if(trip != null) {
                String tempYear = trip.getArrival();
                year = Trip.getYear(tempYear) - 2021;
                String tempMonth = trip.getArrival();
                month = Trip.getMonth(tempMonth) - 1;
                int index = (year * 12) + month;

                maxNumberElements = Math.max(maxNumberElements, index + 1);
            }
        }
        String[][][] formattedString = new String[3][12][maxNumberElements];
        for(int i = 0; i < trips.length; i++){
            if(trips[i] != null){
                String tempYear = trips[i].getArrival();
                year = Trip.getYear(tempYear) - 2021;
                String tempMonth = trips[i].getArrival();
                month = Trip.getMonth(tempMonth) - 1;
                for(int j = 0; j < 20; j++) {
                    if(formattedString[year][month][j] == null){
                        formattedString[year][month][j] = Itinerary.fmtString("City", trips[i].getCity())
                                + " "
                                + Itinerary.fmtString("Country", trips[i].getCountry());
                        break;
                    }
                }
            }
        }
        return formattedString;
    }
}