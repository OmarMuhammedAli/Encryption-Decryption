package encryptdecrypt;

public class Shift implements BaseAlgorithm{
    public StringBuilder encrypt (StringBuilder entry, int key) {
        for (int i = 0; i < entry.length(); i++) {
            if (Character.isLowerCase(entry.charAt(i))) {
                entry.setCharAt(i, (char)(((int)entry.charAt(i) + key - 97) % 26 + 97));
            } else if (Character.isUpperCase(entry.charAt(i))) {
                entry.setCharAt(i, (char)(((int)entry.charAt(i) + key - 65) % 26 + 65));
            }
        }
        return entry;
    }
    public StringBuilder decrypt (StringBuilder entry, int key) {
        key = 26 - key;
        return encrypt(entry, key);
    }
}
