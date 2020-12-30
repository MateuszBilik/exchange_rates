package Console;
import OneLineOfData.MyDate;
import OneLineOfData.MyTime;
import java.util.regex.Pattern;

public class DateAndTimeForConsole {

    Pattern patternHour = Pattern.compile("\\d{2}");
    Pattern patternMinute = Pattern.compile("\\d{2}\\:\\d{2}");

    protected MyDate dateToTerminal(String date) throws BadCommandException {
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

    protected MyTime timeToTerminal(String time) throws BadCommandException {
        if (patternMinute.matcher(time).matches()) {
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

    protected MyTime timeToTerminalOnlyHour(String time) throws BadCommandException {
        if (patternHour.matcher(time).matches()) {  // correct number of hour
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
