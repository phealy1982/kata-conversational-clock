package serenitylabs.tutorials.time;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by 66515 on 17/10/2016.
 */
public class ConversationalMinute {
    private static final NavigableMap<Integer, String> MINUTES = new TreeMap<>();
    private static final String NO_PREFIX = "";
    public static final String JUST_AFTER = "just after";
    public static final String ALMOST = "almost";

    static {
        MINUTES.put(0, "");
        MINUTES.put(5, "five");
        MINUTES.put(10, "ten");
        MINUTES.put(15, "quarter");
        MINUTES.put(20, "twenty");
        MINUTES.put(25, "twenty five");
        MINUTES.put(30, "half");
        MINUTES.put(35, "twenty five");
        MINUTES.put(40, "twenty");
        MINUTES.put(45, "quarter");
        MINUTES.put(50, "ten");
        MINUTES.put(55, "five");
        MINUTES.put(60, "");
    }

    public static String wordFor(Integer minute) {
        Integer previousSignificantMinute = MINUTES.floorKey(minute);
        Integer nextSignificantMinute = MINUTES.ceilingKey(minute);
        return closerToPreviousSignificantMinute(minute, previousSignificantMinute, nextSignificantMinute) ?
                MINUTES.get(previousSignificantMinute) :
                MINUTES.get(nextSignificantMinute);
    }

    public static String prefix(Integer minute) {
        Integer previousSignificantMinute = MINUTES.floorKey(minute);
        Integer nextSignificantMinute = MINUTES.ceilingKey(minute);
        return needsPrefix(minute, previousSignificantMinute, nextSignificantMinute) ?
                getPrefix(minute, previousSignificantMinute, nextSignificantMinute) :
                NO_PREFIX;
    }

    private static Boolean needsPrefix(Integer minute, Integer previousSignificantMinute, Integer nextSignificantMinute) {
        return (minute != previousSignificantMinute) || (minute != nextSignificantMinute);
    }

    private static String getPrefix(Integer minute, Integer previousSignificantMinute, Integer nextSignificantMinute) {
        return closerToPreviousSignificantMinute(minute, previousSignificantMinute, nextSignificantMinute) ?
                JUST_AFTER :
                ALMOST;
    }

    private static boolean closerToPreviousSignificantMinute(Integer minute, Integer previousSignificantMinute, Integer nextSignificantMinute) {
        return (minute - previousSignificantMinute) < (nextSignificantMinute - minute);
    }
}
