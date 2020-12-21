package Console;

import Methods.MethodGet;
import Methods.MethodVolatility;
import WorkWithFile.DataForOneMinute;
import WorkWithFile.MyDate;
import WorkWithFile.MyTime;

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
                    doGet(listOfData, listToMethod);
                } catch (BadCommandException e) {
                    System.out.println("You tried to use \"get\" but something was wrong, try again." +
                            "\nCheck your date or time");
                } catch (ArrayIndexOutOfBoundsException ee) {
                    System.out.println("You tried to use \"get\" but something was wrong, try again." +
                            "\nCheck your date or time");
                }
                break;
            case "volatility":
                break;
            default:
                System.out.println("There isn't this method, try again");
        }
    }

    private void doGet(List<DataForOneMinute> listOfData, String[] listToMethod) throws BadCommandException {
        MyDate myDate = dateToTerminal(listToMethod[2]);
        if (listToMethod.length == 3) {
            System.out.println(MethodGet.getTypeForDay(listOfData, myDate.getDay(),
                    myDate.getMonth(), myDate.getYear(), listToMethod[1]));
        } else if (listToMethod.length == 4) {
            if (listToMethod[3] == "\\d{2}") {
                MyTime myTime = timeToTerminalOnlyHour(listToMethod[3]);
                System.out.println(MethodGet.getTypeForHour(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear(), myTime.getHour(), listToMethod[1]));
            } else if (listToMethod[3] == "\\d{2}\\:\\d{2}") {
                MyTime myTime = timeToTerminal(listToMethod[3]);
                System.out.println(MethodGet.getTypeForMinute(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear(), myTime.getHour(), myTime.getMinute(), listToMethod[1]));
            } else {
                System.out.println("Something was wrong, try again \n Check your date or time");
            }
        } else {
            System.out.println("Something was wrong, try again \n Check your date or time");
        }
    }

    private MyDate dateToTerminal(String date) throws BadCommandException {

        if (date.equals("\\d{4}\\.\\d{2}\\.\\d{2}")) {
            String[] listOfDate = date.split("."); // correct number of days and months
            if (Integer.valueOf(listOfDate[1]) < 13 && Integer.valueOf(listOfDate[2]) < 32 &&
                    0 < Integer.valueOf(listOfDate[1]) && 0 < Integer.valueOf(listOfDate[2])) {
                return new MyDate(Integer.valueOf(listOfDate[0]),
                        Integer.valueOf(listOfDate[1]), Integer.valueOf(listOfDate[2]));
            } else {
                throw new BadCommandException();
            }
        } else {
            throw new BadCommandException();
        }
    }

    private MyTime timeToTerminal(String time) throws BadCommandException {

        if (time == "\\d{2}\\:\\d{2}") {
            String[] listOfDate = time.split(":"); // correct number of hour and minutes
            if (Integer.valueOf(listOfDate[0]) < 24 && Integer.valueOf(listOfDate[1]) < 60 &&
                    0 <= Integer.valueOf(listOfDate[0]) && 0 <= Integer.valueOf(listOfDate[1])) {
                return new MyTime(Integer.valueOf(listOfDate[0]), Integer.valueOf(listOfDate[1]));
            } else {
                throw new BadCommandException();
            }
        } else {
            throw new BadCommandException();
        }
    }

    private MyTime timeToTerminalOnlyHour(String time) throws BadCommandException {

        if (time == "\\d{2}\\") {  // correct number of hour
            if (Integer.valueOf(time) < 24 && 0 <= Integer.valueOf(time)) {
                return new MyTime(Integer.valueOf(time), 0);
            } else {
                throw new BadCommandException();
            }
        } else {
            throw new BadCommandException();
        }
    }

}
