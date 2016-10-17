package serenitylabs.tutorials;

import org.apache.commons.lang3.Range;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 66515 on 17/10/2016.
 */
public class TimeSentence {
    private static final Map<Integer, String> HOURS = new HashMap<>();
    private static final Map<Integer, String> MINUTES = new HashMap<>();


    static {
        HOURS.put(1, "one");
        HOURS.put(2, "two");
        HOURS.put(3, "three");
        HOURS.put(4, "four");
        HOURS.put(5, "five");
        HOURS.put(6, "six");
        HOURS.put(7, "seven");
        HOURS.put(8, "eight");
        HOURS.put(9, "nine");
        HOURS.put(10, "ten");
        HOURS.put(11, "eleven");
        HOURS.put(20, "eight");
        HOURS.put(22, "ten");

        MINUTES.put(10, "ten");
        MINUTES.put(20, "twenty");
        MINUTES.put(30, "half");
    }

    public String with(int hour, int minute) {
        if (minute > 30) {
            return "it's " + minute(60 - minute) + " to " + hour(hour + 1);
        } else if (minute > 0) {
            return "it's " + minute(minute) + " past " + hour(hour);
        } else {
            return "it's " + hour(hour) + " o'clock" ;
        }
    }

    private String minute(Integer minute) {
        return MINUTES.get(minute);
    }

    private String hour(Integer hour) {
        return HOURS.get(hour);
    }
}
