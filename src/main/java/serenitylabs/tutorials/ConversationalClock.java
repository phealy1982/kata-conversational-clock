package serenitylabs.tutorials;


public class ConversationalClock {

    private static final int ONE_HOUR = 1;
    private static final String SPACE = " ";
    public static final String O_CLOCK = SPACE + "o'clock";
    public static final String START_OF_SENTENCE = "it's" + SPACE;
    private static final String FULL_STOP = ".";
    private static final String TWO_SPACES = "  ";
    private final SystemTime now;

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    public String currentTime() {
        return createSentence(now.hour(), now.minute());
    }

    private String createSentence(int hour, int minute) {
        StringBuilder sentence = new StringBuilder();
        sentence.append(START_OF_SENTENCE);
        sentence.append(ConversationalMinute.wordFor(minute));
        sentence.append(SPACE);
        sentence.append(ConversationalHour.wordFor(nearestHourBasedOnMinute(minute)));
        sentence.append(sentenceEnding(hour, minute));

        return sentence.toString().replace(TWO_SPACES, SPACE);
    }

    private String sentenceEnding(int hour, int minute) {
        return onTheHourAndNotNoonOrMidnight(hour, minute) ?
                O_CLOCK + FULL_STOP:
                FULL_STOP;
    }

    private int nearestHourBasedOnMinute(int minute) {
        return minute > 30 ? now.hour() + ONE_HOUR : now.hour();
    }

    private boolean onTheHourAndNotNoonOrMidnight(int hour, int minute) {
        return (hour != 0 && hour != 12) && minute == 0;
    }
}
