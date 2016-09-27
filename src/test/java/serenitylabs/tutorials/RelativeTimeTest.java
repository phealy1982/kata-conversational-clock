package serenitylabs.tutorials;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by 66515 on 27/09/2016.
 */
@RunWith(ZohhakRunner.class)
public class RelativeTimeTest {

    @TestWith({
            "01:10, 1",
            "02:40, 3",
    })
    public void should_know_hour_relative_to_minute(SystemTime systemTime, int hour) throws Exception {

        RelativeTime relativeTime = new RelativeTime(systemTime);

        assertThat(relativeTime.relativeHour()).isEqualTo(hour);

    }

    @Test
    public void should_tell_current_time() throws Exception {
        SystemTime systemTime = mock(SystemTime.class);
        when(systemTime.hour()).thenReturn(1,2);

        RelativeTime relativeTime = new RelativeTime(systemTime);

        assertThat(relativeTime.relativeHour()).isEqualTo(1);
        assertThat(relativeTime.relativeHour()).isEqualTo(2);

    }

    @TestWith({
            "01:10, false",
            "02:00, true",
    })
    public void should_know_if_on_the_hour(SystemTime systemTime, Boolean onTheHour) throws Exception {
        RelativeTime relativeTime = new RelativeTime(systemTime);
        assertThat(relativeTime.onTheHour()).isEqualTo(onTheHour);
    }

    @TestWith({
            "01:37, 25",
            "02:51, 10",
    })
    public void should_know_significant_minute_relative_to_hour(SystemTime systemTime, int minute) throws Exception {
        RelativeTime relativeTime = new RelativeTime(systemTime);
        assertThat(relativeTime.relativeMinute()).isEqualTo(minute);
    }

    @TestWith({
            "01:39, almost",
            "02:51, just gone",
            "02:10, "
    })
    public void should_know_minute_prefix(SystemTime systemTime, String prefix) throws Exception {
        RelativeTime relativeTime = new RelativeTime(systemTime);
        assertThat(relativeTime.minutePrefix()).isEqualTo(prefix);
    }

    @TestWith({
            "01:39, to",
            "02:51, to",
            "02:10, past"
    })
    public void should_know_hour_prefix(SystemTime systemTime, String prefix) throws Exception {
        RelativeTime relativeTime = new RelativeTime(systemTime);
        assertThat(relativeTime.hourPrefix()).isEqualTo(prefix);
    }

    @Coercion
    public SystemTime systemTimeSetTo(String requiredTime) {
        HourAndMinute time = new HourAndMinute(requiredTime);

        // TODO: how can you control the time?
        SystemTime systemTime = mock(SystemTime.class);
        when(systemTime.hour()).thenReturn(time.hour());
        when(systemTime.minute()).thenReturn(time.minute());

        return systemTime;
    }
}
