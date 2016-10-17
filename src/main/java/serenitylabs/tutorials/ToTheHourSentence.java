package serenitylabs.tutorials;

import java.util.StringJoiner;

import static serenitylabs.tutorials.Minute.*;

/**
 * Created by 66515 on 17/10/2016.
 */
public class ToTheHourSentence implements TimeSentence {


    public static final String BEGINNING = "it's ";
    public static final String HOUR_PREFIX = "to";
    public static final String ENDING = ".";

    @Override
    public String thenCreateSentenceWith(SystemTime time) {
        return new StringJoiner(" ", BEGINNING, ENDING)
                .add(wordFor(minutesToTheHour(time)))
                .add(HOUR_PREFIX)
                .add(Hour.wordFor(nextHour(time)))
                .toString();
    }

    private int nextHour(SystemTime time) {
        return time.hour() + 1;
    }

    private int minutesToTheHour(SystemTime time) {
        return 60 - time.minute();
    }
}
