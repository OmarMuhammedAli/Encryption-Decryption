package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mode = input.nextLine();
        String str = input.nextLine();
        int key = input.nextInt();
        EncryptDecrypt entry = new EncryptDecrypt(new StringBuilder(str));
        System.out.println(entry.unicodeShiftEncDec(mode, key));
    }
}
