package serenitylabs.tutorials;

import org.apache.commons.lang3.Range;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by 66515 on 17/10/2016.
 */
public enum RelationToHour {
    ON_THE_HOUR, PAST_THE_HOUR, TO_THE_HOUR;

    private static final NavigableMap<Integer,RelationToHour> minuteToHourRelationship = new TreeMap();

    static {
        minuteToHourRelationship.put(0, ON_THE_HOUR);
        minuteToHourRelationship.put(1, PAST_THE_HOUR);
        minuteToHourRelationship.put(31, TO_THE_HOUR);
    }

    static RelationToHour forMinute(Integer minute) {
        Integer floorKey = minuteToHourRelationship.floorKey(minute);
        return minuteToHourRelationship.get(floorKey);
    }
}
