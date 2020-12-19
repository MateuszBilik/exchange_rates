package Methods;

import WorkWithFile.DataForOneMinute;

import java.math.BigDecimal;
import java.util.List;

public class MethodVolatility {

    public static BigDecimal volatilityForDay(List<DataForOneMinute> list, int day, int month, int year) {

        return MethodGet.getTypeForDay(list, day, month,year, "high").subtract(MethodGet.getTypeForDay(list, day, month,year, "low"));
    }

    public static BigDecimal volatilityForHour(List<DataForOneMinute> list, int day, int month, int year, int hour) {

        return MethodGet.getTypeForHour(list, day, month,year, hour, "high").subtract(MethodGet.getTypeForHour(list, day, month, year, hour, "low"));
    }

    public static BigDecimal volatilityForMinute(List<DataForOneMinute> list, int day, int month, int year, int hour, int minute) {

        return MethodGet.getTypeForMinute(list, day, month,year, hour, minute, "high").subtract(MethodGet.getTypeForMinute(list, day, month, year, hour, minute, "low"));
    }
}
