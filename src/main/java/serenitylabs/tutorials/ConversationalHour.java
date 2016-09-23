package serenitylabs.tutorials;

import java.util.*;

/**
 * Created by 66515 on 19/09/2016.
 */
public enum ConversationalHour {
    Midnight(0, 24), One(1, 13), Two(2, 14), Three(3, 15), Four(4, 16),
    Five(5, 17), Six(6, 18), Seven(7, 19), Eight(8, 20), Nine(9, 21),
    Ten(10, 22), Eleven(11, 23), Noon(12);

    private final List<Integer> numericRepresentations;

    private static final Map<Integer, ConversationalHour> NUMBER_TO_HOUR_TRANSLATION = new LinkedHashMap<>();

    ConversationalHour(Integer... numbers) {
        numericRepresentations = Arrays.asList(numbers);
    }

    static {
        for (ConversationalHour conversationalHour : ConversationalHour.values()) {
            for(Integer numberRepresentation : conversationalHour.numericRepresentations){
                NUMBER_TO_HOUR_TRANSLATION.put(numberRepresentation, conversationalHour);
            }
        }
    }

    public static ConversationalHour withNumber(Integer number) {
        return NUMBER_TO_HOUR_TRANSLATION.get(number);
    }

    public String word(){
        return this.toString().toLowerCase();
    }

}
