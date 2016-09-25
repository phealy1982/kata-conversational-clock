package serenitylabs.tutorials;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peterhealy on 25/09/2016.
 */
public class ConversationalMinute {


    private static final Map<Integer, String> TRANSLATION;

    static {
        TRANSLATION = new HashMap<>();

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
        TRANSLATION.put(11, "elven");
        TRANSLATION.put(12, "twelve");
        TRANSLATION.put(13, "thirteen");
        TRANSLATION.put(14, "fourteen");
        TRANSLATION.put(15, "quarter");
        TRANSLATION.put(16, "sixteen");
        TRANSLATION.put(17, "seventeen");
        TRANSLATION.put(18, "eighteen");
        TRANSLATION.put(19, "nineteen");

        createTranslationForRange(20, 29, "twenty");
        createTranslationForRange(30, 39, "thirty");
        createTranslationForRange(40, 49, "forty");
        createTranslationForRange(50, 59, "fifty");

    }

    private static void createTranslationForRange(int from, int to, String wordForRange) {
        if("thirty".equals(wordForRange)){
            TRANSLATION.put(from, "half");
        } else {
            TRANSLATION.put(from, wordForRange);
        }

        for(int minute = from + 1; minute< to; minute++){
            TRANSLATION.put(minute, wordForRange + " " + TRANSLATION.get(minute - from));
        }
    }

    public static String wordFor(int minute) {
        return TRANSLATION.get(minute);
    }
}
