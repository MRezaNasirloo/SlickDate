package com.sixthsolution.datecalculator.calendar;

import com.sixthsolution.datecalculator.JalaliCalenderConverter;
import com.sixthsolution.datecalculator.model.Day;

/**
 * Created by MohammadReza Nasirloo on 2015-09-07.
 */
public class IsoToJalali implements JalaliCalenderConverter {

  @Override public Day convert(int year, int month, int day) {
    JalaliCalendar.YearMonthDay yearMonthDay =
        JalaliCalendar.gregorianToJalali(new JalaliCalendar.YearMonthDay(year, month - 1, day));
    return new Day().setJalaliDate(yearMonthDay.getYear(), yearMonthDay.getMonth() + 1, yearMonthDay.getDay());
  }
}
