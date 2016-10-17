package serenitylabs.tutorials;

public class ConversationalClock {

    private final SystemTime time;


    public ConversationalClock(SystemTime time) {
        this.time = time;
    }

    public String currentTime() {
        return new TimeSentence().with(time.hour(), time.minute());
    }
}
