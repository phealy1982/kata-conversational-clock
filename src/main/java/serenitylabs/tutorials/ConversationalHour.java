package serenitylabs.tutorials;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peterhealy on 22/09/2016.
 */
public class ConversationalHour {
    private static final Map<Integer, String> wordForHour = setUpTranslation();

    private static Map<Integer, String> setUpTranslation() {
        Map<Integer, String> translation = new HashMap<>();
        translation.put(1, "one");
        translation.put(2, "two");
        translation.put(13, "one");
        return translation;
    }

    public static String wordFor(Integer hour) {
        return wordForHour.get(hour);
    }
}
