package serenitylabs.tutorials.sentence;

import serenitylabs.tutorials.time.ConversationalHour;
import serenitylabs.tutorials.SignificantTime;

import java.util.StringJoiner;

import static serenitylabs.tutorials.time.ConversationalMinute.*;

/**
 * Created by 66515 on 17/10/2016.
 */
public class ToTheHourSentence implements Sentence {


    public static final String BEGINNING = "it's ";
    public static final String HOUR_PREFIX = "to";
    public static final String ENDING = ".";

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
