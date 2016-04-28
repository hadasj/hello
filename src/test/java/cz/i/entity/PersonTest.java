package cz.i.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

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
    person.setBirthDate(PARSER.parse("15.2.1969"));

    assertEquals("Franta", person.getName());
    assertEquals("Vomáčko", person.getSurname());
    assertEquals("15.02.1969",  PARSER.format(person.getBirthDate()));
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
    Pattern pattern = Pattern.compile("cz\\.i\\.entity\\.Person@.*?\\[name=null,surname=<null>,birthDate=29\\.02\\.1988 12:00:00,hash=-1905561714\\]");
    Person person = new Person("null", null);
    person.setBirthDate(PARSER.parse("29.2.1988"));
    String personToStringValue = person.toString();

    assertTrue(pattern.matcher(personToStringValue).matches());
  }

  @Test
  public void should_differ_two_different_persons() throws ParseException {
    Person youngMan = new Person("Franta", "Vomáčko");
    youngMan.setBirthDate(PARSER.parse("28.4.2010"));
    Person oldMan = new Person("Franta", "Vomáčko");
    oldMan.setBirthDate(PARSER.parse("15.11.1896"));

    assertNotEquals(youngMan, oldMan);
  }

  @Test
  public void equals_should_return_true() throws ParseException {
    Person man = new Person("Franta", "Vomáčko");
    man.setBirthDate(PARSER.parse("1.6.1993"));
    Person sameMan = new Person("Franta", "Vomáčko");
    sameMan.setBirthDate(PARSER.parse("1.6.1993"));

    assertEquals(man, sameMan);
  }
}
