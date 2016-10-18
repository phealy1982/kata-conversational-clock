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
    public static final String IRON_MAIDEN_TIME = "it's two!! minutes to midnight!!!!";

    static {
        SENTENCES.put(RelationToHour.ON_THE_HOUR, new OnTheHourSentence());
        SENTENCES.put(RelationToHour.PAST_THE_HOUR, new PastTheHourSentence());
        SENTENCES.put(RelationToHour.TO_THE_HOUR, new ToTheHourSentence());
    }


    public static String with(SignificantTime time) {
        return isTwoMinutesToMidnight(time) ?
                ironMaidenEasterEgg() :
                getSentenceTypeFor(time).thenCreateSentenceWith(time);
    }

    private static String ironMaidenEasterEgg() {
            return IRON_MAIDEN_TIME;
    }

    private static boolean isTwoMinutesToMidnight(SignificantTime time) {
        return time.hour() == 24 && time.minute() == 58;
    }

    private static Sentence getSentenceTypeFor(SignificantTime time) {
        return SENTENCES.get(RelationToHour.forMinute(time.minute()));
    }
}
