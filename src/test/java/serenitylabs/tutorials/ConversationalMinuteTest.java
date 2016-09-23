package serenitylabs.tutorials;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by peterhealy on 19/09/2016.
 */
@RunWith(ZohhakRunner.class)
public class ConversationalMinuteTest {

    @TestWith({
            "1, just gone",
            "11, just gone ten past",
            "14, almost quarter past",
            "15, quarter past",
            "31, just gone half past",
            "53, almost five to",
            "54, almost five to",
    })
    public void should_know_closest_conversational_sentence_for_a_minute(Integer number, String words) throws Exception {
        assertThat(ConversationalMinute.withNumber(number).words()).isEqualTo(words);
    }

    @Test
    public void should_be_aware_of_all_minutes() throws Exception {
        assertThat(numericRepresentationsOf(ConversationalMinute.values())).containsAll(range(0, 60));
    }

    private Iterable<Integer> range(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int minute = start; minute < end; minute++) {
            list.add(minute);
        }
        return list;
    }

    private List<Integer> numericRepresentationsOf(ConversationalMinute[] minutes) {
        List<Integer> minutesInConversationalMinutes = new ArrayList<>();
        for (ConversationalMinute conversationalMinute : minutes) {
            for (Integer minute : conversationalMinute.numericRepresentations()) {
                minutesInConversationalMinutes.add(minute);
            }
        }
        return minutesInConversationalMinutes;
    }
}
