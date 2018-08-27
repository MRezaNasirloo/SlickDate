package com.mrezanasirloo.datecal.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.mrezanasirloo.datecalculator.DateCal;
import com.mrezanasirloo.datecalculator.calendar.CalendarConfig;
import com.mrezanasirloo.datecalculator.model.Day;
import com.mrezanasirloo.datecalculator.sample.R;

import net.danlew.android.joda.JodaTimeAndroid;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    JodaTimeAndroid.init(this);
    DateCal dc = DateCal.newInstance(
        new CalendarConfig.Builder().addChronolgy(CalendarConfig.Chronology.JALALI,
            CalendarConfig.Chronology.ISLAMIC).setFirstDayOfWeek(CalendarConfig.SUNDAY).build());
    TextView textView = (TextView) findViewById(R.id.test);
    long time = System.currentTimeMillis();
    StringBuilder sb = new StringBuilder();
    sb.append("\n\nToday\n");
    sb.append(dc.getDay(0).toString());
    sb.append("\n\nTomorrow\n");
    sb.append(dc.getDay(1).toString());
    sb.append("\n\nYesterday\n");
    sb.append(dc.getDay(-1).toString());
    sb.append("\n---------Next Week-------------\n");
    ArrayList<Day> daysInNextWeek = dc.getWeekDays(1);
    for (Day day : daysInNextWeek) {
      sb.append(day.toString()).append("\n\n");
    }
    sb.append("\n---------Previous Month-------------\n");
    ArrayList<Day> daysInPreviousMonth = dc.getMonthDays(-1);
    for (Day day : daysInPreviousMonth) {
      sb.append(day.toString()).append("\n\n");
    }
    sb.append("\n----------------------\n");
    sb.append("parsing time : ").append(System.currentTimeMillis() - time).append(" millis");

    textView.setText(sb.toString());
  }
}
