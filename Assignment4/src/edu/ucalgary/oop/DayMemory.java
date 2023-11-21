package edu.ucalgary.oop;
import java.io.IOException;
import java.lang.String;
  
/* main()
   * Accept a command-line argument which specifies a translation file.
   * The argument should be in the form of a two-letter language code,
   * followed by a dash and a two-letter region code, e.g., en-US
   * which corresponds with files en-US.txt and en-US.ser
   * If no argument is specified, it throws a custom exception,
   * CommandArgumentNotProvidedException, which extends Exception. 
   * Additional arguments are ignored.
 */

public class DayMemory {
	
	public static void main(String[] args) throws CommandArgumentNotProvidedException, 
	ClassNotFoundException,  ArgFileNotFoundException, IOException {
		
	if (args.length > 0) {
		
		Translator translator = new Translator(args[0]);
    } 
	  
	else {
		
		throw new CommandArgumentNotProvidedException();
    }  
  }	
}
