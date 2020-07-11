package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EncryptDecrypt entry = new EncryptDecrypt(new StringBuilder("welcome to hyperskill"));
        System.out.println(entry.shiftEncryption(5));
    }
}
