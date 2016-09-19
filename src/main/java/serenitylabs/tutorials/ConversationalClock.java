package serenitylabs.tutorials;

public class ConversationalClock {

    private final SystemTime now;

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    public String currentTime() {
        return onTheHour() ?
            timeOnTheHour() :
            timePastTheHour();
    }

    private String timePastTheHour() {
        return pastTheHalfHour() ?
            "it's " + Minute.withNumber(Minute.Sixty.number() - now.minute()).word() + " to " + Hour.withNumber(now.hour() + 1).word() :
            "it's " + Minute.withNumber(now.minute()).word() + " past " + Hour.withNumber(now.hour()).word();
    }

    private Boolean pastTheHalfHour() {
        return now.minute() > Minute.Thirty.number();
    }

    private String timeOnTheHour() {
        return isMidnight() || isNoon() ?
            "it's " + Hour.withNumber(now.hour()).word() :
            "it's " + Hour.withNumber(now.hour()).word()  + " o'clock";
    }

    private Boolean onTheHour() {
        return now.minute() == 0;
    }

    public Boolean isMidnight() {
        return now.hour() == Hour.Zero.number();
    }

    public Boolean isNoon() {
        return now.hour() == Hour.Twelve.number();
    }
}
