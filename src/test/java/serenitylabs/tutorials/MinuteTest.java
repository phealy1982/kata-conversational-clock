package serenitylabs.tutorials;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 66515 on 17/10/2016.
 */
@RunWith(ZohhakRunner.class)
public class MinuteTest {

    @TestWith({
            "12, ten",
    })
    public void should_know_the_word_for_nearest_conversationally_significant_minute(Integer minute, String word) throws Exception {
        assertThat(Minute.wordFor(minute)).isEqualTo(word);
    }
}