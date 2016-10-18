package serenitylabs.tutorials.time;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by 66515 on 17/10/2016.
 */
public enum RelationToHour {
    ON_THE_HOUR, PAST_THE_HOUR, TO_THE_HOUR;

    private static final NavigableMap<Integer, RelationToHour> MINUTE_TO_HOUR_RELATIONSHIP = new TreeMap();

    static {
        MINUTE_TO_HOUR_RELATIONSHIP.put(0, ON_THE_HOUR);
        MINUTE_TO_HOUR_RELATIONSHIP.put(3, PAST_THE_HOUR);
        MINUTE_TO_HOUR_RELATIONSHIP.put(31, TO_THE_HOUR);
        MINUTE_TO_HOUR_RELATIONSHIP.put(58, ON_THE_HOUR);
    }

    public static RelationToHour forMinute(Integer minute) {
        Integer floorKey = MINUTE_TO_HOUR_RELATIONSHIP.floorKey(minute);
        return MINUTE_TO_HOUR_RELATIONSHIP.get(floorKey);
    }
}
