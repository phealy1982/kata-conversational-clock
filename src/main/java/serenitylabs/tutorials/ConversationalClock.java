package serenitylabs.tutorials;

import serenitylabs.tutorials.sentence.CreateTimeSentence;

public class ConversationalClock {

    private final SignificantTime time;

    public ConversationalClock(SystemTime time) {
        this.time = new SignificantTime(time);
    }

    public String currentTime() {
        return CreateTimeSentence.with(time);
    }
}
