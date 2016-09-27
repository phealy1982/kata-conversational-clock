package serenitylabs.tutorials;


public class ConversationalClock {

    private static final String SPACE = " ";
    public static final String O_CLOCK = SPACE + "o'clock";
    public static final String START_OF_SENTENCE = "it's" + SPACE;
    private static final String FULL_STOP = ".";
    private static final String TWO_SPACES = "  ";
    public static final int MIDNIGHT_HOUR = 0;
    public static final int NOON_HOUR = 12;
    private final RelativeTime now;

    public ConversationalClock(SystemTime time) {
        this.now = new RelativeTime(time);
    }

    public String currentTime() {
        return createSentence(now.hour(), now.minute());
    }

    private String createSentence(int hour, int minute) {
        StringBuilder sentence = new StringBuilder();
        sentence.append(START_OF_SENTENCE);

        if(!now.onTheHour()) {
            sentence.append(now.minutePrefix());
            sentence.append(SPACE);
            sentence.append(ConversationalMinute.wordFor(now.relativeMinute()));
            sentence.append(SPACE);
            sentence.append(now.hourPrefix());
        }

        sentence.append(SPACE);
        sentence.append(ConversationalHour.wordFor(now.relativeHour()));
        sentence.append(sentenceEnding(hour, minute));

        return sentence.toString().replace(TWO_SPACES, SPACE);
    }

    private String sentenceEnding(int hour, int minute) {
        return onTheHourAndNotNoonOrMidnight(hour, minute) ?
                O_CLOCK + FULL_STOP:
                FULL_STOP;
    }

    private boolean onTheHourAndNotNoonOrMidnight(int hour, int minute) {
        return (hour != MIDNIGHT_HOUR && hour != NOON_HOUR) && minute == 0;
    }
}
