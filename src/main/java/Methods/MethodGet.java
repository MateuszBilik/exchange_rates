package Methods;

import WorkWithFile.DataForOneMinute;
import WorkWithFile.MyValue;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class MethodGet {

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

    public static BigDecimal getTypeForMinute(List<DataForOneMinute> list, int day, int month, int year, int hour, int minute, String type) {
        list = getForMinute(list, day, month, year, hour, minute);
        return getType(list, type);
    }

    public static BigDecimal getTypeForHour(List<DataForOneMinute> list, int day, int month, int year, int hour, String type) {
        list = getForHour(list, day, month, year, hour);
        return getType(list, type);
    }

    public static BigDecimal getTypeForDay(List<DataForOneMinute> list, int day, int month, int year, String type) {
        list = getForDay(list, day, month, year);
        return getType(list, type);
    }

    private static BigDecimal getType(List<DataForOneMinute> list, String type) {
        switch (type) {
            case "open":
                return openValueForPeriodTime(list);
            case "high":
                return highForTimePerioid(list);
            case "low":
                return lowForTimePerioid(list);
            case "close":
                return closeForTimePerioid(list);
        default: return BigDecimal.ZERO;
        }
    }

    private static BigDecimal lowForTimePerioid(List<DataForOneMinute> list) {
        List<BigDecimal> low = list.stream()
                .map(DataForOneMinute::getValue)
                .map(MyValue::getLow)
                .sorted()
                .collect(Collectors.toList());
        return low.get(0);
    }

    private static BigDecimal highForTimePerioid(List<DataForOneMinute> list) {
        List<BigDecimal> high = list.stream()
                .map(DataForOneMinute::getValue)
                .map(MyValue::getHigh)
                .sorted()
                .collect(Collectors.toList());
        return high.get(high.size() - 1);
    }

    private static BigDecimal closeForTimePerioid(List<DataForOneMinute> list) {
        List<BigDecimal> close = list.stream()
                .map(DataForOneMinute::getValue)
                .map(MyValue::getClose)
                .collect(Collectors.toList());
        return close.get(close.size() - 1);
    }

    private static BigDecimal openValueForPeriodTime(List<DataForOneMinute> list) {
        List<BigDecimal> open = list.stream()
                .map(DataForOneMinute::getValue)
                .map(MyValue::getOpen)
                .collect(Collectors.toList());
        return open.get(0);
    }
}

