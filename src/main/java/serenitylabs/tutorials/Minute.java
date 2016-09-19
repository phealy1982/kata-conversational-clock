package serenitylabs.tutorials;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by peterhealy on 19/09/2016.
 */
public enum Minute {

    One(1, "one"),
    Two(2, "two"),
    Three(3, "three"),
    Four(4, "four"),
    Five(5, "five"),
    Six(6, "six"),
    Seven(7, "seven"),
    Eight(8, "eight"),
    Nine(9, "nine"),
    Ten(10, "ten"),
    Eleven(11, "eleven"),
    Twelve(12, "twelve"),
    Thirteen(13, "thirteen"),
    Fourteen(14, "fourteen"),
    Fifteen(15, "quarter"),
    Sixteen(16, "sixteen"),
    Seventeen(17, "seventeen"),
    Eighteen(18, "eighteen"),
    Nineteen(19, "nineteen"),
    Twenty(20, "twenty"),
    TwentyOne(21, "twenty one"),
    TwentyTwo(22, "twenty two"),
    TwentyThree(23, "twenty three"),
    TwentyFour(24, "twenty four"),
    TwentyFive(25, "twenty five"),
    TwentySix(26, "twenty six"),
    TwentySeven(27, "twenty seven"),
    TwentyEight(28, "twenty eight"),
    TwentyNine(29, "twenty nine"),
    Thirty(30, "half"),
    ThirtyOne(31, "thirty one"),
    ThirtyTwo(32, "thirty two"),
    ThirtyThree(33, "thirty three"),
    ThirtyFour(34, "thirty four"),
    ThirtyFive(35, "thirty five"),
    ThirtySix(36, "thirty six"),
    ThirtySeven(37, "thirty seven"),
    ThirtyEight(38, "thirty eight"),
    ThirtyNine(39, "thirty nine"),
    Forty(40, "forty"),
    FortyOne(41, "forty one"),
    FortyTwo(42, "forty two"),
    FortyThree(43, "forty three"),
    FortyFour(44, "forty four"),
    FortyFive(45, "forty five"),
    FortySix(46, "forty six"),
    FortySeven(47, "forty seven"),
    FortyEight(48, "forty eight"),
    FortyNine(49, "forty nine"),
    Fifty(50, "fifty"),
    FiftyOne(51, "fifty one"),
    FiftyTwo(52, "fifty two"),
    FiftyThree(53, "fifty three"),
    FiftyFour(54, "fifty four"),
    FiftyFive(55, "fifty five"),
    FiftySix(56, "fifty six"),
    FiftySeven(57, "fifty seven"),
    FiftyEight(58, "fifty eight"),
    FiftyNine(59, "fifty nine"),
    Sixty(60, "fifty nine");

    public final Integer number;
    public final String word;

    Minute(Integer number, String word) {
        this.number = number;
        this.word = word;
    }

    private static final Map<Integer, Minute> NUMBER_TO_MINUTE_TRANSLATION = new LinkedHashMap<>();
    static {
        for (Minute minute : Minute.values()) {
            NUMBER_TO_MINUTE_TRANSLATION.put(minute.number, minute);
        }
    }

    public static Minute withNumber(Integer number) {
        return NUMBER_TO_MINUTE_TRANSLATION.get(number);
    }
}


