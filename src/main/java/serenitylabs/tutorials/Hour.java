package serenitylabs.tutorials;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 66515 on 17/10/2016.
 */
public class Hour {
    private static final Map<Integer, String> HOURS = new HashMap<>();
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
        HOURS.put(12, "noon");
        HOURS.put(11, "eleven");
        HOURS.put(20, "eight");
        HOURS.put(22, "ten");
        HOURS.put(24, "midnight");
        HOURS.put(0, "midnight");
    }

    public static String wordFor(Integer hour) {
        return HOURS.get(hour);
    }
}
