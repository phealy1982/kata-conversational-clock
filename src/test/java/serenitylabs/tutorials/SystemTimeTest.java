package serenitylabs.tutorials;


import org.junit.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 66515 on 19/09/2016.
 */
public class SystemTimeTest {

    @Test
    public void should_should_be_able_to_set_the_time() throws Exception {
        SystemTime systemTime = new SystemTime(LocalTime.MIDNIGHT);
        assertThat(systemTime.now()).isEqualTo(LocalTime.MIDNIGHT);
    }
}