package serenitylabs.tutorials;

import java.util.StringJoiner;

import static serenitylabs.tutorials.Minute.wordFor;

/**
 * Created by 66515 on 17/10/2016.
 */
public class PastTheHourSentence implements TimeSentence {
    private static final String BEGINNING = "it's ";
    private static final String ENDING = ".";
    private static final String HOUR_PREFIX = "past";

    @Override
    public String thenCreateSentenceWith(SystemTime time) {
        return new StringJoiner(" ", BEGINNING, ENDING)
                .add(wordFor(time.minute()))
                .add(HOUR_PREFIX)
                .add(Hour.wordFor(time.hour()))
                .toString();
    }
}
