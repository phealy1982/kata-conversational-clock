package serenitylabs.tutorials.time;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 66515 on 17/10/2016.
 */
public class ConversationalHour {
    private static final Map<List<Integer>, String> HOURS = new HashMap<>();

    static {
        HOURS.put(values(1, 13), "one");
        HOURS.put(values(2, 14), "two");
        HOURS.put(values(3, 15), "three");
        HOURS.put(values(4, 16), "four");
        HOURS.put(values(5, 17), "five");
        HOURS.put(values(6, 18), "six");
        HOURS.put(values(7, 19), "seven");
        HOURS.put(values(8, 20), "eight");
        HOURS.put(values(9, 21), "nine");
        HOURS.put(values(10, 22), "ten");
        HOURS.put(values(12), "noon");
        HOURS.put(values(0, 24), "midnight");
    }

    private static List<Integer> values(Integer... hours) {
        return Arrays.asList(hours);
    }

    public static String wordFor(Integer hour) {
        return HOURS.entrySet()
                .stream()
                .filter((e -> e.getKey().contains(hour)))
                .findAny()
                .get()
                .getValue();
    }
}