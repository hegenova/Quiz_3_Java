package predictive;

import java.util.*;

public class Words2SigProto {
	
	public static void main(String[]args) {
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
			
			
		if (list.isEmpty()==false) {
			for (String s: list) {
				System.out.println(PredictivePrototype.wordToSignature(s));
				}
			}
		}
		
}
