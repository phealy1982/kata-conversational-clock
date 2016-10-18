package serenitylabs.tutorials.sentence;

import serenitylabs.tutorials.SignificantTime;
import serenitylabs.tutorials.time.RelationToHour;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 66515 on 17/10/2016.
 */
public class CreateTimeSentence {

    private static final Map<RelationToHour, Sentence> SENTENCES = new HashMap<>();

    static {
        SENTENCES.put(RelationToHour.ON_THE_HOUR, new OnTheHourSentence());
        SENTENCES.put(RelationToHour.PAST_THE_HOUR, new PastTheHourSentence());
        SENTENCES.put(RelationToHour.TO_THE_HOUR, new ToTheHourSentence());
    }

    public static String with(SignificantTime time) {
        return getSentenceTypeFor(time).thenCreateSentenceWith(time);
    }

    private static Sentence getSentenceTypeFor(SignificantTime time) {
        return SENTENCES.get(RelationToHour.forMinute(time.minute()));
    }
}
