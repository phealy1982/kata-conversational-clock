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
            "5, five",
            "10, ten",
            "15, quarter",
            "20, twenty",
            "25, twenty five",
            "30, half",
        }) public void should_know_word_for_significant_minute(int minute, String word){
        assertThat(ConversationalMinute.wordFor(minute)).isEqualTo(word);
    }

}
