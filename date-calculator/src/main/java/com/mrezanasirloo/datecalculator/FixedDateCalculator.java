package com.mrezanasirloo.datecalculator;

import com.mrezanasirloo.datecalculator.calendar.CalendarConfig;
import com.mrezanasirloo.datecalculator.model.Day;
import org.joda.time.DateTime;

public interface FixedDateCalculator {

  /**
   * Creates a {@link Day} object with given date information.
   * <p>
   * Created {@link Day} object includes other chronologies information based on user configs in
   * {@link DateCal}.
   * </p>
   *
   * @param year year in ISO calendar.
   * @param month month in ISO calendar.
   * @param day day in ISO calendar.
   */
  Day getDay(int year, int month, int day);

  /**
   * Creates a {@link Day} object with given date information.
   * <p>
   * Created {@link Day} object includes other chronologies information based on user configs in
   * {@link DateCal}.
   * </p>
   *
   * @param timeStamp date in time millis
   */
  Day getDay(long timeStamp);

  /**
   * Calculates precise duration from now to given date time and creates a human readable
   * timestamps,
   * e.g "2 seconds ago, 15 minutes from now".
   * <p>
   * Also it's possible to support multiple languages with {@link CalendarConfig#locale}.
   * </p>
   *
   * References: http://www.ocpsoft.org/prettytime/
   */
  String getReadableTimestamp(DateTime toDateTime);

  /**
   * Same as {@link #getReadableTimestamp(DateTime)} but instead of using {@link
   * CalendarConfig#locale}, it uses given locale.
   */
  String getReadableTimestamp(DateTime toDateTime, String locale);
}
