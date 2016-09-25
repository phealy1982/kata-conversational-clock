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
            "1, one",
            "2, two",
            "13, thirteen",
            "27, twenty seven",
            "30, thirty",
            "37, thirty seven",
            "52, fifty two"
        }) public void should_know_word_for_minute(int minute, String word){
            assertThat(ConversationalMinute.wordFor(minute)).isEqualTo(word);
    }

}
