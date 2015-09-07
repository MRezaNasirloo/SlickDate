package com.sixthsolution.datecalculator;

import com.sixthsolution.datecalculator.model.Day;

/**
 * Created by MohammadReza Nasirloo on 2015-09-07.
 */
public interface JalaliCalenderConverter {
  Day convert(int year, int month, int day);
}
