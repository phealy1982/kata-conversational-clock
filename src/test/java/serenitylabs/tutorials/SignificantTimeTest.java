package serenitylabs.tutorials;


import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by 66515 on 18/10/2016.
 */
@RunWith(ZohhakRunner.class)
public class SignificantTimeTest {

    @TestWith({
            "23:59, 24, 59",
            "02:10, 2, 10",
            "02:31, 3, 31",
    })
    public void should_know_closest_hour(SignificantTime time, Integer hour, Integer minute) throws Exception {
        assertThat(time.hour()).isEqualTo(hour);
        assertThat(time.minute()).isEqualTo(minute);
    }

    @Coercion
    public SignificantTime significantTimeWith(String requiredTime) {
        HourAndMinute time = new HourAndMinute(requiredTime);

        SystemTime mockSystemTime = mock(SystemTime.class);
        when(mockSystemTime.hour()).thenReturn(time.hour());
        when(mockSystemTime.minute()).thenReturn(time.minute());

        return new SignificantTime(mockSystemTime);
    }
}