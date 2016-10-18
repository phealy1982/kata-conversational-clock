package serenitylabs.tutorials.sentence;

import serenitylabs.tutorials.time.ConversationalHour;
import serenitylabs.tutorials.SignificantTime;

import java.util.StringJoiner;

import static serenitylabs.tutorials.time.ConversationalMinute.*;

/**
 * Created by 66515 on 17/10/2016.
 */
public class OnTheHourSentence implements Sentence {
    private static final String BEGINNING = "it's ";
    private static final String O_CLOCK = " o'clock.";
    private static final String FULL_STOP = ".";

    @Override
    public String thenCreateSentenceWith(SignificantTime time) {
        String ending = noonOrMidnight(time) ? FULL_STOP : O_CLOCK;
        return new StringJoiner(" ", BEGINNING, ending)
                .add(prefix(time.minute()))
                .add(ConversationalHour.wordFor(time.hour()))
                .toString()
                .replaceAll("\\s+", " ");
    }

    private Boolean noonOrMidnight(SignificantTime time) {
        return (time.hour() == 0 || time.hour() == 12  || time.hour() == 24);
    }
}
