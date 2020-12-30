package Console;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Level;

import java.time.LocalDateTime;


public class History {

    public static void configuration() {
        String historyFile = "History_" + LocalDateTime.now() + ".txt";

//        File history = new File("/src/main/java/Console/History/" + historyFile);

        // creates pattern layout
        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%m %n";
        layout.setConversionPattern(conversionPattern);

        // creates console appender
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(layout);
        consoleAppender.activateOptions();

        // creates file appender
        FileAppender fileAppender = new FileAppender();
        fileAppender.setFile(historyFile);
        fileAppender.setLayout(layout);
        fileAppender.activateOptions();


        // configures the root logger
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);
        rootLogger.addAppender(consoleAppender);
        rootLogger.addAppender(fileAppender);

    }
}
