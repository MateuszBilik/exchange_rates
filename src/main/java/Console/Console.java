package Console;

import Methods.MethodVolatility;
import OneLineOfData.DataForOneMinute;
import java.io.BufferedReader;
import java.util.List;
import java.util.Scanner;

public class Console {

    public void workWithFile(List<DataForOneMinute> listOfData) {
        System.out.println("What do you want to do with file?");
        while (true) {
            terminal(listOfData);
        }
    }

    public List<DataForOneMinute> startAndLoad() {
        greetings();
        BufferedReader myFile = new LoadFile().loadFile();
        return ConvertToWork.createListWithDataForOneMinutesLines(myFile);
    }

    private void goodbye() {

        //write history to file
        System.out.println("""
                Thank you for using our app.
                See you soon!
                """);
    }

    private void greetings() {
        System.out.println("""
                Hello,
                Welcome in this app!
                You can always quit the app by writing "exit".
                Please, give your file name which you would like to work with:
                """);
    }

    private void terminal(List<DataForOneMinute> listOfData) {
        String inputText = new Scanner(System.in).nextLine()
                .toLowerCase().replaceAll("\\s+", " ");
        String[] listToMethod = inputText.split(" ");

        switch (listToMethod[0]) {
            case "exit":
                System.exit(0);
                break;
            case "most_volatile_day":
                System.out.println(MethodVolatility.mostVolatileDay(listOfData));
                break;
            case "most_volatile_hour":
                System.out.println(MethodVolatility.mostVolatileHour(listOfData));
                break;
            case "average_minutely_volatility":
                System.out.println(MethodVolatility.averageMinutelyVolatility(listOfData));
                break;
            case "average_hourly_volatility":
                System.out.println(MethodVolatility.averageHourlyVolatility(listOfData));
                break;
            case "average_daily_volatility":
                System.out.println(MethodVolatility.averageDailyVolatility(listOfData));
                break;
            case "get":
                try {
                   new GetForConsole().doGet(listOfData, listToMethod);
                } catch (ArrayIndexOutOfBoundsException|BadCommandException e) {
                    System.out.println("You tried to use method \"get\" but something was wrong, try again." +
                            "\nCheck your date or time. Another option can be to lack data for this time in this file");
                }
                break;
            case "volatility":
                break;
            default:
                System.out.println("There isn't this method, try again");
        }
    }
}
