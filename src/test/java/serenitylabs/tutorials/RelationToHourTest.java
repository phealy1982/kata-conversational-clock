package serenitylabs.tutorials;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 66515 on 17/10/2016.
 */
@RunWith(ZohhakRunner.class)
public class RelationToHourTest {

    @TestWith({
            "1, PAST_THE_HOUR",
            "24, PAST_THE_HOUR",
            "30, PAST_THE_HOUR",
    })
    public void should_know_a_minute_is_referred_to_as_past_the_hour(Integer minute, RelationToHour relationToHour) throws Exception {
        assertThat(RelationToHour.forMinute(minute)).isEqualTo(relationToHour);
    }

    @TestWith({
            "31, TO_THE_HOUR",
            "47, TO_THE_HOUR",
            "59, TO_THE_HOUR",
    })
    public void should_know_a_minute_is_referred_to_as_to_the_hour(Integer minute, RelationToHour relationToHour) throws Exception {
        assertThat(RelationToHour.forMinute(minute)).isEqualTo(relationToHour);
    }

    @TestWith({
            "0, ON_THE_HOUR",
    })
    public void should_know_a_minute_is_referred_to_as_on_the_hour(Integer minute, RelationToHour relationToHour) throws Exception {
        assertThat(RelationToHour.forMinute(minute)).isEqualTo(relationToHour);
    }
}