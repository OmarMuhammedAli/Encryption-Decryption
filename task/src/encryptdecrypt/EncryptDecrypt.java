package encryptdecrypt;

public class EncryptDecrypt {
    final String LETTERS ="abcdefghijklmnopqrstuvwxyz";
    final String REVERSED_LETTERS = "zyxwvutsrqponmlkjihgfedcba";
    private StringBuilder entry = new StringBuilder();

    public EncryptDecrypt(){}
    public EncryptDecrypt(StringBuilder entry){
        this.entry = entry;
    }
    public void setEntry(StringBuilder entry) {
        this.entry = entry;
    }

    // Replaces each letter with the letter that is in the corresponding position from the end of
    // the English alphabet
    public StringBuilder reversedLettersEncryption() {
        for (int i = 0; i < entry.length(); i++) {
            if (Character.isLetter(entry.charAt(i))) {
                entry.setCharAt(i, REVERSED_LETTERS.charAt(LETTERS.indexOf(entry.charAt(i))));
            }
        }
        return this.entry;
    }

    //Encrypts the entry by shifting all the its characters by a given key
    public StringBuilder shiftEncryption(int key){
        int dupKey = key;
        for (int i = 0; i < entry.length(); i++){
            if (Character.isLetter(entry.charAt(i))) {
                while ((LETTERS.indexOf(entry.charAt(i)) + dupKey) > 25) {
                    dupKey -= 26;
                }
                entry.setCharAt(i, LETTERS.charAt(LETTERS.indexOf(entry.charAt(i)) + dupKey));
                dupKey = key;
            }
        }
        return entry;
    }
}
