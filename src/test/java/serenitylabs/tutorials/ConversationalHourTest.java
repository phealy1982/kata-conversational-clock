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
public class ConversationalHourTest {

    @TestWith({
            "One, one",
            "Four, four",
            "Nine, nine",
    }) public void should_know_word_for_hour(ConversationalHour conversationalHour, String word){
            assertThat(conversationalHour.word()).isEqualTo(word);
    }

    @TestWith({
            "1, One",
            "6, Six",
            "18, Six",
    })
    public void should_know_hour_details_for_a_given_number(Integer number, ConversationalHour conversationalHour) throws Exception {
        assertThat(ConversationalHour.withNumber(number)).isEqualTo(conversationalHour);
    }

    @Test
    public void should_not_lookup_null_number() throws Exception {
        assertThat(ConversationalHour.withNumber(null)).isEqualTo(null);

    }

    @Test
    public void should_only_know_about_actual_hours() throws Exception {
        assertThat(ConversationalHour.withNumber(44)).isEqualTo(null);

    }
}
