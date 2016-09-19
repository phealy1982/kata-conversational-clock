package serenitylabs.tutorials;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 66515 on 19/09/2016.
 */
public enum Hour {
    Zero(0,"zero"), One(1, "one"), Two(2, "two"), Three(3, "three"), Four(4, "four"),
    Five(5, "five"), Six(6, "six"), Seven(7, "seven"), Eight(8, "eight"), Nine(9,"nine"),
    Ten(10, "ten"), Eleven(11, "eleven"), Twelve(12, "twelve"), Thirteen(13,"one"),
    Fourteen(14, "two"), Fifteen(15, "three"), Sixteen(16, "four"), Seventeen(17, "five"),
    Eighteen(18, "six"), Nineteen(19, "seven"), Twenty(20, "eight"), TwentyOne(21, "nine"),
    TwentyTwo(22, "ten"), TwentyThree(23, "eleven");

    public final Integer number;
    public final String word;

    Hour(Integer number, String word) {
        this.number=number;
        this.word=word;
    }

    private static final Map<Integer, Hour> NUMBER_TO_HOUR_TRANSLATION = new LinkedHashMap<>();
    static {
        for (Hour hour : Hour.values()) {
            NUMBER_TO_HOUR_TRANSLATION.put(hour.number, hour);
        }
    }

    public static Hour withNumber(Integer number) {
        return NUMBER_TO_HOUR_TRANSLATION.get(number);
    }
}