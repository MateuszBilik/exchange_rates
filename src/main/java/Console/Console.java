package Console;

import WorkWithFile.DataForOneMinute;

import java.io.BufferedReader;
import java.util.List;

public class Console {


    public void workWithFile() {
        System.out.println("What do you want to do with file?");


    }

    public List<DataForOneMinute> startAndLoad() {
        greetings();
        BufferedReader myFile = new LoadFile().loadFile();
        return ConvertToWork.createListWithDataForOneMinutesLines(myFile);
    }

    public void goodbye() {

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
}
