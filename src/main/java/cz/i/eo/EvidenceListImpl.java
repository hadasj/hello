package cz.i.eo;

import java.util.ArrayList;
import java.util.List;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public class EvidenceListImpl implements Evidence {
  private List<Person> persons = new ArrayList<>();

  @Override
  public void addPerson(Person person) {
    persons.add(person);
  }

  @Override
  public void print() {
    for (Person person : persons) {
      System.out.println(person.toString());
    }
  }

  @Override
  public boolean isPersonInEvidence(Person person) {
    return persons.contains(person);
  }
}
