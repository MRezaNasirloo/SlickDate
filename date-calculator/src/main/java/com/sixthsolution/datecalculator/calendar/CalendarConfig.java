package com.sixthsolution.datecalculator.calendar;

import java.util.Arrays;
import java.util.HashSet;
import org.joda.time.DateTimeConstants;

public class CalendarConfig {

  public static final int SATURDAY = DateTimeConstants.SATURDAY;
  public static final int SUNDAY = DateTimeConstants.SUNDAY;
  public static final int MONDAY = DateTimeConstants.MONDAY;

  public enum Locale {
    ar, bg, ca, cs, da, de, en, es, et, fa, fi, fr, hi, hr, hu, in, it, ja, ko, nl, no, pl, pt, ro, ru, sl, sv, tr, uk, vi, zh
  }

  public enum Chronology {
    ISO, JALALI, ISLAMIC
  }

  public HashSet<Chronology> chronologies = new HashSet<>();

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
    chronologies = builder.chronologies;
    chronologies.add(Chronology.ISO);
  }

  /**
   * Builder for creating {@link CalendarConfig} object.
   */
  public static class ConfigBuilder {

    public HashSet<Chronology> chronologies = new HashSet<>();
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

    public ConfigBuilder addChronology(Chronology chronology) {
      this.chronologies.add(chronology);
      return this;
    }

    public ConfigBuilder addChronolgy(Chronology... chronology) {
      this.chronologies.addAll(Arrays.asList(chronology));
      return this;
    }

    public CalendarConfig build() {
      return new CalendarConfig(this);
    }
  }
}
