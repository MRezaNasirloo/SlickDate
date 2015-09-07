package datecalculator;

import com.sixthsolution.datecalculator.DateCal;
import com.sixthsolution.datecalculator.calendar.CalendarConfig;
import com.sixthsolution.datecalculator.model.Day;
import java.util.ArrayList;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by MohammadReza Nasirloo on 2015-09-06.
 */
public class DateCalTest {

  private DateCal dateCal;
  private Day day;
  private DateTime dateTime;

  @Before public void setUp() throws Exception {
    dateCal = DateCal.getInstance();
  }

  @After public void tearDown() throws Exception {

  }

  @Test public void testGetDay() throws Exception {
    day = new Day();
    CalendarConfig config =
        new CalendarConfig.ConfigBuilder().addChronolgy(CalendarConfig.Chronology.ISO,
            CalendarConfig.Chronology.JALALI, CalendarConfig.Chronology.ISLAMIC).build();
    dateCal = DateCal.newInstance(config);
    Day dayToBe = new Day();

    day = dateCal.getDay(2015, 9, 7);
    dayToBe.setIsoDate(2015, 9, 7);
    dayToBe.setJalaliDate(1394, 6, 16);
    dayToBe.setIslamicDate(1436, 11, 23);
    assertTrue(this.day.equals(dayToBe));

    day = dateCal.getDay(2018, 3, 21);
    dayToBe.setIsoDate(2018, 3, 21);
    dayToBe.setJalaliDate(1397, 1, 1);
    dayToBe.setIslamicDate(1439, 7, 4);
    assertTrue(this.day.equals(dayToBe));

    day = dateCal.getDay(2021, 3, 20);
    dayToBe.setIsoDate(2021, 3, 20);
    dayToBe.setJalaliDate(1400, 1, 1);
    dayToBe.setIslamicDate(1442, 8, 7);
    assertTrue(this.day.equals(dayToBe));
  }

  @Test public void testGetDayMinus() throws Exception {
    day = new Day();
    dateTime = new DateTime();
    dateTime = dateTime.minusDays(1);
    day.year = dateTime.getYear();
    day.month = dateTime.getMonthOfYear();
    day.day = dateTime.getDayOfMonth();
    Day day = dateCal.getDay(-1);
    assertTrue(this.day.equals(day));
  }

  @Test public void testGetDayPlus() throws Exception {
    day = new Day();
    dateTime = new DateTime();
    dateTime = dateTime.plusDays(1);
    day.year = dateTime.getYear();
    day.month = dateTime.getMonthOfYear();
    day.day = dateTime.getDayOfMonth();
    Day day = dateCal.getDay(1);
    assertTrue(this.day.equals(day));
  }

  @Test public void it_should_return_seven_days() throws Exception {
    //TODO: Add more tests
    day = new Day();
    dateTime = new DateTime();
    ArrayList<Day> weekDays = dateCal.getWeekDays(1);
    assertEquals(7, weekDays.size());
  }

  @Test public void it_should_return_the_list_of_days_for_next_month() throws Exception {
    //TODO: Add more tests
    ArrayList<Day> monthDays = dateCal.getMonthDays(2);
    day = monthDays.get(0);
    dateTime = new DateTime(day.year, day.month, day.day, 0, 0, 0);

    assertEquals(dateTime.dayOfMonth().getMaximumValue(), monthDays.size());
  }

  @Test public void it_should_return_the_list_of_days_for_past_month() throws Exception {
    //TODO: Add more tests
    ArrayList<Day> monthDays = dateCal.getMonthDays(-3);
    day = monthDays.get(0);
    dateTime = new DateTime(day.year, day.month, day.day, 0, 0, 0);
    assertEquals(dateTime.dayOfMonth().getMaximumValue(), monthDays.size());
  }
}