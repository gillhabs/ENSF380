package edu.ucalgary.oop;

/* TranslationText
 * Serializable representation of the data file. Has the serialVersionUID of 19L.
 * Member data names should be based on those implied by the getters. Member data are not final.
*/

  /* getSentence()
   * Getter method, returns String
  */

  /* getMonths()
   * Getter method, returns String[]
  */

  /* getDays()
   * Getter method, returns String[]
  */

  /* getMonth()
   * Accepts an integer 0-11 corresponding to an index in the months array,
   * and returns the value at that index. (e.g., 0 = January)
  */

  /* getDay()
   * Accepts an integer 0-30 corresponding to an index in the day array,
   * and returns the value at that index. (e.g., 30 = 31st)
  */

  /* Constructor
   * Accepts a String array of months, a String array of days, and a String 
   * containing a sentence with formatting.
  */

import java.io.Serializable;
import java.util.Arrays;

public class TranslationText implements Serializable {
	private static final long serialVersionUID = 19L;
    private String sentence;
    private String[] months;
    private String[] days;

      
    public TranslationText(String[] months, String[] days, String sentence) {
        this.months = Arrays.copyOf(months, months.length);
        this.days = Arrays.copyOf(days, days.length);
        this.sentence = sentence;
    }
  
      
    public String getSentence() {
        return sentence;
    }
  
      
    public String[] getMonths() {
        return months;
    }
  
     
    public String[] getDays() {
        return days;
    }
  
      
    public String getMonth(int index) {
        return months[index];
    }
  
      
    public String getDay(int index) {
        return days[index];
    }
  }
  