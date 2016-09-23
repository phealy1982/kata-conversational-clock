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

    public static final List<Integer> ALL_MINUTES = allMinutes();

    @TestWith({
        "1, just gone",
        "11, just gone ten past",
        "14, almost quarter past",
        "15, quarter past",
        "31, just gone half past",
        "53, almost five to",
        "54, almost five to",
    })  public void should_know_closest_conversational_sentence_for_a_minute(Integer number, String word)throws Exception{
        assertThat(ConversationalMinute.withNumber(number).words()).isEqualTo(word);
    }

    @Test
    public void should_be_aware_of_all_minutes() throws Exception {

        List<Integer> minutesInConversationalMinutes = new ArrayList<>();
        for(ConversationalMinute conversationalMinute : ConversationalMinute.values()){
            for(Integer minute: conversationalMinute.numericRepresentations()){
                minutesInConversationalMinutes.add(minute);
            }
        }

        assertThat(minutesInConversationalMinutes).containsAll(ALL_MINUTES);
    }

    private static List<Integer> allMinutes() {
        List<Integer> allMinutes = new ArrayList<>();
        for(Integer minute=0; minute <60; minute ++){
            allMinutes.add(minute);
        }
        return  allMinutes;
    }
}
