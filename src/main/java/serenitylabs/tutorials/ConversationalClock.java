package serenitylabs.tutorials;

public class ConversationalClock {

    private final TimeSentence timeSentence;
    private final ConversationalTime conversationalTime;

    public ConversationalClock(SystemTime time, TimeSentence timeSentence) {
        this.conversationalTime = new ConversationalTime(time);
        this.timeSentence = timeSentence;
    }

    public String currentTime() {
        return timeSentence.sentenceWith(conversationalTime.hour(), conversationalTime.minute());
    }
}
