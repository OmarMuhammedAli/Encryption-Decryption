package encryptdecrypt;

public class Reverse implements BaseAlgorithm {
    private final static String LETTERS ="abcdefghijklmnopqrstuvwxyz";
    private final static String REVERSED_LETTERS = "zyxwvutsrqponmlkjihgfedcba";
    private final static String UPPER_CASE = LETTERS.toUpperCase();
    private final static String REVERSED_UPPER_CASE = REVERSED_LETTERS.toUpperCase();
    @Override
    public StringBuilder encrypt(StringBuilder entry, int key) {
        for (int i = 0; i < entry.length(); i++) {
            if (Character.isLetter(entry.charAt(i))) {
                if (Character.isLowerCase(entry.charAt(i))){
                    entry.setCharAt(i, REVERSED_LETTERS.charAt(LETTERS.indexOf(entry.charAt(i))));
                } else {
                    entry.setCharAt(i, REVERSED_UPPER_CASE.charAt(UPPER_CASE.indexOf(entry.charAt(i))));
                }
            }
        }
        return entry;
    }

    @Override
    public StringBuilder decrypt(StringBuilder entry, int key) {
        return encrypt(entry, key);
    }
}
