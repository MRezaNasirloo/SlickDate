package com.sixthsolution.datecalculator;

import com.sixthsolution.datecalculator.chronology.CalendarConfig;
import com.sixthsolution.datecalculator.model.Day;
import java.util.ArrayList;

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
    mConfig = new CalendarConfig();
  }

  public DateCal setConfig(CalendarConfig config) {
    mConfig = config;
    return this;
  }

  public CalendarConfig getConfig() {
    return mConfig;
  }

  @Override public Day getDay(int dayIndicator) {
    return null;
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
}
