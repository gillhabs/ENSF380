/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

public class Parking {

    /*
     * Standardize provided licence plate to a common format
     * @param licence - The provided licence plate
     * @throws IllegalArgumentException if licence doesn't fit Alberta standards
     */
    public static String standardizeAndValidateLicence(String licence) 
    		throws IllegalArgumentException {

         licence = licence.toUpperCase();
         licence = licence.replaceAll("[^\\w]", "");

         if (licence.length() <= 7 && licence.length() >= 1) {
             return licence;
         }

         String error = String.format("Licence plate '%s' is not a valid licence plate in Alberta.", licence);
         throw new IllegalArgumentException(error);
    }
}
