package serenitylabs.tutorials;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by peterhealy on 22/09/2016.
 */
@RunWith(ZohhakRunner.class)
public class ConversationalHourTest {

    @TestWith(
        {
            "1, one",
            "2, two",
            "13, one"
        }) public void should_know_word_for_hour(int hour, String word) throws Exception {
        ConversationalHour conversationalHour = new ConversationalHour();
        assertThat(conversationalHour.wordFor(hour)).isEqualTo(word);
    }
}
