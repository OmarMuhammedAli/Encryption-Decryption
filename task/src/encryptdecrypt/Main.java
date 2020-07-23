package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Selector().commandEncDec(args);
    }
}
class Selector {
    private BaseAlgorithm strategy;
    private String[] args;
    private StringBuilder entry = new StringBuilder();
    private String mode = "enc";
    private int key = 0;
    private String alg = "shift";

    public Selector(){}
    public void commandEncDec(String[] args) {
        int writeFileIndex = 0; //keeps the index of the file name (if exists) to write to later
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
                case "-in":
                    if (Arrays.asList(args).contains("-data")) {
                        continue;
                    } else {
                        this.entry = fileReader(args[i + 1]);
                    }
                    break;
                case "-out":
                    writeFileIndex = i + 1;
                    break;
                case "-alg":
                    this.alg = args[i + 1];
                    break;
                default:
                    break;
            }
        }

        switch (this.alg) {
            case "shift":
                strategy = new Shift();
                if (this.mode.equals("enc")) {
                    this.entry = strategy.encrypt(this.entry, this.key);
                } else if (this.mode.equals("dec")) {
                    this.entry = strategy.decrypt(this.entry, this.key);
                }
                break;
            case "unicode":
                strategy = new Unicode();
                if (this.mode.equals("enc")) {
                    this.entry = strategy.encrypt(this.entry, this.key);
                } else if (this.mode.equals("dec")) {
                    this.entry = strategy.decrypt(this.entry, this.key);
                }
                break;
            case "reverse":
                strategy = new Reverse();
                if (this.mode.equals("enc")) {
                    this.entry = strategy.encrypt(this.entry, this.key);
                } else if (this.mode.equals("dec")) {
                    this.entry = strategy.decrypt(this.entry, this.key);
                }
                break;
            default:
                break;
        }


        //this.entry = unicodeShiftEncDec(this.mode, this.key);
        if (Arrays.asList(args).contains("-out")) {
            String fileName = args[writeFileIndex];
            fileWriter(this.entry, fileName);
        } else {
            System.out.println(this.entry);
        }
    }
    //Reads the file specified by name after the parameter -in in the given command
    //Returns the read data
    private StringBuilder fileReader(String fileName) {
        File file = new File(fileName);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                entry.append(input.nextLine()).append("\r\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return this.entry;
    }
    //Writes the entry data to the file specified by name after the parameter -out in the given command
    private void fileWriter(StringBuilder entry, String fileName) {
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(entry.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
