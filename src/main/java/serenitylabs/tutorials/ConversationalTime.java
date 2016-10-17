package serenitylabs.tutorials;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 66515 on 17/10/2016.
 */
public class ConversationalTime {
    private static final Map<Integer, Integer> HOURS = new HashMap<>();

    static {
        HOURS.put(1,1);
        HOURS.put(13,1);
        HOURS.put(2,2);
        HOURS.put(14,2);
        HOURS.put(8,8);
        HOURS.put(20,8);
        HOURS.put(10,10);
        HOURS.put(22,10);
    }

    private final SystemTime systemTime;

    public ConversationalTime(SystemTime systemTime) {
        this.systemTime = systemTime;
    }

    public Integer hour() {
        return HOURS.get(systemTime.hour());
    }

    public Integer minute() {
        return 0;
    }
}
