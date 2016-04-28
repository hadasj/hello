package cz.i.eo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public class EvidenceSetImpl implements Evidence2 {
  private Set<Person> persons = new HashSet<>();

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

  @Override
  public Set<Person> filter(String surname) {
    if (surname == null) {
      throw new IllegalArgumentException("surname is mandatory");
    }

    Set<Person> filteredResult = new HashSet<>();
    for (Person person : persons) {
      if (person.getSurname().equals(surname)) {
        filteredResult.add(person);
      }
    }
    return filteredResult;
  }
}
