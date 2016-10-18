package serenitylabs.tutorials.sentence;

import serenitylabs.tutorials.time.ConversationalHour;
import serenitylabs.tutorials.SignificantTime;

import java.util.StringJoiner;

import static serenitylabs.tutorials.time.ConversationalMinute.prefix;
import static serenitylabs.tutorials.time.ConversationalMinute.wordFor;

/**
 * Created by 66515 on 17/10/2016.
 */
public class PastTheHourSentence implements Sentence {
    private static final String BEGINNING = "it's ";
    private static final String ENDING = ".";
    private static final String HOUR_PREFIX = "past";

    @Override
    public String thenCreateSentenceWith(SignificantTime time) {
        return new StringJoiner(" ", BEGINNING, ENDING)
                .add(prefix(time.minute()))
                .add(wordFor(time.minute()))
                .add(HOUR_PREFIX)
                .add(ConversationalHour.wordFor(time.hour()))
                .toString()
                .replaceAll("\\s+", " ");
    }
}
