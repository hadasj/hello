package cz.i.eo;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public class EvidenceTest {
  private Evidence evidence = new EvidenceSetImpl();

  @Test
  public void should_store_person_to_evidence() {
    Person person = new Person("Franta", "Voříšek");

    evidence.addPerson(person);
    assertTrue(evidence.isPersonInEvidence(person));
  }


  @Test
  @Ignore
  public void should_store_many_persons() {
    evidence.addPerson(new Person("Lukáš", "Svatý"));
    evidence.addPerson(new Person("Tomáš", "Nevěřící"));
    evidence.addPerson(new Person("Jana", "Divá"));

    evidence.print();
  }

  @Test
  public void should_store_unique_result() {
    evidence.addPerson(new Person("Lukáš", "Svatý"));
    evidence.addPerson(new Person("Tmoáš", "Nevěřící"));
    evidence.addPerson(new Person("Jana", "Divá"));
    evidence.addPerson(new Person("Tomáš", "Nevěřící"));

    evidence.print();

  }

}
