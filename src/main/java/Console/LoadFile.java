package Console;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;



public class LoadFile {

    public BufferedReader loadFile() {
        BufferedReader myFile = null;
        boolean hasFileExist = false;

        while (!(hasFileExist)) {
            String inputText = new Scanner(System.in).nextLine();
            if (inputText.equals("exit")) {
                System.exit(0);
                break;
            } else {
                try {
                    inputText = "DAT_MT_EURUSD_M1_202011.csv"; //TODO aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                    myFile = new BufferedReader(new FileReader(inputText));
                    hasFileExist = true;
                    System.out.println("File found.");
                } catch (FileNotFoundException e) {
                    System.out.println("Try again. This file not exist.");
                }
            }
        }
        return myFile;
    }
}
