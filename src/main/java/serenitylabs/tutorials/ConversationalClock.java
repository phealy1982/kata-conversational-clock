package serenitylabs.tutorials;


public class ConversationalClock {


    private final RelativeTime now;

    public ConversationalClock(SystemTime time) {
        this.now = new RelativeTime(time);
    }

    public String currentTime() {
        return TimeSentence.representing(now);
    }
}
