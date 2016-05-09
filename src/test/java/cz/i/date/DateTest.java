package cz.i.date;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import org.junit.Test;

/**
 * @author jan.hadas@i.cz
 */
public class DateTest {
  private static final String EXPECTED_DATE = "2016-05-29";
  private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");


  @Test
  public void compute_legacy_date() {
    Calendar calendar = Calendar.getInstance();
    // 28.4.2016
    calendar.set(2016, Calendar.APRIL, 28);

    calendar.add(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.MONTH, 1);

    assertEquals(EXPECTED_DATE, FORMAT.format(calendar.getTime()));
  }

  @Test
  public void compute_date() {
    // 28.4.2016
    LocalDate future = LocalDate.of(2016, 4, 28).plusDays(1).plusMonths(1);

    assertEquals(EXPECTED_DATE, future.toString());
  }

}
