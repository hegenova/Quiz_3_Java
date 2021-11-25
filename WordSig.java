import java.math.BigInteger;

public class WordSig implements Comparable<WordSig>{
     String words;
     String signature;
     public WordSig(){
     }
     public WordSig(WordSig k){
         this.words=k.words;
         this.signature=k.signature;
     }
    @Override
    public int compareTo(WordSig o) {
        // TODO Auto-generated method stub
            String a=this.signature.trim().replaceAll("\\s",""); //using regex to remove whitespace
            String b=o.signature.trim().replaceAll("\\s", "");
            BigInteger b1=new BigInteger(a); //for very long word
            BigInteger b2=new BigInteger(b);
        return b1.compareTo(b2);
    }
}
