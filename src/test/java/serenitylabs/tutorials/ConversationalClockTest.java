package serenitylabs.tutorials;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(ZohhakRunner.class)
public class ConversationalClockTest {

    @TestWith({
            "01:00, it's one o'clock",
            "02:00, it's two o'clock",
    })
    public void should_tell_the_time_on_the_hour(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    @TestWith({
        "01:27, it's just gone twenty five past one",
        "02:46, it's just gone quarter to three",
        "14:46, it's just gone quarter to three",
    })
    public void should_tell_the_time_with_accuracy_to_the_minute(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    @TestWith({
        "12:00, it's noon",
        "00:00, it's midnight",
        "00:27, it's just gone twenty five past midnight",
        "12:15, it's quarter past noon",
        "23:49, it's almost ten to midnight"
    })
    public void should_know_about_midnight_and_noon(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    @TestWith({
        "00:30, it's half past midnight",
        "13:15, it's quarter past one",
    })
    public void should_know_about_quarter_past_and_half_past(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    @TestWith({
        "14:35, it's twenty five to three",
        "15:25, it's twenty five past three",
        "23:50, it's ten to midnight",
    })
    public void should_know_difference_between_past_the_hour_and_to_the_hour(ConversationalClock clock, String expectedTime){
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    /**
     * Creates an instance of a ConversationalClock, set to a requiredTime
     *
     * @link https://github.com/piotrturski/zohhak/blob/master/Full-Guide.md
     *
     * @param requiredTime Time in the "HH:mm" format (for example "17:15") coming from the @TestWith
     * @return an instance of a ConversationalClock, set to a requiredTime
     */
    @Coercion
    public ConversationalClock clockSetTo(String requiredTime) {
        HourAndMinute time = new HourAndMinute(requiredTime);

        // TODO: how can you control the time?
        SystemTime systemTime = mock(SystemTime.class);
        when(systemTime.hour()).thenReturn(time.hour());
        when(systemTime.minute()).thenReturn(time.minute());

        return new ConversationalClock(systemTime);
    }
}
