package cz.i.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.sql.SQLException;

import java.text.ParseException;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Test;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public class DbTest {
  private HelloDb helloDb = new HelloDb();

  @Test
  public void should_find_person() throws SQLException, ClassNotFoundException, ParseException {
    // prepare test data
    helloDb.initDb();
    helloDb.insertPerson("Toníček", "Novák", null);
    helloDb.insertPerson("Pepíček", "Novák", LocalDate.parse("1992-08-30"));

    // search for person
    List<Person> result = helloDb.searchPerson("No%");
    assertFalse("Expected 2 persons", result.isEmpty());

    Person firstPerson = result.get(0);
    assertEquals("Novák", firstPerson.getSurname());
    assertEquals("Expected first person Pepa Novák!!", "Pepíček", firstPerson.getName());
    assertEquals("1992-08-30", firstPerson.getBirthDate().toString());

    Person secondPerson = result.get(1);
    assertEquals("Novák", secondPerson.getSurname());
    assertEquals("Toníček", secondPerson.getName());
    assertNull(secondPerson.getBirthDate());
  }

  @Test(expected = SQLException.class)
  public void should_throw_sql_exception() throws SQLException, ClassNotFoundException {
    helloDb.initDb();
    helloDb.insertPerson(null, null, null);
  }

  @After
  public void cleanFileSystem() {
    File dbHome = new File(H2Constants.DB_HOME);
    for (File file : dbHome.listFiles()) {
      file.delete();
    }
 }
}
