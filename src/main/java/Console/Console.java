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

    public void goodBay() {

        //write history to file
        System.out.println("""
                Good bay!
                Thank you for used our program.
                See you soon!
                """);
    }

    private void greetings() {
        System.out.println("""
                Hello,
                Welcome in this program!
                You can always quit program - You just write "exit".
                Please, give me your file name with you would like to work:
                """);
    }
}
