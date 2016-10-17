package serenitylabs.tutorials;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(ZohhakRunner.class)
public class ConversationalClockTest {

    @TestWith({
            "01:00, it's one o'clock.",
            "02:00, it's two o'clock.",
            "20:00, it's eight o'clock.",
            "22:00, it's ten o'clock.",
    })
    public void should_tell_the_time_on_the_hour(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    @TestWith({
            "01:10, it's ten past one.",
            "02:20, it's twenty past two.",
            "02:15, it's quarter past two.",
            "20:30, it's half past eight.",
    })
    public void should_tell_the_time_past_the_hour(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    @TestWith({
            "01:50, it's ten to two.",
            "02:40, it's twenty to three.",
            "19:45, it's quarter to eight.",
    })
    public void should_tell_the_time_to_the_hour(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    @TestWith({
            "11:40, it's twenty to noon.",
            "12:00, it's noon.",
            "12:20, it's twenty past noon.",
    })
    public void should_know_about_noon(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    @TestWith({
            "23:40, it's twenty to midnight.",
            "00:00, it's midnight.",
            "00:20, it's twenty past midnight.",
    })
    public void should_know_about_midnight(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    /**
     * Creates an instance of a ConversationalClock, set to a requiredTime
     *
     * @param requiredTime Time in the "HH:mm" format (for example "17:15") coming from the @TestWith
     * @return an instance of a ConversationalClock, set to a requiredTime
     * @link https://github.com/piotrturski/zohhak/blob/master/Full-Guide.md
     */
    @Coercion
    public ConversationalClock clockSetTo(String requiredTime) {
        HourAndMinute time = new HourAndMinute(requiredTime);

        SystemTime mockSystemTime = mock(SystemTime.class);
        when(mockSystemTime.hour()).thenReturn(time.hour());
        when(mockSystemTime.minute()).thenReturn(time.minute());

        return new ConversationalClock(mockSystemTime);
    }
}
