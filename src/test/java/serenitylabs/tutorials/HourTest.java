package serenitylabs.tutorials;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by 66515 on 19/09/2016.
 */
@RunWith(ZohhakRunner.class)
public class HourTest {

    @TestWith({
            "One, 1, one",
            "Four, 4, four",
            "Fifteen, 15, three",
    }) public void should_know_number_and_word_for_hour(Hour hour, Integer number, String word){
        assertThat(hour.number()).isEqualTo(number);
        assertThat(hour.word()).isEqualTo(word);
    }

    @TestWith({
            "1, One",
            "6, Six",
            "13, Thirteen",
    })
    public void should_know_hour_details_for_a_given_number(Integer number, Hour hour) throws Exception {
        assertThat(Hour.withNumber(number)).isEqualTo(hour);
    }
}
