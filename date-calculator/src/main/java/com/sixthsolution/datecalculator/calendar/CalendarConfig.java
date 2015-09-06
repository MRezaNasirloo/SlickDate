package com.sixthsolution.datecalculator.calendar;

import org.joda.time.DateTimeConstants;

import java.util.ArrayList;

public class CalendarConfig {

    public static final int SATURDAY = DateTimeConstants.SATURDAY;
    public static final int SUNDAY = DateTimeConstants.SUNDAY;
    public static final int MONDAY = DateTimeConstants.MONDAY;

    public enum Chronology {
        ISO, JALALI, ISLAMIC
    }

    public ArrayList<Chronology> chronologies = new ArrayList<>();

    public int timeZoneHour = 0;
    public int timeZoneMinute = 0;
    public boolean hasTimeZone = false;
    public int firstDayOfWeek = MONDAY;
    public String locale = "en";

    private CalendarConfig() {
        chronologies.add(Chronology.ISO);
    }

    private CalendarConfig(ConfigBuilder builder) {
        timeZoneHour = builder.timeZoneHour;
        timeZoneMinute = builder.timeZoneMinute;
        hasTimeZone = builder.hasTimeZone;
        firstDayOfWeek = builder.firstDayOfWeek;
        locale = builder.locale;
        chronologies.add(Chronology.ISO);
    }

    public void addChronology(Chronology chronology) {

    }

    public void addChronolgy(Chronology... chronology) {

    }

    /**
     * Builder for creating {@link CalendarConfig} object.
     */
    public static class ConfigBuilder {

        public int timeZoneHour = 0;
        public int timeZoneMinute = 0;
        public boolean hasTimeZone = false;
        public int firstDayOfWeek = MONDAY;
        public String locale = "en";

        public ConfigBuilder setTimeZone(int hour, int minute) {
            this.timeZoneHour = hour;
            this.timeZoneMinute = minute;
            hasTimeZone = true;
            return this;
        }

        public ConfigBuilder setFirstDayOfWeek(int firstDayOfWeek) {
            this.firstDayOfWeek = firstDayOfWeek;
            return this;
        }

        public ConfigBuilder setLocale(String locale) {
            this.locale = locale;
            return this;
        }

        public CalendarConfig build() {
            return new CalendarConfig(this);
        }

    }
}
