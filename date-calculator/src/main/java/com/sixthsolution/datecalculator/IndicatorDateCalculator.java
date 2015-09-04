package com.sixthsolution.datecalculator;

import com.sixthsolution.datecalculator.model.Day;
import java.util.ArrayList;

public interface IndicatorDateCalculator {

  Day getDay(int dayIndicator);

  ArrayList<Day> getWeekDays(int weekIndicator);

  ArrayList<Day> getMonthDays(int monthIndicator);
}
