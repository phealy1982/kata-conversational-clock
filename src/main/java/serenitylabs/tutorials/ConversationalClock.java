package serenitylabs.tutorials;


public class ConversationalClock {

    private static final String SPACE = " ";
    public static final String START_OF_SENTENCE = "it's";
    private static final String FULL_STOP = ".";
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

        if(noonOrMidnight(hour, minute)) {
            sentence = TimeSentence.withBeginning(START_OF_SENTENCE)
                    .andHour(ConversationalHour.wordFor(now.relativeHour()))
                    .andWithEnding(FULL_STOP).sentence();
        } else if(onTheHour(minute)){
            sentence = TimeSentence.withBeginning(START_OF_SENTENCE)
                    .andHour(ConversationalHour.wordFor(now.relativeHour()))
                    .andWithOClockEnding().sentence();
        } else {
            sentence = TimeSentence.withBeginning(START_OF_SENTENCE)
                    .andMinute(now.minutePrefix() + SPACE + ConversationalMinute.wordFor(now.relativeMinute()))
                    .andHour(now.hourPrefix() + SPACE + ConversationalHour.wordFor(now.relativeHour()))
                    .andWithEnding(FULL_STOP).sentence();
        }
        return sentence;
    }

    private boolean onTheHour(int minute) {
        return minute == 0;
    }

    private boolean noonOrMidnight(int hour, int minute) {
        return (hour == MIDNIGHT_HOUR || hour == NOON_HOUR) && minute == 0;
    }
}
