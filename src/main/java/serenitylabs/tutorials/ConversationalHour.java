package serenitylabs.tutorials;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peterhealy on 22/09/2016.
 */
public class ConversationalHour {
    private static final Map<Integer, String> TRANSLATION;

    static {
        TRANSLATION = new HashMap<>();
        TRANSLATION.put(0, "midnight");
        TRANSLATION.put(1, "one");
        TRANSLATION.put(2, "two");
        TRANSLATION.put(3, "three");
        TRANSLATION.put(4, "four");
        TRANSLATION.put(5, "five");
        TRANSLATION.put(6, "six");
        TRANSLATION.put(7, "seven");
        TRANSLATION.put(8, "eight");
        TRANSLATION.put(9, "nine");
        TRANSLATION.put(10, "ten");
        TRANSLATION.put(11, "eleven");
        TRANSLATION.put(12, "noon");
        TRANSLATION.put(13, "one");
        TRANSLATION.put(14, "two");
        TRANSLATION.put(15, "three");
        TRANSLATION.put(16, "four");
        TRANSLATION.put(17, "five");
        TRANSLATION.put(18, "six");
        TRANSLATION.put(19, "seven");
        TRANSLATION.put(20, "eight");
        TRANSLATION.put(21, "nine");
        TRANSLATION.put(22, "ten");
        TRANSLATION.put(23, "eleven");
        TRANSLATION.put(24, "midnight");
    }

    public static String wordFor(Integer hour) {
        return TRANSLATION.get(hour);
    }
}
