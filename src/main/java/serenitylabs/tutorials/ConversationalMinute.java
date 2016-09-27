package serenitylabs.tutorials;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peterhealy on 25/09/2016.
 */
public class ConversationalMinute {

    private static final Map<Integer, String> TRANSLATION = new HashMap<>();

    static {
        TRANSLATION.put(5, "five");
        TRANSLATION.put(10, "ten");
        TRANSLATION.put(15, "quarter");
        TRANSLATION.put(20, "twenty");
        TRANSLATION.put(25, "twenty five");
        TRANSLATION.put(30, "half");
    }

    public static String wordFor(int minute) {
        return TRANSLATION.get(minute);
    }
}
