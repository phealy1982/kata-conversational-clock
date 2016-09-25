package serenitylabs.tutorials;

public class ConversationalClock {

    private static final int ONE_HOUR = 1;
    public static final int MINUTES_IN_AN_HOUR = 60;
    private static final String SPACE = " ";
    public static final String O_CLOCK = SPACE + "o'clock";
    public static final String TO_THE_HOUR = SPACE + "to" + SPACE;
    public static final String START_OF_SENTENCE = "it's" + SPACE;
    private static final String PAST_THE_HOUR = SPACE + "past" + SPACE;
    private final SystemTime now;

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    public String currentTime() {
            return createSentence(now.hour(), now.minute());
    }

    private String createSentence(int hour, int minute) {
        String sentence = START_OF_SENTENCE;

        if(noonOrMidnight(hour, minute)){
            return sentence + ConversationalHour.wordFor(hour);
        }

        if(onTheHour(minute)){
            return sentence + ConversationalHour.wordFor(hour) + O_CLOCK;
        }

        if(approachingTheHour(minute)){
            return sentence + ConversationalMinute.wordFor(minutesToTheHour(minute)) + TO_THE_HOUR
                + nextHour(hour);
        }

        return  sentence + ConversationalMinute.wordFor(minute) + PAST_THE_HOUR +
            ConversationalHour.wordFor(hour);

    }

    private boolean noonOrMidnight(int hour, int minute) {
        return (hour == 0 || hour == 12) && minute == 0;
    }

    private int minutesToTheHour(int minute) {
        return MINUTES_IN_AN_HOUR - minute;
    }

    private String nextHour(int hour) {
        return ConversationalHour.wordFor(hour + ONE_HOUR);
    }

    private boolean onTheHour(int minute) {
        return minute == 0;
    }

    private boolean approachingTheHour(int minute) {
        return minute > 30;
    }


}
