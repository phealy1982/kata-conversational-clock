package serenitylabs.tutorials;

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

        MINUTES.put(10, "ten");
        MINUTES.put(20, "twenty");
        MINUTES.put(30, "half");
    }

    public String sentenceWith(int hour, int minute) {
        return minute == 0 ?
                "it's " + hour(hour) + " o'clock" :
                "it's " + minute(minute) + " past " + hour(hour);
    }

    private String minute(Integer minute) {
        return MINUTES.get(minute);
    }

    private String hour(Integer hour) {
        return HOURS.get(hour);
    }
}
