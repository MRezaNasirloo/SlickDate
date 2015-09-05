package com.sixthsolution.datecalculator.calendar;

import java.util.ArrayList;
import org.joda.time.DateTimeConstants;

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

  public CalendarConfig() {
    chronologies.add(Chronology.ISO);
  }

  public void addChronology(Chronology chronology) {

  }

  public void addChronolgy(Chronology... chronology) {

  }

  public void setTimeZone(int hour, int minute) {
    timeZoneHour = hour;
    timeZoneMinute = minute;
    hasTimeZone = true;
  }

  public void setFirstDayOfWeek(int firstDayOfWeek) {
  }

  public void setLocale(String locale) {

  }
}
