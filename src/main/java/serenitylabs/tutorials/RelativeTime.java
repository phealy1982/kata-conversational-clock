package serenitylabs.tutorials;

/**
 * Created by 66515 on 27/09/2016.
 */
public class RelativeTime {
    private static final int HALF_HOUR = 30;
    private static final int ONE_HOUR = 1;
    public static final String BLANK = "";
    private static final int MIDNIGHT_HOUR = 0;
    private static final int NOON_HOUR = 12;
    private SystemTime now;

    public RelativeTime(SystemTime now) {
        this.now = now;
    }

    public int relativeHour() {
        return this.now.minute() > HALF_HOUR ? now.hour() + ONE_HOUR : now.hour();
    }

    public int hour() {
        return this.now.hour();
    }

    public int minute() {
        return this.now.minute();
    }

    public boolean pastTheHour() {
        return this.now.minute() <= HALF_HOUR && this.now.minute() != 0;
    }

    public int relativeMinute() {
        int relativeMinute = closestSignificantMinute(minute());
        return relativeMinute > HALF_HOUR ? 60 - relativeMinute : relativeMinute;
    }

    private static int closestSignificantMinute(int minute) {
        int closestSignificantMinute = minute;

        for (int addSubtract = 0; addSubtract < 3; addSubtract++) {
            if ((minute + addSubtract) % 5 == 0) {
                closestSignificantMinute = minute + addSubtract;
            } else if ((minute - addSubtract) % 5 == 0) {
                closestSignificantMinute = minute - addSubtract;
            }
        }
        return closestSignificantMinute;
    }

    public String minutePrefix() {
        String minutePrefix = BLANK;

        if (now.minute() > closestSignificantMinute(now.minute())) {
            minutePrefix = "just gone";
        }

        if (now.minute() < closestSignificantMinute(now.minute())) {
            minutePrefix = "almost";
        }

        return minutePrefix;
    }

    public String hourPrefix() {
        return pastTheHour() ? "past" : "to";
    }

    public boolean onTheHour() {
        return now.minute()==0;
    }

    public boolean noonOrMidnight() {
        return (now.hour() == MIDNIGHT_HOUR || now.hour() == NOON_HOUR) && onTheHour();
    }
}
