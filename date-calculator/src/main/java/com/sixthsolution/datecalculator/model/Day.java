package com.sixthsolution.datecalculator.model;

public class Day {

  public int year;
  public int month;
  public int day;
  public int jalaliYear;
  public int jalaliMonth;
  public int jalaliDay;
  public int islamicYear;
  public int islamicMonth;
  public int islamicDay;

  public Day setIsoDate(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
    return this;
  }

  public Day setJalaliDate(int jalaliYear, int jalaliMonth, int jalaliDay) {
    this.jalaliYear = jalaliYear;
    this.jalaliMonth = jalaliMonth;
    this.jalaliDay = jalaliDay;
    return this;
  }

  public Day setIslamicDate(int islamicYear, int islamicMonth, int islamicDay) {
    this.islamicYear = islamicYear;
    this.islamicMonth = islamicMonth;
    this.islamicDay = islamicDay;
    return this;
  }

  @Override public boolean equals(Object o) {
    if (o != null && o instanceof Day) {
      final Day other = (Day) o;
      return this.year == other.year && this.month == other.month && this.day == other.day
          && this.jalaliYear == other.jalaliYear && this.jalaliMonth == other.jalaliMonth
          && this.jalaliDay == other.jalaliDay && this.islamicYear == other.islamicYear
          && this.islamicMonth == other.islamicMonth && this.islamicDay == other.islamicDay;
    }
    return false;
  }
}
