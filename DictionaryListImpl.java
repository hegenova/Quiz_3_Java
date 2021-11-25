import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;  
public class DictionaryListImpl {
    static ArrayList<WordSig> dict=new ArrayList<>();


    public DictionaryListImpl() throws FileNotFoundException{
        readfile(); //read dictionary and store in inside arraylist in the memory
    }


     static void readfile() throws FileNotFoundException{
        FileInputStream input = new FileInputStream("./words");
        Scanner scan = new Scanner(input);
        while(scan.hasNextLine()){
         WordSig first=new WordSig();
         String a=scan.nextLine();
         a=a.toLowerCase();
         if(!a.matches((".*[a-z].*"))) continue; //using regex to check whether alphabet exist in the string
            if(!a.trim().isEmpty()||wordToSignature(a).trim()!=""){
            first.words=a;
            first.signature=wordToSignature(a);
            dict.add(first);
            }
    }
    dict.removeAll(Collections.singleton(null));
    Collections.sort(dict);
    scan.close();
    }


    public static Set<String> signatureToWords(String sig) throws FileNotFoundException{
        ArrayList<WordSig> search=new ArrayList<WordSig>(dict);
        Set<String> res=new HashSet<String>();
        WordSig dlist=new WordSig();
        dlist.signature=sig;
        int flag=1;
        while(flag==1){
        int index=Collections.binarySearch(search, dlist);
        if(index<0){ //when it doesnt found anything anymore, return the set
            return res;
        }
        WordSig l=new WordSig(search.get(index));
        String k=l.words;
        k=k.replaceAll("[^a-zA-Z0-9]", "");
        res.add(k);
        search.remove(index);}
         
        return res;
    }


    public static String wordToSignature(String word){
        StringBuffer strb= new StringBuffer();
        //using stringbuffer in here is more efficient because
        //string buffer speciality which give flexibility to string manipulation
        //as the class itself with many method it provides
        word=word.toLowerCase();
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
       String res=strb.toString();
       return res;}
       
}
