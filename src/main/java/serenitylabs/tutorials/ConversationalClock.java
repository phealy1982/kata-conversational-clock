package serenitylabs.tutorials;

public class ConversationalClock {

    private static final int ONE_HOUR = 1;
    private static final String SPACE = " ";
    public static final String O_CLOCK = SPACE + "o'clock";
    public static final String START_OF_SENTENCE = "it's" + SPACE;
    private final SystemTime now;
    private final int nearestHour;
    private final Boolean onTheHour;
    private final Boolean noonOrMidnight;

    public ConversationalClock(SystemTime time) {
        this.now = time;
        this.nearestHour = nearestHour(this.now.minute());
        this.onTheHour = onTheHour(this.now.minute());
        this.noonOrMidnight = noonOrMidnight(this.now.hour(), this.now.minute());
    }

    private Boolean onTheHour(int minute) {
        return minute == 0;
    }

    private int nearestHour(int minute) {
        return minute > 30 ? now.hour() + ONE_HOUR : now.hour();
    }

    public String currentTime() {
        return createSentence(now.minute());
    }

    private String createSentence(int minute) {
        String sentence = START_OF_SENTENCE;
        String hourPart = ConversationalHour.wordFor(nearestHour);
        String minutePart = "";

        if (onTheHour && !noonOrMidnight) {
                hourPart += O_CLOCK;
        } else if(!onTheHour){
            minutePart = ConversationalMinute.wordFor(minute) + SPACE;
        }
        return sentence + minutePart + hourPart;
    }

    private boolean noonOrMidnight(int hour, int minute) {
        return (hour == 0 || hour == 12) && minute == 0;
    }
}
