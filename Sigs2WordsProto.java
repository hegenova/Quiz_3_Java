//package predictive;

import java.util.*;
import java.io.*;

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
