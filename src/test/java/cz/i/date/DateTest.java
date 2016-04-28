package cz.i.date;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * @author jan.hadas@i.cz
 */
public class DateTest {



  @Test
  public void compute_legacy_date() {
    Date current = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(current);

    calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
    calendar.add(Calendar.MONTH, 1);

    Date future = calendar.getTime();
    assertEquals("", future.toString());
  }

  @Test
  public void compute_date() {
    LocalDate future = LocalDate.now().plusDays(1).plusMonths(1);

    assertEquals("2016-05-29", future.toString());
  }

}
