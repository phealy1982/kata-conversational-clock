package serenitylabs.tutorials;

public class ConversationalClock {

    public static final String IT_IS = "it's";
    public static final int ONE_HOUR = 1;
    private static final int HALF_HOUR = 30;
    public static final int ON_THE_HOUR = 0;
    private final SystemTime now;

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    public String currentTime() {
        return isMidnight() || isNoon() ?
                constructNoonOrMidnightSentence() :
                constructTimeSentence();
    }

    private String constructTimeSentence() {
        return pastTheHalfHour() ?
                constructPastTheHalfHourSentence() :
                constructBeforeTheHalfHourSentence();
    }

    private Boolean pastTheHalfHour() {
        return now.minute() > HALF_HOUR;
    }

    public Boolean isMidnight() {
        return ConversationalHour.withNumber(now.hour()) == ConversationalHour.Midnight;
    }

    public Boolean isNoon() {
        return ConversationalHour.withNumber(now.hour()) == ConversationalHour.Noon;
    }

    private String constructBeforeTheHalfHourSentence() {
        return onTheHour() ?
                constructSentence(ConversationalHour.withNumber(now.hour()).word(), ConversationalMinute.withNumber(now.minute()).words()):
                constructSentence(ConversationalMinute.withNumber(now.minute()).words(), ConversationalHour.withNumber(now.hour()).word());
    }

    private String constructPastTheHalfHourSentence() {
        return constructSentence(ConversationalMinute.withNumber(now.minute()).words(), ConversationalHour.withNumber(now.hour() + ONE_HOUR).word());
    }

    private String constructNoonOrMidnightSentence() {
        return onTheHour() ?
                constructSentence(ConversationalHour.withNumber(now.hour()).word()) :
                constructSentence(ConversationalMinute.withNumber(now.minute()).words(), ConversationalHour.withNumber(now.hour()).word());
    }

    private boolean onTheHour() {
        return now.minute() == ON_THE_HOUR;
    }

    private String constructSentence(String... sentenceParts) {
        String sentence = IT_IS;
        for (String sentencePart : sentenceParts) {
            sentence = sentence + " " + sentencePart;
        }
        return sentence;
    }
}
