package serenitylabs.tutorials;

/**
 * Created by 66515 on 18/10/2016.
 */
public class SignificantTime {
    private final Integer hour;
    private final Integer minute;


    public SignificantTime(SystemTime time) {
        this.hour = closestHour(time);
        this.minute = time.minute();
    }

    public Integer hour() {
        return this.hour;
    }

    public Integer minute() {
        return this.minute;
    }

    private Integer closestHour(SystemTime time) {
        return time.minute() > 30 ?
                time.hour() + 1 :
                time.hour();
    }
}
