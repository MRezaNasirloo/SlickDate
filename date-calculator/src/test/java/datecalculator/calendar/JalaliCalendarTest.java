package datecalculator.calendar;

import com.mrezanasirloo.datecalculator.calendar.JalaliCalendar;
import java.util.Calendar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * NOTE: All the months here are from 0 to 11, either ISO or Jalali
 */
public class JalaliCalendarTest {

  @Test public void dayOfWeekTest() {

    assertEquals(JalaliCalendar.dayOfWeek(new JalaliCalendar.YearMonthDay(2012, 6, 30)), 2);
    assertEquals(JalaliCalendar.dayOfWeek(new JalaliCalendar.YearMonthDay(2012, 7, 1)), 4);
    assertEquals(JalaliCalendar.dayOfWeek(new JalaliCalendar.YearMonthDay(2010, 7, 20)), 6);
    assertEquals(JalaliCalendar.dayOfWeek(new JalaliCalendar.YearMonthDay(2008, 3, 23)), 4);
    assertEquals(JalaliCalendar.dayOfWeek(new JalaliCalendar.YearMonthDay(2011, 10, 14)), 2);
    assertEquals(JalaliCalendar.dayOfWeek(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1391, 3, 10))), 7);
    assertEquals(JalaliCalendar.dayOfWeek(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1389, 4, 31))), 1);
    assertEquals(JalaliCalendar.dayOfWeek(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1390, 11, 27))), 7);
    assertEquals(JalaliCalendar.dayOfWeek(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1391, 1, 1))), 6);
    assertEquals(JalaliCalendar.dayOfWeek(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1382, 7, 22))), 5);
    assertEquals(JalaliCalendar.dayOfWeek(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1391, 10, 5))), 5);
    assertEquals(JalaliCalendar.dayOfWeek(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1391, 11, 1))), 3);
  }

  @Test public void weekOfYearTest() {

    assertEquals(JalaliCalendar.weekOfYear(103, 1391), 16);
    assertEquals(JalaliCalendar.weekOfYear(229, 1391), 34);
    assertEquals(JalaliCalendar.weekOfYear(228, 1391), 33);
    assertEquals(JalaliCalendar.weekOfYear(100, 1389), 15);
    assertEquals(JalaliCalendar.weekOfYear(235, 1382), 35);
  }

  @Test public void weekOfMonthTest() {

    assertEquals(new JalaliCalendar(1390, 5, 6).get(Calendar.WEEK_OF_MONTH), 2);
    assertEquals(new JalaliCalendar(1388, 10, 10).get(Calendar.WEEK_OF_MONTH), 3);
    assertEquals(new JalaliCalendar(1386, 2, 19).get(Calendar.WEEK_OF_MONTH), 4);
    assertEquals(new JalaliCalendar(1386, 2, 18).get(Calendar.WEEK_OF_MONTH), 3);
    assertEquals(new JalaliCalendar(1391, 11, 30).get(Calendar.WEEK_OF_MONTH), 5);
    assertEquals(new JalaliCalendar(1391, 9, 30).get(Calendar.WEEK_OF_MONTH), 6);
  }

  @Test public void dayOfYear() {

    assertEquals(new JalaliCalendar(1391, 11, 30).get(Calendar.DAY_OF_YEAR), 366);
    assertEquals(new JalaliCalendar(1391, 10, 3).get(Calendar.DAY_OF_YEAR), 309);
    assertEquals(new JalaliCalendar(1391, 8, 15).get(Calendar.DAY_OF_YEAR), 261);
    assertEquals(new JalaliCalendar(1391, 5, 22).get(Calendar.DAY_OF_YEAR), 177);
    assertEquals(new JalaliCalendar(1391, 0, 21).get(Calendar.DAY_OF_YEAR), 21);
  }

  @Test public void dayOfWeekInMonth() {

    assertEquals(new JalaliCalendar(1391, 11, 30).get(Calendar.DAY_OF_WEEK_IN_MONTH), 5);
    assertEquals(new JalaliCalendar(1391, 10, 3).get(Calendar.DAY_OF_WEEK_IN_MONTH), 1);
    assertEquals(new JalaliCalendar(1391, 8, 15).get(Calendar.DAY_OF_WEEK_IN_MONTH), 3);
    assertEquals(new JalaliCalendar(1391, 5, 22).get(Calendar.DAY_OF_WEEK_IN_MONTH), 4);
    assertEquals(new JalaliCalendar(1391, 0, 21).get(Calendar.DAY_OF_WEEK_IN_MONTH), 3);
  }

  @Test public void jalaliToGregorian() {

    assertEquals(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1369, 11, 14)).toString(),
        "1991/2/5");
    assertEquals(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1388, 3, 20)).toString(),
        "2009/6/11");
    assertEquals(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1387, 7, 9)).toString(),
        "2008/9/30");
    assertEquals(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1386, 0, 5)).toString(),
        "2007/2/25");
    assertEquals(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1385, 4, 18)).toString(),
        "2006/7/9");
    assertEquals(
        JalaliCalendar.jalaliToGregorian(new JalaliCalendar.YearMonthDay(1392, 0, 31)).toString(),
        "2013/3/20");
  }

  @Test public void gregorianToJalali() {

    assertEquals(
        JalaliCalendar.gregorianToJalali(new JalaliCalendar.YearMonthDay(1991, 2, 5)).toString(),
        "1369/11/14");
    assertEquals(
        JalaliCalendar.gregorianToJalali(new JalaliCalendar.YearMonthDay(1994, 8, 24)).toString(),
        "1373/6/2");
    assertEquals(
        JalaliCalendar.gregorianToJalali(new JalaliCalendar.YearMonthDay(1996, 5, 24)).toString(),
        "1375/3/4");
    assertEquals(
        JalaliCalendar.gregorianToJalali(new JalaliCalendar.YearMonthDay(2001, 8, 20)).toString(),
        "1380/5/29");
    assertEquals(
        JalaliCalendar.gregorianToJalali(new JalaliCalendar.YearMonthDay(2013, 2, 20)).toString(),
        "1391/11/30");
  }

  @Test public void addTest() {

    JalaliCalendar jalaliCalendar = new JalaliCalendar(1390, 0, 1, 15, 30, 30);
    jalaliCalendar.add(Calendar.YEAR, 2);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1392);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 0);
    assertEquals(jalaliCalendar.get(Calendar.DATE), 1);
    jalaliCalendar.add(Calendar.MONTH, 20);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1393);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 8);
    assertEquals(jalaliCalendar.get(Calendar.DATE), 1);
    jalaliCalendar.add(Calendar.DATE, 200);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1394);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 2);
    assertEquals(jalaliCalendar.get(Calendar.DATE), 20);
    jalaliCalendar.add(Calendar.DAY_OF_YEAR, -200);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1393);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 8);
    assertEquals(jalaliCalendar.get(Calendar.DATE), 1);
    jalaliCalendar.add(Calendar.DAY_OF_WEEK_IN_MONTH, 10);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1393);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 10);
    assertEquals(jalaliCalendar.get(Calendar.DATE), 11);
    jalaliCalendar.add(Calendar.WEEK_OF_MONTH, -10);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1393);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 8);
    assertEquals(jalaliCalendar.get(Calendar.DATE), 1);
    jalaliCalendar.add(Calendar.DAY_OF_WEEK, 10);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1393);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 8);
    assertEquals(jalaliCalendar.get(Calendar.DATE), 11);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 15);
    jalaliCalendar.add(Calendar.HOUR, 100);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1393);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 8);
    assertEquals(jalaliCalendar.get(Calendar.DATE), 15);
    assertEquals(jalaliCalendar.get(Calendar.HOUR), 7);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 19);
    assertEquals(jalaliCalendar.get(Calendar.MINUTE), 30);
    assertEquals(jalaliCalendar.get(Calendar.SECOND), 30);
    jalaliCalendar.add(Calendar.MINUTE, -1820);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1393);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 8);
    assertEquals(jalaliCalendar.get(Calendar.DATE), 14);
    assertEquals(jalaliCalendar.get(Calendar.HOUR), 1);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 13);
    assertEquals(jalaliCalendar.get(Calendar.MINUTE), 10);
    assertEquals(jalaliCalendar.get(Calendar.SECOND), 30);
  }

  @Test public void getMinGetMaxTest() {

    assertEquals(JalaliCalendar.getInstance().getMinimum(Calendar.MONTH), 0);
    assertEquals(new JalaliCalendar().getMaximum(Calendar.HOUR), 11);
    assertEquals(new JalaliCalendar().getMaximum(Calendar.MONTH), 11);
  }

  @Test public void rollTest() {

    JalaliCalendar jalaliCalendar = new JalaliCalendar(1391, 4, 3, 17, 5, 45);
    jalaliCalendar.roll(Calendar.YEAR, 10);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1401);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 4);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 3);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 17);
    assertEquals(jalaliCalendar.get(Calendar.WEEK_OF_YEAR), 19);
    jalaliCalendar = new JalaliCalendar(1391, 11, 30);
    jalaliCalendar.roll(Calendar.YEAR, 1);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1392);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 11);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 29);
    assertEquals(jalaliCalendar.get(Calendar.WEEK_OF_YEAR), 53);
    jalaliCalendar = new JalaliCalendar(1391, 11, 30);
    jalaliCalendar.roll(Calendar.YEAR, 4);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1395);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 11);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 30);
    jalaliCalendar = new JalaliCalendar(1391, 5, 20);
    jalaliCalendar.roll(Calendar.MONTH, 4);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1391);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 9);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 20);
    jalaliCalendar = new JalaliCalendar(1391, 2, 31);
    jalaliCalendar.roll(Calendar.MONTH, 18);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1391);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 8);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 30);
    jalaliCalendar = new JalaliCalendar(1391, 2, 31);
    jalaliCalendar.roll(Calendar.MONTH, 9);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1391);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 11);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 30);
    jalaliCalendar = new JalaliCalendar(1390, 2, 31);
    jalaliCalendar.roll(Calendar.MONTH, 9);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1390);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 11);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 29);
    jalaliCalendar = new JalaliCalendar(1390, 2, 12);
    jalaliCalendar.roll(Calendar.DAY_OF_MONTH, 9);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1390);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 2);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 21);
    jalaliCalendar.roll(Calendar.DAY_OF_MONTH, 52);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1390);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 2);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 11);
    jalaliCalendar = new JalaliCalendar(1391, 3, 19, 22, 12, 30);
    assertEquals(jalaliCalendar.get(Calendar.AM_PM), 1);
    jalaliCalendar.roll(Calendar.AM_PM, 11);
    assertEquals(jalaliCalendar.get(Calendar.AM_PM), 0);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 10);
    assertEquals(jalaliCalendar.get(Calendar.HOUR), 10);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 19);
    assertEquals(jalaliCalendar.get(Calendar.MINUTE), 12);
    assertEquals(jalaliCalendar.get(Calendar.SECOND), 30);
    jalaliCalendar.roll(Calendar.AM_PM, 111);
    assertEquals(jalaliCalendar.get(Calendar.AM_PM), 1);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 22);
    assertEquals(jalaliCalendar.get(Calendar.HOUR), 10);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 19);
    assertEquals(jalaliCalendar.get(Calendar.MINUTE), 12);
    assertEquals(jalaliCalendar.get(Calendar.SECOND), 30);
    jalaliCalendar = new JalaliCalendar(1391, 3, 19, 22, 12, 30);
    jalaliCalendar.roll(Calendar.HOUR, 29);
    assertEquals(jalaliCalendar.get(Calendar.HOUR), 3);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 15);
    assertEquals(jalaliCalendar.get(Calendar.AM_PM), Calendar.PM);
    jalaliCalendar = new JalaliCalendar(1391, 3, 19, 5, 12, 30);
    jalaliCalendar.roll(Calendar.HOUR, 7);
    assertEquals(jalaliCalendar.get(Calendar.HOUR), 0);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 0);
    assertEquals(jalaliCalendar.get(Calendar.AM_PM), Calendar.AM);
    jalaliCalendar = new JalaliCalendar(1391, 3, 19, 22, 12, 30);
    jalaliCalendar.roll(Calendar.HOUR_OF_DAY, 29);
    assertEquals(jalaliCalendar.get(Calendar.HOUR), 3);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 3);
    assertEquals(jalaliCalendar.get(Calendar.AM_PM), Calendar.AM);
    jalaliCalendar = new JalaliCalendar(1391, 3, 19, 22, 12, 30);
    jalaliCalendar.roll(Calendar.HOUR_OF_DAY, 13);
    assertEquals(jalaliCalendar.get(Calendar.HOUR), 11);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 11);
    assertEquals(jalaliCalendar.get(Calendar.AM_PM), Calendar.AM);

    //        Calendar.DAY_OF_YEAR Test
    jalaliCalendar = new JalaliCalendar(1391, 3, 19, 22, 12, 30);
    jalaliCalendar.roll(Calendar.DAY_OF_YEAR, 10);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 3);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 29);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_YEAR), 122);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1391);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 22);

    jalaliCalendar = new JalaliCalendar(1391, 3, 19, 22, 12, 30);
    jalaliCalendar.roll(Calendar.DAY_OF_YEAR, 300);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 1);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 15);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_YEAR), 46);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1391);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 22);

    jalaliCalendar = new JalaliCalendar(1391, 3, 19, 22, 12, 30);
    jalaliCalendar.roll(Calendar.DAY_OF_YEAR, -200);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 9);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 2);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_YEAR), 278);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1391);
    assertEquals(jalaliCalendar.get(Calendar.HOUR_OF_DAY), 22);
    //        *****************************************

    //        Calendar.DAY_OF_WEEK Tests
    jalaliCalendar = new JalaliCalendar(1391, 3, 19, 22, 12, 30);
    jalaliCalendar.roll(Calendar.DAY_OF_WEEK, 4);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 3);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 23);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1391);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_WEEK), Calendar.FRIDAY);

    jalaliCalendar = new JalaliCalendar(1391, 2, 30, 22, 12, 30);
    jalaliCalendar.roll(Calendar.DAY_OF_WEEK, 3);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 3);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 2);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1391);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_WEEK), Calendar.FRIDAY);
    jalaliCalendar.roll(Calendar.DAY_OF_WEEK, 1);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 2);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 27);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1391);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_WEEK), Calendar.SATURDAY);

    jalaliCalendar = new JalaliCalendar(1391, 11, 28, 22, 12, 30);
    jalaliCalendar.roll(Calendar.DAY_OF_WEEK, 10);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 0);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 1);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1392);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_WEEK), Calendar.THURSDAY);
    jalaliCalendar.roll(Calendar.DAY_OF_WEEK, 21);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 0);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 1);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1392);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_WEEK), Calendar.THURSDAY);
    jalaliCalendar.roll(Calendar.DAY_OF_WEEK, 3);
    assertEquals(jalaliCalendar.get(Calendar.MONTH), 11);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_MONTH), 27);
    assertEquals(jalaliCalendar.get(Calendar.YEAR), 1391);
    assertEquals(jalaliCalendar.get(Calendar.DAY_OF_WEEK), Calendar.SUNDAY);

/*
//        Calendar.WEEK_OF_YEAR Test TODO: Code for these tests has not been implemented yet
        jalalicalendar = new JalaliCalendar(1391, 3, 19, 22, 12, 30);
        jalalicalendar.roll(Calendar.WEEK_OF_YEAR, 4);
        assertEquals(jalalicalendar.get(Calendar.MONTH), 4);
        assertEquals(jalalicalendar.get(Calendar.DAY_OF_MONTH), 16);
        assertEquals(jalalicalendar.get(Calendar.YEAR), 1391);
        assertEquals(jalalicalendar.get(Calendar.DAY_OF_WEEK), Calendar.MONDAY);
        jalalicalendar = new JalaliCalendar(1391, 10, 11, 22, 12, 30);
        jalalicalendar.roll(Calendar.WEEK_OF_YEAR, 2);
        assertEquals(jalalicalendar.get(Calendar.MONTH), 10);
        assertEquals(jalalicalendar.get(Calendar.DAY_OF_MONTH), 25);
        assertEquals(jalalicalendar.get(Calendar.YEAR), 1391);
        assertEquals(jalalicalendar.get(Calendar.DAY_OF_WEEK), Calendar.WEDNESDAY);
        jalalicalendar.roll(Calendar.WEEK_OF_YEAR, 5);
        assertEquals(jalalicalendar.get(Calendar.MONTH), 11);
        assertEquals(jalalicalendar.get(Calendar.DAY_OF_MONTH), 30);
        assertEquals(jalalicalendar.get(Calendar.YEAR), 1391);
        assertEquals(jalalicalendar.get(Calendar.DAY_OF_WEEK), Calendar.WEDNESDAY);
        jalalicalendar.roll(Calendar.WEEK_OF_YEAR, 1);
        assertEquals(jalalicalendar.get(Calendar.MONTH), 0);
        assertEquals(jalalicalendar.get(Calendar.DAY_OF_MONTH), 2);
        assertEquals(jalalicalendar.get(Calendar.YEAR), 1391);
        assertEquals(jalalicalendar.get(Calendar.DAY_OF_WEEK), Calendar.WEDNESDAY);
*/

  }

  @Test public void after_beforeTest() {

    Calendar calendar = new JalaliCalendar(1389, 9, 12);
    Calendar calendar1 = new JalaliCalendar(1389, 9, 13);
    assertEquals(calendar.after(calendar1), false);
    assertEquals(calendar1.after(calendar), true);
    assertEquals(calendar.before(calendar1), true);
    assertEquals(calendar1.before(calendar), false);
    calendar.set(1300, 2, 30);
    calendar1.set(1467, 3, 4);
    assertEquals(calendar.after(calendar1), false);
    assertEquals(calendar1.after(calendar), true);
    assertEquals(calendar.before(calendar1), true);
    assertEquals(calendar1.before(calendar), false);
  }
}
