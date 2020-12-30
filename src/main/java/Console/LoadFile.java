package Console;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LoadFile {

    Logger logger = Logger.getLogger(LoadFile.class);

    public BufferedReader loadFile() {
        BufferedReader myFile = null;
        boolean hasFileExist = false;

        while (!(hasFileExist)) {
            String inputText = new Scanner(System.in).nextLine();

            if (inputText.equals("exit")) {
                new Console().goodbye();
                System.exit(0);
                break;
            } else {
                try {
//                    inputText = "DAT_MT_EURUSD_M1_202011.csv";
                    myFile = new BufferedReader(new FileReader(inputText));
                    hasFileExist = true;
                    logger.info("File found.");
                } catch (FileNotFoundException e) {
                    logger.info(inputText +  " - Try again. This file not exist.");
                }
            }
        }
        return myFile;
    }
}
