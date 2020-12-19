package Methods;

import WorkWithFile.DataForOneMinute;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

class MethodGetTest {

    Integer year = 2020;
    Integer month = 11;
    Integer day = 01;
    Integer minute = 27;
    Integer hour = 23;
    String typeData = "open";
    List<DataForOneMinute> listOfData = new FileTest().getList();

    MethodGetTest() throws IOException {
    }

    @Test
    void getTypeForDay_compareSomeExamplesParameterFromFileWithCorrectAnswer() throws IOException {
        // given
        BigDecimal expectedValueHigh = BigDecimal.valueOf(1.16503);
        BigDecimal expectedValueLow = BigDecimal.valueOf(1.163);
        BigDecimal expectedValueOpen = BigDecimal.valueOf(1.16498);
        BigDecimal expectedValueClose = BigDecimal.valueOf(1.1631);

        // when
        BigDecimal valueHigh = MethodGet.getTypeForDay(listOfData, day, month, year, "high");
        BigDecimal valueLow = MethodGet.getTypeForDay(listOfData, day, month, year, "low");
        BigDecimal valueOpen = MethodGet.getTypeForDay(listOfData, day, month, year, "open");
        BigDecimal valueClose = MethodGet.getTypeForDay(listOfData, day, month, year, "close");
        // then
        assert(expectedValueHigh).equals(valueHigh);
        assert(expectedValueLow).equals(valueLow);
        assert(expectedValueOpen).equals(valueOpen);
        assert(expectedValueClose).equals(valueClose);
    }

    @Test
    void getTypeForHour_compareSomeExamplesParameterFromFileWithCorrectAnswer() throws IOException {
        // given
        BigDecimal expectedValueHigh = BigDecimal.valueOf(1.16404);
        BigDecimal expectedValueLow = BigDecimal.valueOf(1.16300);
        BigDecimal expectedValueOpen = BigDecimal.valueOf(1.16404);
        BigDecimal expectedValueClose = BigDecimal.valueOf(1.1631);

        // when
        BigDecimal valueHigh = MethodGet.getTypeForHour(listOfData, day, month, year, hour,  "high");
        BigDecimal valueLow = MethodGet.getTypeForHour(listOfData, day, month, year, hour, "low");
        BigDecimal valueOpen = MethodGet.getTypeForHour(listOfData, day, month, year, hour, "open");
        BigDecimal valueClose = MethodGet.getTypeForHour(listOfData, day, month, year, hour, "close");
        // then
        assert(expectedValueHigh).equals(valueHigh);
        assert(expectedValueLow).equals(valueLow);
        assert(expectedValueOpen).equals(valueOpen);
        assert(expectedValueClose).equals(valueClose);
    }

    @Test
    void getTypeMinute_compareSomeExamplesParameterFromFileWithCorrectAnswer() throws IOException {
        // given
        BigDecimal expectedValueHigh = new BigDecimal("1.16352");
        BigDecimal expectedValueLow = new BigDecimal("1.16348");
        BigDecimal expectedValueOpen = new BigDecimal("1.16348");
        BigDecimal expectedValueClose = new BigDecimal("1.16351");
        // when
        BigDecimal valueHigh = MethodGet.getTypeForMinute(listOfData, day, month, year, hour, minute,  "high");
        BigDecimal valueLow = MethodGet.getTypeForMinute(listOfData, day, month, year, hour, minute, "low");
        BigDecimal valueOpen = MethodGet.getTypeForMinute(listOfData, day, month, year, hour, minute, "open");
        BigDecimal valueClose = MethodGet.getTypeForMinute(listOfData, day, month, year, hour, minute, "close");
        // then
        assert(expectedValueHigh).equals(valueHigh);
        assert(expectedValueLow).equals(valueLow);
        assert(expectedValueOpen).equals(valueOpen);
        assert(expectedValueClose).equals(valueClose);
    }

    @Test
    void volatilityForDayHourMinute_compareSomeExamplesParameterFromFileWithCorrectAnswer() throws IOException {
        //given
        BigDecimal valueForDayExpected = new BigDecimal("0.00203");
        BigDecimal valueForHourExpected = new BigDecimal("0.00104");
        BigDecimal valueForMinuteExpected = new BigDecimal("0.00004");
        //when
        BigDecimal valueForDay = MethodVolatility.volatilityForDay(listOfData, day, month, year);
        BigDecimal valueForHour = MethodVolatility.volatilityForHour(listOfData, day, month, year, hour);
        BigDecimal valueForMinute = MethodVolatility.volatilityForMinute(listOfData, day, month, year, hour, minute);
        //then
        assert(valueForDayExpected).equals(valueForDay);
        assert(valueForHourExpected).equals(valueForHour);
        assert(valueForMinuteExpected).equals(valueForMinute);
    }






}