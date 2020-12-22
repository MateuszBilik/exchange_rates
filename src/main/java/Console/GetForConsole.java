package Console;

import Methods.MethodGet;
import OneLineOfData.DataForOneMinute;
import OneLineOfData.MyDate;
import OneLineOfData.MyTime;

import java.util.List;
import java.util.regex.Pattern;

public class GetForConsole {

    public void doGet(List<DataForOneMinute> listOfData, String[] type) throws BadCommandException {
        Pattern patternHour = Pattern.compile("\\d{2}");
        Pattern patternMinute = Pattern.compile("\\d{2}\\:\\d{2}");

        if (type[1].equals("close") || type[1].equals("open") || type[1].equals("low") || type[1].equals("high")) {
            MyDate myDate = dateToTerminal(type[2]);
            if (type.length == 3) {
                System.out.println(MethodGet.getTypeForDay(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear(), type[1]));
            } else if (type.length == 4) {
                if (patternHour.matcher(type[3]).matches()) {
                    MyTime myTime = timeToTerminalOnlyHour(type[3]);
                    System.out.println(MethodGet.getTypeForHour(listOfData, myDate.getDay(),
                            myDate.getMonth(), myDate.getYear(), myTime.getHour(), type[1]));
                } else if (patternMinute.matcher(type[3]).matches()) {
                    MyTime myTime = timeToTerminal(type[3]);
                    System.out.println(MethodGet.getTypeForMinute(listOfData, myDate.getDay(),
                            myDate.getMonth(), myDate.getYear(), myTime.getHour(), myTime.getMinute(), type[1]));
                }
            }
        } else {
            MyDate myDate = dateToTerminal(type[1]);
            if (type.length == 2) {
                System.out.println(MethodGet.getForDay(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear()));
            } else if (type.length == 3) {
                if (patternHour.matcher(type[2]).matches()) {
                    MyTime myTime = timeToTerminalOnlyHour(type[2]);
                    System.out.println(MethodGet.getForHour(listOfData, myDate.getDay(),
                            myDate.getMonth(), myDate.getYear(), myTime.getHour()));
                } else if (patternMinute.matcher(type[2]).matches()) {
                    MyTime myTime = timeToTerminal(type[2]);
                    System.out.println(MethodGet.getForMinute(listOfData, myDate.getDay(),
                            myDate.getMonth(), myDate.getYear(), myTime.getHour(), myTime.getMinute()));
                }
            }
        }
    }

    private MyDate dateToTerminal(String date) throws BadCommandException {
        Pattern pattern = Pattern.compile("\\d{4}\\.\\d{2}\\.\\d{2}");
        if (pattern.matcher(date).matches()) {
            String[] listOfDate = date.split("\\."); // correct number of days and months
            if (Integer.parseInt(listOfDate[1]) < 13 && Integer.parseInt(listOfDate[2]) < 32 &&
                    0 < Integer.parseInt(listOfDate[1]) && 0 < Integer.parseInt(listOfDate[2])) {
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
        Pattern pattern = Pattern.compile("\\d{2}\\:\\d{2}");
        if (pattern.matcher(time).matches()) {
            String[] listOfDate = time.split(":"); // correct number of hour and minutes
            if (Integer.parseInt(listOfDate[0]) < 24 && Integer.parseInt(listOfDate[1]) < 60 &&
                    0 <= Integer.parseInt(listOfDate[0]) && 0 <= Integer.parseInt(listOfDate[1])) {
                return new MyTime(Integer.parseInt(listOfDate[0]), Integer.parseInt(listOfDate[1]));
            } else {
                throw new BadCommandException();
            }
        } else {
            throw new BadCommandException();
        }
    }

    private MyTime timeToTerminalOnlyHour(String time) throws BadCommandException {
        Pattern pattern = Pattern.compile("\\d{2}");
        if (pattern.matcher(time).matches()) {  // correct number of hour
            if (Integer.parseInt(time) < 24 && 0 <= Integer.parseInt(time)) {
                return new MyTime(Integer.parseInt(time), 0);
            } else {
                throw new BadCommandException();
            }
        } else {
            throw new BadCommandException();
        }
    }
}
