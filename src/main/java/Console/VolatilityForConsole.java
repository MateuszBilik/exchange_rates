package Console;

import Methods.MethodVolatility;
import OneLineOfData.DataForOneMinute;
import OneLineOfData.MyDate;
import OneLineOfData.MyTime;
import org.apache.log4j.Logger;

import java.util.List;

public class VolatilityForConsole extends DateAndTimeForConsole{

    Logger logger = Logger.getLogger(VolatilityForConsole.class);

    public void doVolatility(List<DataForOneMinute> listOfData, String[] type) throws BadCommandException {

        MyDate myDate = dateToTerminal(type[1]);
        if (type.length == 2) {

            logger.info(MethodVolatility.volatilityForDay(listOfData, myDate.getDay(),
                    myDate.getMonth(), myDate.getYear()));

        } else if (type.length == 3) {
            if (patternHour.matcher(type[2]).matches()) {
                MyTime myTime = timeToTerminalOnlyHour(type[2]);

                logger.info(MethodVolatility.volatilityForHour(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear(), myTime.getHour()));

            } else if (patternMinute.matcher(type[2]).matches()) {
                MyTime myTime = timeToTerminal(type[2]);

                logger.info(MethodVolatility.volatilityForMinute(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear(), myTime.getHour(), myTime.getMinute()));
            }
        }

    }

}
