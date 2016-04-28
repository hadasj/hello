package cz.i.eo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public class EvidenceTest {
  private Evidence2 evidence = new EvidenceMapImpl();

  @Test
  public void should_store_person_to_evidence() {
    Person person = new Person("Franta", "Voříšek");

    evidence.addPerson(person);
    assertTrue(evidence.isPersonInEvidence(person));
  }

  @Test
  public void should_store_unique_result() {
    prepareTestData();

    evidence.print();
  }

  @Test
  public void should_filter_multiple_results() {
    prepareTestData();

    Set<Person> filteredResult = evidence.filter("Nevěřící");
    assertNotNull(filteredResult);
    assertEquals("Expected non-empty result", 2, filteredResult.size());

    Iterator<Person> iterator = filteredResult.iterator();
    Person first = iterator.next();
    assertEquals("Nevěřící", first.getSurname());
    assertEquals("Tomáš", first.getName());

    Person second = iterator.next();
    assertEquals("Nevěřící", second.getSurname());
    assertEquals("Tmoáš", second.getName());
  }

  @Test
  public void should_filter_nonEmpty_data_and_return_empty_result() {
    prepareTestData();

    Set<Person> filteredResult = evidence.filter("Nevěříc");
    assertNotNull(filteredResult);
    assertTrue("Expected empty collection", filteredResult.isEmpty());
  }

  @Test
  public void should_throw_exception_if_criteria_is_null() {
    try {
      evidence.filter(null);
      fail("Expected exception thrown");
    } catch (Exception e) {
      assertTrue(e instanceof IllegalArgumentException);
      assertEquals("surname is mandatory", e.getMessage());
    }
  }


  private void prepareTestData() {
    evidence.addPerson(new Person("Lukáš", "Svatý"));
    evidence.addPerson(new Person("Tmoáš", "Nevěřící"));
    evidence.addPerson(new Person("Jana", "Divá"));
    evidence.addPerson(new Person("Tomáš", "Nevěřící"));
  }

}
