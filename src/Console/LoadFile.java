package Console;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadFile {

    private BufferedReader myFile = null;

    public void loadFile() {

        Console console = new Console();

        boolean hasFileExist = false;

        while (!(hasFileExist)) {
            String inputText = new Scanner(System.in).nextLine();
            if (inputText.equals("exit")) {
                System.exit(0);
            } else {
                try {
                    FileReader fileReader = new FileReader(inputText);
                    BufferedReader myfile = new BufferedReader(fileReader);
                    hasFileExist = true;
                    System.out.println("File found.");
                } catch (FileNotFoundException e) {
                    System.out.println("Try again. This file not exist.");
                }
            }
        }
    }

    public ArrayList<String> fileToList (BufferedReader myFile) {

        ArrayList<String> listFromFile = new ArrayList<>();

//        while (myFile.re)
//        myFile.readLine()
        return listFromFile;
    }

    public BufferedReader getMyFile() {
        return myFile;
    }
}
