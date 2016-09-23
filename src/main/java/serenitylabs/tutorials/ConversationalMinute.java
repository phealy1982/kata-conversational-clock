package serenitylabs.tutorials;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peterhealy on 19/09/2016.
 */
public enum ConversationalMinute {
    O_CLOCK(0),
    JUST_GONE(1, 2),
    ALMOST_FIVE_PAST(3, 4),
    FIVE_PAST(5),
    JUST_GONE_FIVE_PAST(6, 7),
    ALMOST_TEN_PAST(8, 9),
    TEN_PAST(10),
    JUST_GONE_TEN_PAST(11, 12),
    ALMOST_QUARTER_PAST(13, 14),
    QUARTER_PAST(15),
    JUST_GONE_QUARTER_PAST(16, 17),
    ALMOST_TWENTY_PAST(18, 19),
    TWENTY_PAST(20),
    JUST_GONE_TWENTY_PAST(21, 22),
    ALMOST_TWENTY_FIVE_PAST(23, 24),
    TWENTY_FIVE_PAST(25),
    JUST_GONE_TWENTY_FIVE_PAST(26, 27),
    ALMOST_HALF_PAST(28, 29),
    HALF_PAST(30),
    JUST_GONE_HALF_PAST(31, 32),
    ALMOST_FIVE_TO(53, 54),
    FIVE_TO(55),
    JUST_GONE_FIVE_TO(56, 57),
    ALMOST_TEN_TO(48, 49),
    TEN_TO(50),
    JUST_GONE_TEN_TO(51, 52),
    ALMOST_QUARTER_TO(43, 44),
    QUARTER_TO(45),
    JUST_GONE_QUARTER_TO(46, 47),
    ALMOST_TWENTY_TO(38, 39),
    TWENTY_TO(40),
    JUST_GONE_TWENTY_TO(41, 42),
    ALMOST_TWENTY_FIVE_TO(33, 34),
    TWENTY_FIVE_TO(35),
    JUST_GONE_TWENTY_FIVE_TO(36, 37),
    ALMOST(58,59);

    private final List<Integer> numericRepresentations;

    ConversationalMinute(Integer... numbers) {
        this.numericRepresentations = Arrays.asList(numbers);
    }

    private static final Map<Integer, ConversationalMinute> NUMBER_TO_MINUTE_TRANSLATION = new LinkedHashMap<>();
    static {
        for (ConversationalMinute minute : ConversationalMinute.values()) {
            for(Integer number : minute.numericRepresentations){
                NUMBER_TO_MINUTE_TRANSLATION.put(number, minute);
            }
        }
    }

    public static ConversationalMinute withNumber(Integer number) {
        return NUMBER_TO_MINUTE_TRANSLATION.get(number);
    }

    public List<Integer> numericRepresentations(){
        return this.numericRepresentations;
    }

    public String words() {
        return this.toString().toLowerCase().replace("o_clock", "o'clock").replace("_"," ");
    }
}


