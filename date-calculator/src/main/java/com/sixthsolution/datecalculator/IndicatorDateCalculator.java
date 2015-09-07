package com.sixthsolution.datecalculator;

import com.sixthsolution.datecalculator.calendar.CalendarConfig;
import com.sixthsolution.datecalculator.model.Day;
import java.util.ArrayList;

public interface IndicatorDateCalculator {

  /**
   * Creates a {@link Day} object based on given indicator.
   * <p>
   * For example <code>getDay(1)</code> returns tomorrow, or <code>getDay(-2)</code>
   * returns 2 days ago, and <code>getDay(0)</code> returns today.
   * </p>
   */
  Day getDay(int dayIndicator);

  /**
   * Creates a seven-day-week array based on given week indicator.
   * <p>
   * First object of array is {@link CalendarConfig#firstDayOfWeek}.
   * </p>
   * <p>
   * For example <code>getWeekDays(0)</code> with {@link CalendarConfig#MONDAY} as first day of
   * week,
   * returns current week which starts with monday and ends with sunday.
   * </p>
   */
  ArrayList<Day> getWeekDays(int weekIndicator);

  /**
   * Creates an arrays which includes all {@link Day}s in a month based on given month indicator.
   * <p>
   * For example, assume that we are in February and <code>getMonthDays(-1)</code> returns all days
   * in January
   * , first object in array is 1st day of January and last object in array is 31th day of
   * January.
   * </p>
   */
  ArrayList<Day> getMonthDays(int monthIndicator);
}
