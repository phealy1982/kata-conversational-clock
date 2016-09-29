package serenitylabs.tutorials;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by 66515 on 29/09/2016.
 */
public class TimeSentenceTest {

    @Test
    public void should_have_a_beginning_and_ending() throws Exception {
        TimeSentence sentence = TimeSentence.withBeginning("It's").andWithEnding(".");
        assertThat(sentence.sentence()).isEqualTo("It's.");
    }

    @Test
    public void should_allow_for_an_hour_part() throws Exception {
        TimeSentence sentence = TimeSentence.withBeginning("It's").withHour("noon").andWithEnding(".");
        assertThat(sentence.sentence()).isEqualTo("It's noon.");
    }

    @Test
    public void should_allow_for_a_minute_part() throws Exception {
        TimeSentence sentence = TimeSentence.withBeginning("It's").withHour("noon").withMinute("twenty five past").andWithEnding(".");
        assertThat(sentence.sentence()).isEqualTo("It's twenty five past noon.");
    }
}
