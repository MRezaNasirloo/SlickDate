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
        new CalendarConfig.Builder().addChronolgy(CalendarConfig.Chronology.ISO,
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
    dayToBe.setJalaliDate(1399, 12, 30);
    dayToBe.setIslamicDate(1442, 8, 6);
    assertTrue(this.day.equals(dayToBe));
  }

  @Test public void testGetDayMinus() throws Exception {
    dateCal = DateCal.newInstance(new CalendarConfig.Builder().build());
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
    dateCal = DateCal.newInstance(new CalendarConfig.Builder().build());
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

  @Test public void should_return_readable_time_stamps() throws Exception {
    dateTime = new DateTime();
    assertEquals("moments from now", dateCal.getReadableTimestamp(new DateTime().plusSeconds(3)));
    assertEquals("10 minutes from now", dateCal.getReadableTimestamp(new DateTime().plusMinutes(10)));
    assertEquals("5 hours from now", dateCal.getReadableTimestamp(new DateTime().plusHours(5)));
    assertEquals("3 days from now", dateCal.getReadableTimestamp(new DateTime().plusDays(3)));
    assertEquals("2 weeks from now", dateCal.getReadableTimestamp(new DateTime().plusWeeks(2)));
    assertEquals("3 months from now", dateCal.getReadableTimestamp(new DateTime().plusMonths(3)));

    assertEquals("moments ago", dateCal.getReadableTimestamp(new DateTime().minusSeconds(3)));
    assertEquals("10 minutes ago", dateCal.getReadableTimestamp(new DateTime().minusMinutes(10)));
    assertEquals("5 hours ago", dateCal.getReadableTimestamp(new DateTime().minusHours(5)));
    assertEquals("3 days ago", dateCal.getReadableTimestamp(new DateTime().minusDays(3)));
    assertEquals("2 weeks ago", dateCal.getReadableTimestamp(new DateTime().minusWeeks(2)));
    assertEquals("3 months ago", dateCal.getReadableTimestamp(new DateTime().minusMonths(3)));

    assertEquals("چند لحظه دیگر", dateCal.getReadableTimestamp(new DateTime().plusSeconds(3),CalendarConfig.Locale.fa.toString()));
    assertEquals("10 دقیقه دیگر", dateCal.getReadableTimestamp(new DateTime().plusMinutes(10),CalendarConfig.Locale.fa.toString()));
    assertEquals("5 ساعت دیگر", dateCal.getReadableTimestamp(new DateTime().plusHours(5),CalendarConfig.Locale.fa.toString()));
    assertEquals("3 روز دیگر", dateCal.getReadableTimestamp(new DateTime().plusDays(3),CalendarConfig.Locale.fa.toString()));
    assertEquals("2 هفته دیگر", dateCal.getReadableTimestamp(new DateTime().plusWeeks(2),CalendarConfig.Locale.fa.toString()));
    assertEquals("3 ماه دیگر", dateCal.getReadableTimestamp(new DateTime().plusMonths(3),CalendarConfig.Locale.fa.toString()));

    assertEquals("چند لحظه پیش", dateCal.getReadableTimestamp(new DateTime().minusSeconds(3),CalendarConfig.Locale.fa.toString()));
    assertEquals("10 دقیقه پیش", dateCal.getReadableTimestamp(new DateTime().minusMinutes(10),CalendarConfig.Locale.fa.toString()));
    assertEquals("5 ساعت پیش", dateCal.getReadableTimestamp(new DateTime().minusHours(5),CalendarConfig.Locale.fa.toString()));
    assertEquals("3 روز پیش", dateCal.getReadableTimestamp(new DateTime().minusDays(3),CalendarConfig.Locale.fa.toString()));
    assertEquals("2 هفته پیش", dateCal.getReadableTimestamp(new DateTime().minusWeeks(2),CalendarConfig.Locale.fa.toString()));
    assertEquals("3 ماه پیش", dateCal.getReadableTimestamp(new DateTime().minusMonths(3),CalendarConfig.Locale.fa.toString()));
  }
}