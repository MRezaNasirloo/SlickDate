package com.sixthsolution.datecalculator;

import com.sixthsolution.datecalculator.model.Day;

public interface FixedDateCalculator {

  Day getDay(int year, int month, int day);
}
