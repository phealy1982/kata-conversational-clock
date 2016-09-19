package serenitylabs.tutorials;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.assertj.core.api.StrictAssertions;
import org.junit.runner.RunWith;


import static org.assertj.core.api.Assertions.assertThat;



/**
 * Created by peterhealy on 19/09/2016.
 */
@RunWith(ZohhakRunner.class)
public class MinuteTest {


    @TestWith({
        "One, 1, one",
        "Four, 4, four",
        "Fifteen, 15, quarter",
        "Thirty, 30, half",
    })  public void should_know_number_and_word_for_minute(Minute minute, Integer number, String word)throws Exception{
        assertThat(minute.word).isEqualTo(word);
        assertThat(minute.number).isEqualTo(number);
    }

    @TestWith({
        "1, One",
        "6, Six",
        "13, Thirteen",
    })
    public void should_know_minute_details_for_a_given_number(Integer number, Minute minute) throws Exception {
        StrictAssertions.assertThat(Minute.withNumber(number)).isEqualTo(minute);
    }
}
