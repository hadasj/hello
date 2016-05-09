package cz.i.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import org.joda.time.LocalDate;
import org.junit.Test;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public class PersonTest {

  private static final DateFormat PARSER;

  static {
    PARSER = new SimpleDateFormat("dd.MM.yyyy");
    PARSER.setLenient(false);
  }


	@Test
	public void should_create_new_instance() throws ParseException {
    Person person = new Person("Franta", "Vomáčko");
    person.setBirthDate(LocalDate.parse("1969-02-15"));

    assertEquals("Franta", person.getName());
    assertEquals("Vomáčko", person.getSurname());
    assertEquals("1969-02-15",  person.getBirthDate().toString());
	}

  @Test
  public void should_create_empty_instance() {
    Person emptyPerson = new Person(null, null);

    assertNull(emptyPerson.getName());
    assertNull(emptyPerson.getSurname());
    assertNull(emptyPerson.getBirthDate());
  }

  @Test
  public void should_print_person() throws ParseException {
    Pattern pattern = Pattern.compile("cz\\.i\\.entity\\.Person@.*?\\[name=null,surname=<null>,birthDate=1988-02-29,hash=-1905561714\\]");
    Person person = new Person("null", null);
    person.setBirthDate(LocalDate.parse("1988-02-29"));
    String personToStringValue = person.toString();

    assertTrue(pattern.matcher(personToStringValue).matches());
  }

  @Test
  public void should_differ_two_different_persons() throws ParseException {
    Person youngMan = new Person("Franta", "Vomáčko");
    youngMan.setBirthDate(LocalDate.parse("2010-04-28"));
    Person oldMan = new Person("Franta", "Vomáčko");
    oldMan.setBirthDate(LocalDate.parse("1896-11-15"));

    assertNotEquals(youngMan, oldMan);
  }

  @Test
  public void equals_should_return_true() throws ParseException {
    Person man = new Person("Franta", "Vomáčko");
    man.setBirthDate(LocalDate.parse("1993-06-01"));
    Person sameMan = new Person("Franta", "Vomáčko");
    sameMan.setBirthDate(LocalDate.parse("1993-06-01"));

    assertEquals(man, sameMan);
  }
}
