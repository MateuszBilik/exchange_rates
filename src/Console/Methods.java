package Console;

import WorkWithFile.DataForOneMinute;
import WorkWithFile.MyValue;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Methods {

    public static List<DataForOneMinute> getForDay(List<DataForOneMinute> list, int day, int month, int year) {
        return list.stream()
                .filter(x -> x.getDate().getYear() == year)
                .filter(x -> x.getDate().getMonth() == month)
                .filter(x -> x.getDate().getDay() == day)
                .collect(Collectors.toList());
    }

    public static List<DataForOneMinute> getForHour(List<DataForOneMinute> list, int day, int month, int year, int hour) {

        return getForDay(list, day, month, year).stream()
                .filter(x -> x.getTime().getHour() == hour)
                .collect(Collectors.toList());
    }

    public static List<DataForOneMinute> getForMinute(List<DataForOneMinute> list, int day, int month, int year, int hour, int minute) {

        return getForHour(list, day, month, year, hour).stream()
                .filter(x -> x.getTime().getMinute() == minute)
                .collect(Collectors.toList());
    }

    public static Double getTypeForMinute(List<DataForOneMinute> list, int day, int month, int year, int hour, int minute, String type) {

        getForHour(list, day, month, year, hour);

        switch (type) {
            case "open":
                return list.get(0).getValue().getOpen();
            case "high":
                return list.get(0).getValue().getOpen();
            case "low":
                return list.get(0).getValue().getOpen();
            case "close":
                return list.get(0).getValue().getOpen();
            default: return 0.0;
        }

    }


    private String open;
    private String high;
    private String low;
    private String close;


}
