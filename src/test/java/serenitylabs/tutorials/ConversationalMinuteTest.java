package serenitylabs.tutorials;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.StrictAssertions.assertThat;


/**
 * Created by peterhealy on 25/09/2016.
 */
@RunWith(ZohhakRunner.class)
public class ConversationalMinuteTest {

    @TestWith(
        {
            "3, almost five past ",
            "7, just gone five past ",
            "13, almost quarter past ",
            "25, twenty five past ",
            "27, just gone twenty five past ",
            "33, almost twenty five to ",
            "46, just gone quarter to ",
            "51, just gone ten to "
        }) public void should_know_phrase_for_nearest_significant_minute(int minute, String word){
        assertThat(ConversationalMinute.wordFor(minute)).isEqualTo(word);
    }

}
