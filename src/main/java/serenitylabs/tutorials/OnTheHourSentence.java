package serenitylabs.tutorials;

import java.util.StringJoiner;

/**
 * Created by 66515 on 17/10/2016.
 */
public class OnTheHourSentence implements TimeSentence {
    private static final String BEGINNING = "it's ";
    private static final String O_CLOCK = " o'clock.";
    private static final String FULL_STOP = ".";

    @Override
    public String thenCreateSentenceWith(SystemTime time) {
        return noonOrMidnight(time) ?
                createSpecialCaseSentence(time) :
                new StringJoiner(" ", BEGINNING, O_CLOCK)
                .add(Hour.wordFor(time.hour()))
                .toString();
    }

    private Boolean noonOrMidnight(SystemTime time) {
        return (time.hour() == 0 || time.hour() == 12) && time.minute() == 0;
    }

    private String createSpecialCaseSentence(SystemTime time) {
        return new StringJoiner(" ", BEGINNING, FULL_STOP)
                .add(Hour.wordFor(time.hour()))
                .toString();
    }
}
