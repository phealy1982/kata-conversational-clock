package serenitylabs.tutorials;

public class ConversationalClock {

    private static final int ONE_HOUR = 1;
    private static final String SPACE = " ";
    public static final String O_CLOCK = SPACE + "o'clock";
    public static final String START_OF_SENTENCE = "it's" + SPACE;
    private final SystemTime now;
    private final int nearestHour;

    public ConversationalClock(SystemTime time) {
        this.now = time;
        this.nearestHour = nearestHour(this.now.minute());
    }

    private int nearestHour(int minute) {
        return minute>30 ?
            now.hour()+ONE_HOUR:
            now.hour();
    }

    public String currentTime() {
        return createSentence(now.hour(), now.minute());
    }

    private String createSentence(int hour, int minute) {
        String sentence = START_OF_SENTENCE;
        String hourPart;
        String minutePart = "";

        if (onTheHour(minute)) {
            hourPart = noonOrMidnight(hour, minute) ?
                ConversationalHour.wordFor(hour):
                ConversationalHour.wordFor(hour) + O_CLOCK;
        } else {
            hourPart = ConversationalHour.wordFor(nearestHour);
            minutePart = ConversationalMinute.wordFor(minute) + SPACE;
        }
        return sentence + minutePart + hourPart;
    }

    private boolean noonOrMidnight(int hour, int minute) {
        return (hour == 0 || hour == 12) && minute == 0;
    }

    private boolean onTheHour(int minute) {
        return minute == 0;
    }
}
