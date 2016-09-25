package serenitylabs.tutorials;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peterhealy on 22/09/2016.
 */
public class ConversationalHour {
    private static final Map<List<Integer>, String> TRANSLATION;

    static {
        TRANSLATION = new HashMap<>();
        TRANSLATION.put(Arrays.asList(0, 24), "midnight");
        TRANSLATION.put(Arrays.asList(1, 13), "one");
        TRANSLATION.put(Arrays.asList(2, 14), "two");
        TRANSLATION.put(Arrays.asList(3, 15), "three");
        TRANSLATION.put(Arrays.asList(4, 16), "four");
        TRANSLATION.put(Arrays.asList(5, 17), "five");
        TRANSLATION.put(Arrays.asList(6, 18), "six");
        TRANSLATION.put(Arrays.asList(7, 19), "seven");
        TRANSLATION.put(Arrays.asList(8, 20), "eight");
        TRANSLATION.put(Arrays.asList(9, 21), "nine");
        TRANSLATION.put(Arrays.asList(10, 22), "ten");
        TRANSLATION.put(Arrays.asList(11, 23), "eleven");
        TRANSLATION.put(Arrays.asList(12), "noon");

    }

    public static String wordFor(Integer hour) {
        List<Integer> key = null;
        for (List<Integer> aKey : TRANSLATION.keySet()) {
            if (aKey.contains(hour)) {
                key = aKey;
            }
        }
        return TRANSLATION.get(key);
    }
}
