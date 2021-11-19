public class PredictivePrototype{
    public static String wordToSignature(String word){
        StringBuffer strb= new StringBuffer();
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
       return res;
   }
       public static void main(String[] args){
   
       System.out.println(wordToSignature("home"));
       
   }
   }
   