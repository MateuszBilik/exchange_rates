import Console.Console;
import WorkWithFile.DataForOneMinute;
import WorkWithFile.MyDate;
import WorkWithFile.MyTime;
import WorkWithFile.MyValue;
import Console.MethodsGet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
                            new MyValue(Double.parseDouble(listSeparatedData[2]), Double.parseDouble(listSeparatedData[3]),
                                    Double.parseDouble(listSeparatedData[4]), Double.parseDouble(listSeparatedData[5]))));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        Integer year = 2020;
        Integer month = 11;
        Integer day = 01;
        Integer minute = 27;
        Integer hour = 17;
        String typeData = "open";


        System.out.println(MethodsGet.getTypeForMinute(listOfData, day, month, year, hour, minute, typeData));
        System.out.println(MethodsGet.getForMinute(listOfData, day, month, year, hour, minute));

        System.out.println("Wartość dla dnia:");
        System.out.println(MethodsGet.getTypeForDay(listOfData, day, month, year, "high") + " high");
        System.out.println(MethodsGet.getTypeForDay(listOfData, day, month, year, "low") + " low");
        System.out.println(MethodsGet.getTypeForDay(listOfData, day, month, year, "open") + " open");
        System.out.println(MethodsGet.getTypeForDay(listOfData, day, month, year, "close") + " close");

        System.out.println("Wartość dla Godziny:");
        System.out.println(MethodsGet.getTypeForHour(listOfData, day, month, year, hour, "high") + " high");
        System.out.println(MethodsGet.getTypeForHour(listOfData, day, month, year, hour, "low") + " low");
        System.out.println(MethodsGet.getTypeForHour(listOfData, day, month, year, hour, "open") + " open");
        System.out.println(MethodsGet.getTypeForHour(listOfData, day, month, year, hour, "close") + " close");

        System.out.println("Wartość dla minuty:");
        System.out.println(MethodsGet.getTypeForMinute(listOfData, day, month, year, hour, minute,  "high") + " high");
        System.out.println(MethodsGet.getTypeForMinute(listOfData, day, month, year, hour, minute, "low") + " low");
        System.out.println(MethodsGet.getTypeForMinute(listOfData, day, month, year, hour, minute, "open") + " open");
        System.out.println(MethodsGet.getTypeForMinute(listOfData, day, month, year, hour, minute, "close") + " close");
    }
}

