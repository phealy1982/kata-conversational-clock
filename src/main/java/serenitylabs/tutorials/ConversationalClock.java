package serenitylabs.tutorials;

public class ConversationalClock {

    private static final int ONE_HOUR = 1;
    private static final String SPACE = " ";
    public static final String O_CLOCK = SPACE + "o'clock";
    public static final String START_OF_SENTENCE = "it's" + SPACE;
    private final SystemTime now;

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    private Boolean onTheHour(int minute) {
        return minute == 0;
    }

    private int nearestHour(int minute) {
        return minute > 30 ? now.hour() + ONE_HOUR : now.hour();
    }

    public String currentTime() {
        return createSentence(now.hour(), now.minute());
    }

    private String createSentence(int hour, int minute) {
        String sentence = START_OF_SENTENCE;
        String hourPart = ConversationalHour.wordFor(nearestHour(minute));
        String minutePart = "";

        if (onTheHour(now.minute()) && !noonOrMidnight(hour, minute)) {
                hourPart += O_CLOCK;
        } else if(!onTheHour(minute)){
            minutePart = ConversationalMinute.wordFor(minute) + SPACE;
        }
        return sentence + minutePart + hourPart;
    }

    private boolean noonOrMidnight(int hour, int minute) {
        return (hour == 0 || hour == 12) && minute == 0;
    }
}
