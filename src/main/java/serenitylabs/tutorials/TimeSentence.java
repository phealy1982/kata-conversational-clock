package serenitylabs.tutorials;

/**
 * Created by 66515 on 29/09/2016.
 */
public class TimeSentence {


    private String beginning;
    private String ending;
    private String minute;
    private String hour;

    public TimeSentence(String beginning, String minute, String hour, String ending) {
        this.beginning = beginning;
        this.minute = minute;
        this.hour = hour;
        this.ending = ending;
    }

    public static TimeSentenceBuilder withBeginning(String beginning) {
        return new TimeSentenceBuilder(beginning);
    }

    public String sentence() {
        return (this.beginning + this.minute + this.hour + this.ending).replace("  ", " ");
    }

    public static class TimeSentenceBuilder {
        public static final String SPACE = " ";
        private String beginning;
        private String hour;
        private String minute ="";

        public TimeSentenceBuilder(String beginning) {
            this.beginning = beginning;
        }

        public TimeSentence andWithEnding(String ending) {
            return new TimeSentence(this.beginning, this.minute, this.hour, ending);
        }

        public TimeSentenceBuilder withHour(String hour) {
            this.hour = SPACE + hour;
            return this;
        }

        public TimeSentenceBuilder withMinute(String minute) {
            this.minute = SPACE + minute;
            return this;
        }

        public TimeSentence andWithOClockEnding() {
            return new TimeSentence(this.beginning, this.minute, this.hour, " o'clock.");
        }
    }
}
