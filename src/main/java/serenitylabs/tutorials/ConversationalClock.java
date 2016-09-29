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
        String sentence;

        if(onTheHourAndNotNoonOrMidnight(hour, minute)) {
            sentence = TimeSentence.withBeginning(START_OF_SENTENCE)
                    .withHour(ConversationalHour.wordFor(now.relativeHour()))
                    .andWithEnding(O_CLOCK + FULL_STOP).sentence();
        } else {
            sentence = TimeSentence.withBeginning(START_OF_SENTENCE)
                    .withMinute(now.minutePrefix() + SPACE + ConversationalMinute.wordFor(now.relativeMinute()))
                    .withHour(ConversationalHour.wordFor(now.relativeHour()))
                    .andWithEnding(O_CLOCK + FULL_STOP).sentence();
        }


        return sentence;
    }

    private boolean onTheHourAndNotNoonOrMidnight(int hour, int minute) {
        return (hour != MIDNIGHT_HOUR && hour != NOON_HOUR) && minute == 0;
    }
}
