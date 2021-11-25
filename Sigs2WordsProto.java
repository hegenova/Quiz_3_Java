//package predictive;

import java.util.*;
import java.io.*;
//The command line program Sigs2WordsProto will make use of the signatureToWords method from PredictivePrototype.
//The String[] args array will store all input.
//If the array is empty, it will use a scanner to read the user input at runtime and add it to the recently made list.
//If the array is not empty / has an input, it will create a new list with that new input in it.
//If the new list is not empty, it will use the signatureToWords method and print out the result.
public class Sigs2WordsProto {

	public static void main(String[]args) throws FileNotFoundException {
	ArrayList<String> list;
		
		if (args.length == 0) {
			list = new ArrayList<String>();		
			Scanner scan = new Scanner(System.in);
			while (scan.hasNext()) {
				list.add(scan.next());
			}
			scan.close();
		} 
		else {
			list = new ArrayList<String>(Arrays.asList(args));
		}
		
		
		if (list.isEmpty() == false) {
			 for (String s: list) {
				Set<String> words = PredictivePrototype.signatureToWords(s);
				System.out.println(s + " : " + words);
			 	}
			}
		}
	
}
