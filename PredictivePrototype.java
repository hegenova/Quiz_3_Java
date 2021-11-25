//package predictive;

import java.util.*;
import java.io.*;

public class PredictivePrototype{
	
//The method reads the string character by character in a for loop 
//and uses the conditional to append each letter until it outputs a numeric signature.	
    public static String wordToSignature(String word){
        StringBuffer strb= new StringBuffer();
        //Here, StringBuffer is used because String is too slow, consumes more memory, and uses the string pool,
        //while Stringbuffer is faster, consumes less memory, and uses the heap memory.
        word = word.toLowerCase();
       int length=word.length();
      for(int i=0; i<length; i++){
          if(word.charAt(i)=='a'||word.charAt(i)=='b'||word.charAt(i)=='c'){
           strb.append("2");
          }
          else if(word.charAt(i)=='d'||word.charAt(i)=='e'||word.charAt(i)=='f'){
           strb.append("3");
          }
          else if(word.charAt(i)=='g'||word.charAt(i)=='h'||word.charAt(i)=='i'){
           strb.append("4");
          }
          else if(word.charAt(i)=='j'||word.charAt(i)=='k'||word.charAt(i)=='l'){
           strb.append("5");
          }
          else if(word.charAt(i)=='m'||word.charAt(i)=='n'||word.charAt(i)=='o'){
           strb.append("6");
          }
          else if(word.charAt(i)=='p'||word.charAt(i)=='q'||word.charAt(i)=='r'||word.charAt(i)=='s'){
           strb.append("7");
          }
          else if(word.charAt(i)=='t'||word.charAt(i)=='u'||word.charAt(i)=='v'){
           strb.append("8");
          }
          else if(word.charAt(i)=='w'||word.charAt(i)=='x'||word.charAt(i)=='y'||word.charAt(i)=='z'){
           strb.append("9");
          }
          else{
           strb.append(" ");
       }
      }
       String res = strb.toString();
       return res;
    }
    
 
    //the method first scans the whole dictionary, 
    //and then uses a while loop to compare the scanned word's numeric signature with the numeric signature input.
    //if the signatures are the same, the word is stored in a set.
    public static Set<String> signatureToWords(String signature) throws FileNotFoundException{
    	
    	Set<String> set = new HashSet<String>();
    	
    	//using the scanner only reads the file.
    	//storing the dictionary will be inefficient, as it will be used repeatedly.
    	FileInputStream input = new FileInputStream("./words");   //change depending on words file location    
    	Scanner scan = new Scanner(input);
        
		while (scan.hasNextLine()) {
			
			String i = scan.nextLine();
			
			//checks whether the word has non-alphanumeric characters or not
			boolean check = isValidWord(i);
			if (check == false) continue;
			
			String sig = PredictivePrototype.wordToSignature(i);
			if (sig.equals(signature)) {
				set.add(i);
			}
		}
		
		scan.close();
		return set;
   }

  //the helper method to check whether the word has non-alphanumeric characters or not
    private static boolean isValidWord(String word) {
    	char[] charArray = word.toCharArray();
        for(char c :charArray){
            if (!Character.isLetter(c)) return false;
        }
        return true;
    	
    }

    //check output
    public static void main(String[] args) throws FileNotFoundException{
    	   
        System.out.println(wordToSignature("home"));
        System.out.println(signatureToWords("4663"));
    }

} 
