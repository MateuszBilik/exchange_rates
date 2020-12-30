import Console.Console;
import OneLineOfData.DataForOneMinute;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Console console = new Console();
        List<DataForOneMinute> listOfData = console.startAndLoad();
        console.workWithFile(listOfData);
    }
}

