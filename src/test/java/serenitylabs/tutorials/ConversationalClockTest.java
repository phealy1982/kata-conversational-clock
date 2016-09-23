package serenitylabs.tutorials;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ZohhakRunner.class)
public class ConversationalClockTest {

    @TestWith({
            "01:00, it's one o'clock",
            "07:00, it's seven o'clock",
            "09:00, it's nine o'clock",
            "13:00, it's one o'clock",
            "17:00, it's five o'clock",
            "21:00, it's nine o'clock",
    })
    public void should_tell_the_time_on_the_hour(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    @TestWith({
        "00:00, it's midnight",
        "01:15, it's quarter past one",
        "07:27, it's just gone twenty five past seven",
        "09:59, it's almost ten",
        "12:00, it's noon",
        "12:01, it's just gone noon",
        "14:43, it's almost quarter to three",
        "14:45, it's quarter to three",
        "14:46, it's just gone quarter to three",
        "14:01, it's just gone two",
        "19:30, it's half past seven",
        "20:50, it's ten to nine"
    })
    public void should_tell_the_time_when_past_the_hour(ConversationalClock clock, String expectedTime) throws Exception {
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
        SystemTime systemTime = new SystemTime(LocalTime.of(time.hour(), time.minute()));

        return new ConversationalClock(systemTime);
    }
}
