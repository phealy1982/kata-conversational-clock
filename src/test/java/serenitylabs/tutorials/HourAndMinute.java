package serenitylabs.tutorials;

/**
 * Parses time represented in the "HH:mm" format,
 * so that the hour of the day
 * and a minute of the hour parts
 * can be easily retrieved.
 */
class HourAndMinute {
    private final int hour;
    private final int minute;

    /**
     * @param formattedTime current system time in "HH:mm" format, for example "17:15"
     */
    public HourAndMinute(String formattedTime) {
        String[] parts = formattedTime.split(":");

        this.hour = Integer.parseInt(parts[0]);
        this.minute = Integer.parseInt(parts[1]);
    }

    public int hour() {
        return hour;
    }

    public int minute() {
        return minute;
    }
}
