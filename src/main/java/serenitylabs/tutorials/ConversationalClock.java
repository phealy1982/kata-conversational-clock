package serenitylabs.tutorials;

public class ConversationalClock {

    private final SystemTime now;

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    public String currentTime() {
         if (now.hour() == 1){
             return "it's one o'clock";
        } else if (now.hour() == 2){
             return "it's two o'clock";
         } else return null;
    }
}
