import Console.Console;
import Methods.MethodGet;
import Methods.MethodVolatility;
import WorkWithFile.DataForOneMinute;

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


        System.out.println(MethodVolatility.mostVolatileHour(listOfData));
        System.out.println(MethodVolatility.mostVolatileDay(listOfData));
        System.out.println(MethodVolatility.averageMinutelyVolatility(listOfData));
        System.out.println(MethodVolatility.averageHourlyVolatility(listOfData));
        System.out.println(MethodVolatility.averageDailyVolatility(listOfData));


    }
}

