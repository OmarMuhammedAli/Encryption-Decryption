package encryptdecrypt;

public class EncryptDecrypt {
    final String LETTERS ="abcdefghijklmnopqrstuvwxyz";
    final String REVERSED_LETTERS = "zyxwvutsrqponmlkjihgfedcba";
    final String UPPER_CASE = LETTERS.toUpperCase();
    final String REVERSED_UPPER_CASE = REVERSED_LETTERS.toUpperCase();
    private StringBuilder entry = new StringBuilder();
    private String mode = "enc";
    private int key = 0;

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
                if (Character.isLowerCase(entry.charAt(i))){
                    entry.setCharAt(i, REVERSED_LETTERS.charAt(LETTERS.indexOf(entry.charAt(i))));
                } else {
                    entry.setCharAt(i, REVERSED_UPPER_CASE.charAt(UPPER_CASE.indexOf(entry.charAt(i))));
                }
            }
        }
        return this.entry;
    }

    //Encrypts the entry by shifting all the its characters by a given key. The shifts happens for letters only
    //Any letter can only be shifted to a letter, e.g. the letter 'z' with a key = 1 shifts to 'a'
    public StringBuilder lettersOnlyShiftEncryption(int key){
        int dupKey = key;
        for (int i = 0; i < entry.length(); i++){
            if (Character.isLetter(entry.charAt(i))) {
                if (Character.isLowerCase(entry.charAt(i))) {
                    while ((LETTERS.indexOf(entry.charAt(i)) + dupKey) > 25) {
                        dupKey -= 26;
                    }
                    entry.setCharAt(i, LETTERS.charAt(LETTERS.indexOf(entry.charAt(i)) + dupKey));
                } else {
                    while ((UPPER_CASE.indexOf(entry.charAt(i)) + dupKey) > 25) {
                        dupKey -= 26;
                    }
                    entry.setCharAt(i, UPPER_CASE.charAt(UPPER_CASE.indexOf(entry.charAt(i)) + dupKey));
                }
                dupKey = key;
            }
        }
        return entry;
    }

    // Shift encrypts or decrypts all characters including spaces and special characters with a certain key according
    // to the unicode table. To encrypt, enter the mode "enc". To decrypt, enter the mode "dec"
    public StringBuilder unicodeShiftEncDec(String mode, int key){
        if (mode.equals("enc")) {
            shiftEncryption(key);
        } else if (mode.equals("dec")) {
            shiftDecryption(key);
        }
        else {
            return new StringBuilder("Invalid mode!");
        }
        return entry;
    }
    private void shiftEncryption(int key){
        for (int i =0; i < entry.length(); i++) {
            entry.setCharAt(i, (char)(entry.charAt(i) + key));
        }
    }
    private void shiftDecryption(int key){
        for (int i =0; i < entry.length(); i++) {
            entry.setCharAt(i, (char)(entry.charAt(i) - key));
        }
    }
    //If the input is taken as a command from the console, invoke the following function
    public StringBuilder commandEncDec(String[] args) {
        for (int i = 0; i < args.length; i += 2){
            String parameter = args[i];
            switch (parameter){
                case "-mode":
                    this.mode = args[i + 1];
                    break;
                case "-key":
                    this.key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    this.entry = new StringBuilder(args[i + 1]);
                default:
                    break;

            }
        }
        this.entry = unicodeShiftEncDec(this.mode, this.key);
        return this.entry;
    }
}
