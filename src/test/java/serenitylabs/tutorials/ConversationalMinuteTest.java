package serenitylabs.tutorials;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.time.ConversationalMinute;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 66515 on 17/10/2016.
 */
@RunWith(ZohhakRunner.class)
public class ConversationalMinuteTest {

    @TestWith({
            "10, ten",
            "11, ten",
            "12, ten",
            "13, quarter",
            "14, quarter",
            "15, quarter",
    })
    public void should_know_the_word_for_nearest_conversationally_significant_minute(Integer minute, String word) throws Exception {
        assertThat(ConversationalMinute.wordFor(minute)).isEqualTo(word);
    }
}