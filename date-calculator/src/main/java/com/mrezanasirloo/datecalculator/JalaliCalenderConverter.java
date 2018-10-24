package com.mrezanasirloo.datecalculator;

import com.mrezanasirloo.datecalculator.model.Day;

/**
 * Created by M.Reza.Nasirloo@gmail.com on 2015-09-07.
 */
public interface JalaliCalenderConverter {
  /**
   * @param year year in georgian
   * @param month month in georgian
   * @param day day in georgian
   * @return Day object
   *
   * Deprecated: Use convertTo and ConvertFrom
   */
  @Deprecated
  Day convert(int year, int month, int day);

  /**
   * Converts georgian to jalali
   *
   * @param year year in georgian
   * @param month month in georgian
   * @param day day in georgian
   * @return Day object
   */
  Day convertToJalali(int year, int month, int day);

  /**
   * Converts georgian to georgian
   *
   * @param year year in jalaili
   * @param month month in jalaili
   * @param day day in jalaili
   * @return Day object
   */
  Day convertToGeorgian(int year, int month, int day);
}
