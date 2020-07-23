package encryptdecrypt;

public class Unicode implements BaseAlgorithm{
    public StringBuilder encrypt (StringBuilder entry, int key) {
        for (int i =0; i < entry.length(); i++) {
            entry.setCharAt(i, (char)(entry.charAt(i) + key));
        }
        return entry;
    }
    public StringBuilder decrypt (StringBuilder entry, int key) {
        for (int i =0; i < entry.length(); i++) {
            entry.setCharAt(i, (char)(entry.charAt(i) - key));
        }
        return entry;
    }
}
