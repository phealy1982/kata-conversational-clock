package serenitylabs.tutorials;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peterhealy on 25/09/2016.
 */
public class ConversationalMinute {

    private static final Map<Integer, String> TRANSLATION;
    private static final String NO_PREFIX = "";
    public static final String TO = " to";
    public static final String PAST = " past";
    public static final int HALF_HOUR = 30;
    public static final int HOUR = 60;

    static {
        TRANSLATION = new HashMap<>();

        TRANSLATION.put(5, "five");
        TRANSLATION.put(10, "ten");
        TRANSLATION.put(15, "quarter");
        TRANSLATION.put(20, "twenty");
        TRANSLATION.put(25, "twenty five");
        TRANSLATION.put(30, "half");

    }

    public static String wordFor(int minute) {
        int closestSignificantMinute = closestSignificantMinute(minute);

        String preFix = minute != closestSignificantMinute ?
            minutePrefix(minute, closestSignificantMinute):
            NO_PREFIX;

        String postFix = pastTheHalfHour(minute) ? TO : PAST;

        return preFix + TRANSLATION.get(minuteRelatedToNearestHour(closestSignificantMinute)) + postFix;
    }

    private static int minuteRelatedToNearestHour(int minute) {
        return pastTheHalfHour(minute) ?
            HOUR - minute:
            minute;
    }

    private static boolean pastTheHalfHour(int minute) {
        return minute > HALF_HOUR;
    }

    private static String minutePrefix(int minute, int closestSignificantMinute) {
        return minute > closestSignificantMinute ?
            "just gone ":
            "almost ";
    }

    private static int closestSignificantMinute(int minute) {
        int closestSignificantMinute = minute;

        for(int addSubtract=0; addSubtract <3; addSubtract++){
            if((minute + addSubtract) % 5 == 0){
                closestSignificantMinute = minute + addSubtract;
            } else if((minute - addSubtract) % 5 == 0){
                closestSignificantMinute = minute - addSubtract;
            }
        }
        return closestSignificantMinute;
    }
}
