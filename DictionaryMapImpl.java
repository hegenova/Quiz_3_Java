import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class DictionaryMapImpl implements Dictionary{
    Map<String, ArrayList<String>> first=new HashMap<String, ArrayList<String>>();
    
    public DictionaryMapImpl(){
        readfile();
    }


    public void readfile(){
        FileInputStream input;
        try {
            input = new FileInputStream("./words");
            Scanner scan = new Scanner(input); 
            while(scan.hasNextLine()){
                String a=scan.nextLine();
                a=a.toLowerCase();
                if(!a.matches((".*[a-z].*"))) continue; //using regex to check whether alphabet exist in the string
                if(!a.trim().isEmpty()||wordToSignature(a).trim()!=""){
                    String sig=wordToSignature(a);
                    addToList(sig, a); //use the helper to insert the value into the map
                }
                   }
                   scan.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addToList(String mapKey, String words){
        ArrayList<String> adding = first.get(mapKey);
        words=words.replaceAll("[^a-zA-Z0-9]", "");
        //if list does not exist, create list
        if(adding==null){
            adding = new ArrayList<String>();
            adding.add(words);
            first.put(mapKey,adding);
        }
        else{
            //add if word is not already in the list
            if(!adding.contains(words))
                adding.add(words);
        }
    }
    @Override
    public String wordToSignature(String word) {
        // TODO Auto-generated method stub
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
       res=res.trim().replaceAll("\\s", ""); //using regex to remove whitespace
       return res;
    }


    @Override
    public Set<String> signatureToWords(String sig) {
        // TODO Auto-generated method stub
        //pass the result from "first" arraylist to finder and then change it 
        //to set 
        ArrayList<String> finder= new ArrayList<String>();
        finder=first.get(sig);
        Set<String> res=new HashSet<String>(finder);
        return res;
    }
    

}
