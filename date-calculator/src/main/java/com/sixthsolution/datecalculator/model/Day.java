package com.sixthsolution.datecalculator.model;

public class Day {

  public int year, month, day;
  public int jalaliYear, jalaliMonth, jalaliDay;
  public int islamicYear, islamicMonth, islamicDay;

  @Override public boolean equals(Object o) {
    if (o != null && o instanceof Day) {
      final Day other = (Day) o;
      return this.year == other.year && this.month == other.month && this.day == other.day;
    }
    return false;
  }
}
