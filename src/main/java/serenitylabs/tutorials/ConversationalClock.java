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
        return constructTimeSentence();
    }

    private String constructTimeSentence() {
        if(onTheHour()){
            return constructOnTheHourSentence(ConversationalHour.withNumber(now.hour()), ConversationalMinute.withNumber(now.minute()));
        }

        if(pastTheHalfHour()){
            return constructBeforeTheHalfHourSentence(ConversationalHour.withNumber(now.hour() + ONE_HOUR), ConversationalMinute.withNumber(now.minute()));
        }

        return constructBeforeTheHalfHourSentence(ConversationalHour.withNumber(now.hour()), ConversationalMinute.withNumber(now.minute()));
    }

    private Boolean pastTheHalfHour() {
        return now.minute() > HALF_HOUR;
    }

    public Boolean isMidnight(ConversationalHour conversationalHour) {
        return conversationalHour == ConversationalHour.Midnight;
    }

    public Boolean isNoon(ConversationalHour conversationalHour) {
        return conversationalHour == ConversationalHour.Noon;
    }

    private String constructBeforeTheHalfHourSentence(ConversationalHour conversationalHour, ConversationalMinute conversationalMinute) {
        return constructPastTheHalfHourSentence(conversationalHour, conversationalMinute);
    }

    private String constructOnTheHourSentence(ConversationalHour conversationalHour, ConversationalMinute conversationalMinute) {
        if (isMidnight(conversationalHour) || isNoon(conversationalHour)) {
            return constructSentence(conversationalHour.word());
        }

        return constructSentence(conversationalHour.word(), conversationalMinute.words());
    }

    private String constructPastTheHalfHourSentence(ConversationalHour conversationalHour, ConversationalMinute conversationalMinute) {
        return constructSentence(conversationalMinute.words(), conversationalHour.word());
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
