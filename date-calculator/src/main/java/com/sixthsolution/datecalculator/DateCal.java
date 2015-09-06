package com.sixthsolution.datecalculator;

import com.sixthsolution.datecalculator.calendar.CalendarConfig;
import com.sixthsolution.datecalculator.model.Day;
import java.util.ArrayList;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class DateCal implements IndicatorDateCalculator, FixedDateCalculator {

  private static DateCal sInstance;

  private CalendarConfig mConfig;

  public static DateCal newInstance(CalendarConfig config) {
    sInstance = new DateCal();
    sInstance.setConfig(config);
    return sInstance;
  }

  public static DateCal getInstance() {
    if (sInstance == null) {
      sInstance = new DateCal();
    }
    return sInstance;
  }

  private DateCal() {
    mConfig = new CalendarConfig.ConfigBuilder().build();
  }

  public DateCal setConfig(CalendarConfig config) {
    mConfig = config;
    return this;
  }

  public CalendarConfig getConfig() {
    return mConfig;
  }

  @Override public Day getDay(int dayIndicator) {
      DateTime dateTime = new DateTime();
      if (mConfig.hasTimeZone) {
          DateTimeZone timeZone = DateTimeZone.forOffsetHoursMinutes(mConfig.timeZoneHour, mConfig.timeZoneMinute);
          dateTime = dateTime.withZone(timeZone);
      }
      if (dayIndicator >= 0)
          dateTime = dateTime.plusDays(dayIndicator);
      else
          dateTime = dateTime.minusDays(-dayIndicator);
      Day day = new Day();
      day.year = dateTime.getYear();
      day.month = dateTime.getMonthOfYear();
      day.day = dateTime.getDayOfMonth();
      return day;
  }

  @Override public ArrayList<Day> getWeekDays(int weekIndicator) {
    return null;
  }

  @Override public ArrayList<Day> getMonthDays(int monthIndicator) {
    return null;
  }

  @Override public Day getDay(int year, int month, int day) {
    return null;
  }

  @Override public String getReadableTimestamp(DateTime toDateTime) {
    return null;
  }

  @Override public String getReadableTimestamp(DateTime toDateTime, String locale) {
    return null;
  }
}
