import Console.Console;
import Methods.MethodVolatility;
import WorkWithFile.DataForOneMinute;
import Methods.MethodGet;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Console console = new Console();
        List<DataForOneMinute> listOfData = console.startAndLoad();


        Integer year = 2020;
        Integer month = 11;
        Integer day = 01;
        Integer minute = 27;
        Integer hour = 23;
        String typeData = "open";


        System.out.println(MethodGet.getTypeForMinute(listOfData, day, month, year, hour, minute, typeData));
        System.out.println(MethodGet.getForMinute(listOfData, day, month, year, hour, minute));

        System.out.println("\nWartość dla dnia:");
        System.out.println(MethodVolatility.volatilityForDay(listOfData, day, month, year));

        System.out.println("\nWartość dla godziny:");
        System.out.println(MethodVolatility.volatilityForMinute(listOfData, day, month, year, hour, minute));


    }
}

