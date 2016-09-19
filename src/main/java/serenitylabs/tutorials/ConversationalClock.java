package serenitylabs.tutorials;

public class ConversationalClock {

    private final SystemTime now;

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    public String currentTime() {
        return "it's " + Hour.withNumber(now.hour()).word  + " o'clock";
    }
}
