package com.mrezanasirloo.datecalculator.calendar;

import com.mrezanasirloo.datecalculator.JalaliCalenderConverter;
import com.mrezanasirloo.datecalculator.model.Day;

/**
 * Created by M.Reza.Nasirloo@gmail.com on 2015-09-07.
 */
public class CalenderConverter implements JalaliCalenderConverter {

  @Deprecated
  @Override public Day convert(int year, int month, int day) {
    JalaliCalendar.YearMonthDay yearMonthDay = JalaliCalendar.gregorianToJalali(new JalaliCalendar.YearMonthDay(year, month - 1, day));
    return new Day().setJalaliDate(yearMonthDay.getYear(), yearMonthDay.getMonth() + 1, yearMonthDay.getDay());
  }

  @Override
  public Day convertToJalali(int year, int month, int day) {
    JalaliCalendar.YearMonthDay yearMonthDay = JalaliCalendar.gregorianToJalali(new JalaliCalendar.YearMonthDay(year, month - 1, day));
    return new Day().setJalaliDate(yearMonthDay.getYear(), yearMonthDay.getMonth() + 1, yearMonthDay.getDay());
  }

  @Override
  public Day convertToGeorgian(int year, int month, int day) {
    JalaliCalendar.YearMonthDay yearMonthDay = JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(year, month - 1, day));
    return new Day().setIsoDate(yearMonthDay.getYear(), yearMonthDay.getMonth() + 1, yearMonthDay.getDay());

  }
}
