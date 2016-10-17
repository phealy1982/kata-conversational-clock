package serenitylabs.tutorials;

public class ConversationalClock {

    private final SystemTime time;

    public ConversationalClock(SystemTime time) {
        this.time = time;
    }

    public String currentTime() {
        return CreateTimeSentence.with(time);
    }
}
