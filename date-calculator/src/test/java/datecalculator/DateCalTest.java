package datecalculator;

import com.sixthsolution.datecalculator.DateCal;
import com.sixthsolution.datecalculator.model.Day;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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