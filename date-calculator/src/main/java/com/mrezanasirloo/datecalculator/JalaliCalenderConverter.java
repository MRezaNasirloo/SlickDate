package com.mrezanasirloo.datecalculator;

import com.mrezanasirloo.datecalculator.model.Day;

/**
 * Created by M.Reza.Nasirloo@gmail.com on 2015-09-07.
 */
public interface JalaliCalenderConverter {
  Day convert(int year, int month, int day);
}
