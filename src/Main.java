import Console.Console;
import WorkWithFile.MyDate;
import WorkWithFile.DataForOneMinute;
import WorkWithFile.MyTime;
import WorkWithFile.MyValue;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Console console = new Console();
        console.start();

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

        ArrayList<DataForOneMinute> listOfData = new ArrayList();
        String line;
        try {
            boolean firstLineToSkip = true;
            while ((line = myFile.readLine()) != null) {
                if (firstLineToSkip) {
                    firstLineToSkip = false;
                } else {
                    String[] listSeparatedData = line.split(",");
                    String[] date = listSeparatedData[0].split("\\.");
                    String[] time = listSeparatedData[1].split(":");

                    listOfData.add(new DataForOneMinute(     //YYYY.MM.DD,HH:MM,OPEN,HIGH,LOW,CLOSE,VOLUME
                            new MyDate(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])),
                            new MyTime(Integer.parseInt(time[0]), Integer.parseInt(time[1])),
                            new MyValue(listSeparatedData[2], listSeparatedData[3], listSeparatedData[4], listSeparatedData[5])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        Integer year = null;
        Integer month = null;
        Integer day = null;
        String typeData = null;

        listOfData.stream()
                .filter(x -> x.getDate().getYear() == year)
                .filter(x -> x.getDate().getMonth() == month)
                .filter(x -> x.getDate().getDay() == day)
                .filter(x -> x.getDate().getYear() == typeData)






    }
}

