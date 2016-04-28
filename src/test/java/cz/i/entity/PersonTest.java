package cz.i.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.junit.Test;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public class PersonTest {

	@Test
	public void should_create_new_instance() {
    Person person = new Person("Franta", "Vomáčko");

    assertEquals("Franta", person.getName());
    assertEquals("Vomáčko", person.getSurname());
	}

  @Test
  public void should_create_empty_instance() {
    Person emptyPerson = new Person(null, null);

    assertNull(emptyPerson.getName());
    assertNull(emptyPerson.getSurname());
  }

  @Test
  public void should_print_empty_person() {
    Pattern pattern = Pattern.compile("cz\\.i\\.entity\\.Person@.*?\\[name=null,surname=<null>,hash=-1905561714\\]");
    String personToStringValue = new Person("null", null).toString();

    assertTrue(pattern.matcher(personToStringValue).matches());


  }
}
