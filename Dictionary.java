import java.util.Set;

interface Dictionary {
    public String wordToSignature(String words);
    public Set<String> signatureToWords(String sig);
    public void readfile();
}
