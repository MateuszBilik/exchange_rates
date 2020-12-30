package Console;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.time.LocalDateTime;


public class History {

    public static void configuration() {
        String historyFile = "src/main/java/Console/History/History_" + LocalDateTime.now() + ".txt";

        // creates pattern layout
        PatternLayout layout = new PatternLayout();
        layout.setConversionPattern("%m %n");

        PatternLayout layoutFile = new PatternLayout();
        layoutFile.setConversionPattern("[%d{HH:mm:ss}] %n%m %n");

        // creates console appender
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(layout);
        consoleAppender.activateOptions();

        // creates file appender
        FileAppender fileAppender = new FileAppender();
        fileAppender.setFile(historyFile);
        fileAppender.setLayout(layoutFile);
        fileAppender.activateOptions();

        // configures the root logger
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.addAppender(consoleAppender);
        rootLogger.addAppender(fileAppender);
    }
}
