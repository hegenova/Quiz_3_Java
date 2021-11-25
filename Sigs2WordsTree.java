//package predictive;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Sigs2WordsTree {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list;
        new DictionaryTreeImpl();
		
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
				Set<String> words = DictionaryTreeImpl.signatureToWords(s);
				System.out.println(s + " : " + words);
			 	}
			}
    }
    
}
