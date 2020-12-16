import Console.Console;
import Console.LoadFile;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        boolean exit = false;

        Console console = new Console();
        console.start();

        BufferedReader myFile = null;

        boolean hasFileExist = false;

        while (!(hasFileExist)) {
            String inputText = new Scanner(System.in).nextLine();
            if (inputText.equals("exit")) {
                exit = true;
                break;
            } else {
                try {
                    inputText = "DAT_MT_EURUSD_M1_202011.csv";
                    File file = new File(inputText);
                    InputStream inputStream = new FileInputStream(file);
                    myFile = new BufferedReader(new InputStreamReader(inputStream));
                    hasFileExist = true;
                    System.out.println("File found.");
                } catch (FileNotFoundException e) {
                    System.out.println("Try again. This file not exist.");
                }
            }
        }


//        myFile = new BufferedReader(new FileReader(inputText));


        String line;
        try {
            while ((line = myFile.readLine()) != null) {
                String[] lineOfData = line.split("\n");
                System.out.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Date date = new Date();
        date.



    }


//        if (exit == false) {
//            System.out.println("What do you want to do with file?");
//
//            while (exit == false) {
//                String inputText = new Scanner(System.in).nextLine();
//
//                if (inputText.equals("exit")) {
//                    exit = true;
//                    break;
//                } else {
//
//
//
//
//
//
//                }
//            }
//
//
//
//        }


}

