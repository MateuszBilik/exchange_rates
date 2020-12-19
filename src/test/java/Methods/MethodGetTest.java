package Methods;

import WorkWithFile.DataForOneMinute;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

class MethodGetTest {

    Integer year = 2020;
    Integer month = 11;
    Integer day = 01;
    Integer minute = 27;
    Integer hour = 23;
    String typeData = "open";

    @Test
    void getTypeForDay_compareSomeExamplesParameterFromFileWithCorrectAnswer_receiveIfTrue() throws FileNotFoundException {
        // given
        List<DataForOneMinute> listOfData = new FileTest().getList();

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
        assert (expectedValueHigh).equals(valueHigh);
        assert (expectedValueLow).equals(valueLow);
        assert (expectedValueOpen).equals(valueOpen);
        assert (expectedValueClose).equals(valueClose);
    }
}