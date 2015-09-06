package com.sixthsolution.datecalculator;

import com.sixthsolution.datecalculator.calendar.CalendarConfig;
import com.sixthsolution.datecalculator.model.Day;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;

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
      return getDay(dateTime.getYear(),dateTime.getMonthOfYear(),dateTime.getDayOfMonth());
  }

  @Override public ArrayList<Day> getWeekDays(int weekIndicator) {
      DateTime dateTime = new DateTime();
      if (mConfig.hasTimeZone) {
          DateTimeZone timeZone = DateTimeZone.forOffsetHoursMinutes(mConfig.timeZoneHour, mConfig.timeZoneMinute);
          dateTime = new DateTime(timeZone);
      }
      Duration duration = getWeekBounds(dateTime, weekIndicator, mConfig);
      return getDays(duration);
  }

    @Override public ArrayList<Day> getMonthDays(int monthIndicator) {
        DateTime dateTime = new DateTime();
        if (mConfig.hasTimeZone) {
            DateTimeZone timeZone = DateTimeZone.forOffsetHoursMinutes(mConfig.timeZoneHour, mConfig.timeZoneMinute);
            dateTime = new DateTime(timeZone);
        }
        Duration duration = getMonthBounds(dateTime, monthIndicator);
        return getDays(duration);
    }

    @Override public Day getDay(int year, int month, int day) {
      //TODO: Calculate other Chronologies
      Day newDay = new Day();
      newDay.year = year;
      newDay.month = month;
      newDay.day = day;
      return newDay;
  }

  @Override public String getReadableTimestamp(DateTime toDateTime) {
    return null;
  }

  @Override public String getReadableTimestamp(DateTime toDateTime, String locale) {
    return null;
  }

    /**
     * Calculate start and end of a week for the given parameters.
     *
     * @param dateTime      DateTime to calculate from
     * @param weekIndicator how many week to forward or backward
     * @param config        CalenderConfig to indicate the week start day
     * @return {@link Duration Duration}
     */
    private Duration getWeekBounds(DateTime dateTime, int weekIndicator, CalendarConfig config) {
        Duration duration = new Duration();
        duration.mDurationStart = dateTime.withDayOfWeek(config.firstDayOfWeek).withTimeAtStartOfDay();
        if (weekIndicator >= 0)
            duration.mDurationEnd = duration.mDurationStart.plusWeeks(weekIndicator);
        else {
            duration.mDurationStart = duration.mDurationStart.minusWeeks(-weekIndicator);
            duration.mDurationEnd = duration.mDurationStart.plusWeeks(1);
        }
        duration.mDurationDays = getDaysBetween(duration.mDurationStart, duration.mDurationEnd);
        return duration;
    }

    /**
     * Calculate start and end of a week for the given parameters.
     *
     * @param dateTime      DateTime to calculate from
     * @param monthIndicator how many month to forward or backward
     * @return {@link Duration Duration}
     */
    private Duration getMonthBounds(DateTime dateTime, int monthIndicator) {
        Duration duration = new Duration();
        duration.mDurationStart = dateTime.withDayOfMonth(1).withTimeAtStartOfDay();
        if (monthIndicator >= 0) {
            duration.mDurationStart = duration.mDurationStart.plusMonths(monthIndicator);
            duration.mDurationEnd = duration.mDurationStart.plusMonths(1);
        } else {
            duration.mDurationStart = duration.mDurationStart.minusMonths(-monthIndicator);
            duration.mDurationEnd = duration.mDurationStart.plusMonths(1);
        }
        duration.mDurationDays = getDaysBetween(duration.mDurationStart, duration.mDurationEnd);
        return duration;
    }

    /**
     * Gets a list of Dates between the given dates
     *
     * @param startDate startDate
     * @param endDate   endDate
     * @return A list of {@link DateTime}
     */
    private ArrayList<DateTime> getDaysBetween(DateTime startDate, DateTime endDate) {
        int size = Days.daysBetween(startDate, endDate).getDays();
        ArrayList<DateTime> days = new ArrayList<>(size);
        while (!startDate.isEqual(endDate)) {
            days.add(startDate);
            startDate = startDate.plusDays(1);
        }
        return days;
    }

    /**
     * Create a list of Day from the given duration
     *
     * @param duration interval to get the days from
     * @return a list of days between start and end of the given duration
     */
    private ArrayList<Day> getDays(Duration duration) {
        Day day;
        ArrayList<Day> weekDays = new ArrayList<>(duration.mDurationDays.size());
        for (DateTime date : duration.mDurationDays) {
            day = getDay(date.getYear(), date.getMonthOfYear(), date.getDayOfMonth());
            weekDays.add(day);
        }
        return weekDays;
    }

    /**
     * A ObjectValue class for holding two point in time an the days between them
     */
    private class Duration {
        public DateTime mDurationStart;
        public DateTime mDurationEnd;
        public ArrayList<DateTime> mDurationDays;
    }
}
