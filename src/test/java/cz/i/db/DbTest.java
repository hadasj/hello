package cz.i.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import cz.i.Person;

/**
 * @author jan.hadas@i.cz
 */
public class DbTest {
  private HelloDb helloDb = new HelloDb();

  @Test
  public void should_find_person() throws SQLException, ClassNotFoundException {
    // prepare test data
    helloDb.initDb();
    helloDb.insertPerson("Toníček", "Novák");
    helloDb.insertPerson("Pepíček", "Novák");

    // search for person
    List<Person> result = helloDb.searchPerson("No%");
    assertFalse("Expected 2 persons", result.isEmpty());

    Person firstPerson = result.get(0);
    assertEquals("Novák", firstPerson.getSurname());
    assertEquals("Expected first person Pepa Novák!!", "Pepíček", firstPerson.getName());
  }
}
