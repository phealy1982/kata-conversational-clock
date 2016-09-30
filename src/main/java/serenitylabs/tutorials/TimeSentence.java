package serenitylabs.tutorials;

import java.util.StringJoiner;

/**
 * Created by 66515 on 29/09/2016.
 */
public class TimeSentence {

    private static final String BEGINNING = "it's ";
    private static final String FULL_STOP = ".";
    private static final int MIDNIGHT_HOUR = 0;
    private static final int NOON_HOUR = 12;
    private String ending;
    private String minutePrefix;
    private String minute;
    private String hourPrefix;
    private String hour;

    public TimeSentence(String minutePrefix, String minute, String hourPrefix, String hour, String ending) {
        this.minutePrefix = minutePrefix;
        this.minute = minute;
        this.hourPrefix = hourPrefix;
        this.hour = hour;
        this.ending = ending;
    }

    public static TimeSentenceBuilder withHour(String hour) {
        return new TimeSentenceBuilder(hour);
    }

    public String sentence() {
        return new StringJoiner(" ", BEGINNING, this.ending)
                .add(this.minutePrefix)
                .add(this.minute)
                .add(this.hourPrefix)
                .add(this.hour)
                .toString()
                .replaceAll("\\s+", " ");

    }

    public static String representing(RelativeTime now) {

        if (now.noonOrMidnight()) {
            return TimeSentence.forNoonOrMidnight(now);
        } else if (now.onTheHour()) {
            return TimeSentence.forOnTheHour(now);
        }
        return TimeSentence.forTime(now);
    }

    private static String forTime(RelativeTime now) {
        return TimeSentence.withHour(ConversationalHour.wordFor(now.relativeHour()))
                .andMinutePrefix(now.minutePrefix())
                .andMinute(ConversationalMinute.wordFor(now.relativeMinute()))
                .andHourPrefix(now.hourPrefix())
                .andWithEnding(FULL_STOP).sentence();
    }

    private static String forOnTheHour(RelativeTime now) {
        return TimeSentence.withHour(ConversationalHour.wordFor(now.relativeHour()))
                .andWithOClockEnding().sentence();
    }

    private static String forNoonOrMidnight(RelativeTime now) {
        return TimeSentence.withHour(ConversationalHour.wordFor(now.relativeHour()))
                .andWithEnding(FULL_STOP).sentence();
    }

    public static class TimeSentenceBuilder {
        private String hour;
        private String minute = "";
        private String minutePrefix = "";
        private String hourPrefix = "";

        public TimeSentenceBuilder(String hour) {
            this.hour = hour;
        }

        public TimeSentence andWithEnding(String ending) {
            return new TimeSentence(this.minutePrefix, this.minute, this.hourPrefix, this.hour, ending);
        }

        public TimeSentenceBuilder andMinute(String minute) {
            this.minute = minute;
            return this;
        }

        public TimeSentence andWithOClockEnding() {
            return new TimeSentence(this.minutePrefix, this.minute, this.hourPrefix, this.hour, " o'clock.");
        }

        public TimeSentenceBuilder andMinutePrefix(String minutePrefix) {
            this.minutePrefix = minutePrefix;
            return this;
        }

        public TimeSentenceBuilder andHourPrefix(String hourPrefix) {
            this.hourPrefix = hourPrefix;
            return this;
        }

    }
}
