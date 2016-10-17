package serenitylabs.tutorials;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by 66515 on 29/09/2016.
 */
public class TimeSentenceTest {

    @Test
    public void should_have_a_beginning_and_ending() throws Exception {
        TimeSentence sentence = TimeSentence.withHour("nine").andWithEnding(".");
        assertThat(sentence.sentence()).startsWith("it's nine").endsWith(".");
    }

    @Test
    public void should_allow_for_a_minute_part() throws Exception {
        TimeSentence sentence = TimeSentence.withHour("noon").andMinute("twenty five past").andWithEnding(".");
        assertThat(sentence.sentence()).isEqualTo("it's twenty five past noon.");
    }
}
