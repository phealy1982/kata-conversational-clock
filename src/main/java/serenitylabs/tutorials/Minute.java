package serenitylabs.tutorials;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 66515 on 17/10/2016.
 */
public class Minute {
    private static final Map<Integer, String> MINUTES = new HashMap<>();
    static {
        MINUTES.put(5, "five");
        MINUTES.put(10, "ten");
        MINUTES.put(15, "quarter");
        MINUTES.put(20, "twenty");
        MINUTES.put(25, "twenty five");
        MINUTES.put(30, "half");
    }

    public static String wordFor(Integer minute) {
        return MINUTES.get(minute);
    }
}
