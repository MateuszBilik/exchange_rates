package Methods;

import Console.LoadFile;
import WorkWithFile.DataForOneMinute;
import WorkWithFile.MyDate;
import WorkWithFile.MyTime;
import WorkWithFile.MyValue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
    public List<DataForOneMinute> getList() throws FileNotFoundException {

        ArrayList<DataForOneMinute> listOfData = new ArrayList();
        String line = null;

        BufferedReader myFile = new LoadFile().loadFile();
        String[] listSeparatedData = line.split(",");
        String[] date = listSeparatedData[0].split("\\.");
        String[] time = listSeparatedData[1].split(":");

        listOfData.add(new DataForOneMinute(     //YYYY.MM.DD,HH:MM,OPEN,HIGH,LOW,CLOSE,VOLUME
                new MyDate(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])),
                new MyTime(Integer.parseInt(time[0]), Integer.parseInt(time[1])),
                new MyValue(
                        BigDecimal.valueOf(Double.parseDouble(listSeparatedData[2])),
                        BigDecimal.valueOf(Double.parseDouble(listSeparatedData[3])),
                        BigDecimal.valueOf(Double.parseDouble(listSeparatedData[4])),
                        BigDecimal.valueOf(Double.parseDouble(listSeparatedData[5])))));
        return listOfData;
    }


}
