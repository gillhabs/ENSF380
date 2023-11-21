package edu.ucalgary.oop;
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

  /* getTranslation()
   * getter method returning a stored TranslationText object.
  */

  /* translate()
   * Accepts a month number (e.g., 1 for January), a day number (e.g., 31 for
   * the 31st), and a year. Note that years may be any previous year in the common era 
   * (CE) from 0 to the previous year, or they may be before the common era (BCE),
   * represented by negative numbers. Thus 2021, 800, and -1600 are all valid years.
   * Method throws an IllegalArgumentException if monthNum or dayNum is not
   * valid. Returns the formatted sentence as a String. Notice that the String
   * containing formatting uses numbered arguments - this is because some languages
   * will put the words in the sentence in a different order, but the translate()
   * method must be able to work without knowledge of the language structure.
   * Note: You do not have to check if a day is valid for a particular month/year;
   * February 31 or February 29, 2021 can both be accepted, but out of range values
   * e.g., month 15 day 0, are not valid and should be handled with an 
   * IllegalArgumentException. 
  */

  /* Constructor
   * Accepts a String of a two-letter language code (lowercase), dash, and two-letter 
   * region (caps) code, e.g., te-IN and throws an IllegalArgumentException if the language 
   * and region code are not in the correct format. Language codes are ISO 639-1 and
   * region codes are ISO 3166, but this method only checks the format of the String, 
   * not if the region and language codes are valid according to the ISO specifications.
   * The input parameter must exactly match the expected format.
   * It calls importTranslation().
   * Does not catch ArgFileNotFoundException (exception may optionally be caught
   * by code which invokes this constructor).
  */

  /* importTranslation()
   * Calls deserialize() if the appropriate file exists, otherwise calls importFromText().
   * No arguments. Returns void.
  */

  /* importFromText()
   * Reads in from a the two-letter language code, dash, two-letter region code text 
   * file, in the form of ab-XY.txt, and instantiates a TranslationText object with
   * the data. It can throw I/O exceptions. Throw a custom ArgFileNotFoundException
   * when the file isn't found. 
   * We expect the .txt file to be in a valid format. The file is expected to be in the same 
   * directory. The files en-US.txt and el-GR.txt are examples of a valid .txt files. They will 
   * always consist of the month names, one per line, followed by the day names, one per line, 
   * followed by the sentence containing formatting strings. This is the last line in the file. You
   * cannot make any assumptions about what will appear on each line, only that each line
   * will contain only one data element, and that it will not contain an empty line.
   * No arguments. Returns void.
  */

  /* serialize()
  * Creates a serialized object file of the TranslationText object, with the
  * name format la-CO.ser, where la is the two-letter language code and CO is
  * the two-letter region code. An example of a serialized object file can be
  * found in the exercise directory as es-BO.ser
  * I/O exceptions can be thrown.
  * No arguments. Returns void.
  */

  /* deserialize()
   * Creates a TranslationText object from a .ser file. The files are named
   * xx-YY.ser, where xx is the two-letter language code and YY is the two-
   * letter region code. es-BO.ser is an example. It can throw I/O exceptions.
   * No arguments. Returns void.
  */

public class Translator {

	private String translation;
    private TranslationText translate;

    public TranslationText getTranslation() {
    	
        return this.getTranslation();
    }

    
    public String translate(int monthNumber, int dayNumber, int year) throws IllegalArgumentException{
    	
        if (monthNumber > 12 || monthNumber < 1) {
            throw new IllegalArgumentException("Invalid month number");
        }
        
        if (dayNumber > 31 || dayNumber < 1) {
            throw new IllegalArgumentException("Invalid day number");
        }
        
        int monthTranslate = monthNumber - 1;
        int dayTranslate = dayNumber - 1;
        
        String month = translate.getMonth(monthTranslate);
        String day = translate.getDay(dayTranslate);
        String sentence = translate.getSentence();

        String sentence_day = sentence.replace("%1$s", day);
        String sentence_month = sentence_day.replace("%2$s", month);
        String sentence_year = sentence_month.replace("%3$d", Integer.toString(year));
        return sentence_year;
    }

    
    public Translator(String region) throws IllegalArgumentException, 
    	ArgFileNotFoundException, IOException, ClassNotFoundException {
    	
        if(!region.matches("^[a-z]{2}-[A-Z]{2}$")) {
            throw new IllegalArgumentException("Invalid code format");
        }
        
        this.translation = region;
        
        importTranslation();
    }
    
    
    public void importTranslation() throws ArgFileNotFoundException, 
    	IOException, ClassNotFoundException {
    	
        String fileUsed = translation + ".ser";
        File file = new File(fileUsed);
        
        if (file.exists()) { 
            deserialize();
        } 
        
        else {
            importFromText();
            serialize();
        }
    }
    
    
    public void importFromText() throws ArgFileNotFoundException, FileNotFoundException {
    	
        String fileUsed = translation + ".txt";
        File file = new File(fileUsed);

        try {
            String[] months = new String[12];
            String[] days = new String[31];
            String sentence = "";
            Scanner scanner = new Scanner(file, "UTF-8");
            
            for (int i = 0; i < 12; i++) {
                months[i] = scanner.nextLine();
            }
            
            for (int i = 0; i < 31; i++) {
                days[i] = scanner.nextLine();
            }
            
            while(scanner.hasNextLine()) {
                sentence += scanner.nextLine();
            }
            
            translate = new TranslationText(months, days, sentence);  
        } 
        
        catch (FileNotFoundException e) {
            throw new ArgFileNotFoundException();
        }
    }
    
    
    public void serialize() throws IOException{
    	
        String fileUsed = translation + ".ser";
        
        try {
        	
            FileOutputStream outFile = new FileOutputStream(fileUsed);
            
            ObjectOutputStream output = new ObjectOutputStream(outFile);
            output.writeObject(translate);
            output.close();
            outFile.close();
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void deserialize() throws IOException, ClassNotFoundException{
    	
        String fileUsed = translation + ".ser";
        
        try {
        	
            FileInputStream inFile = new FileInputStream(fileUsed);
            
            ObjectInputStream input = new ObjectInputStream(inFile);
            translate = (TranslationText) input.readObject();
            input.close();
            inFile.close();
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        } 
        
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}