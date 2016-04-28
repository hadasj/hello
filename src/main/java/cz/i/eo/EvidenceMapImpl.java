package cz.i.eo;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public class EvidenceMapImpl implements Evidence2 {
  private Map<String, Set<Person>> persons = new HashMap<>();

  @Override
  public Set<Person> filter(String surname) {
    if (surname == null) {
      throw new IllegalArgumentException("surname is mandatory");
    }

    Set<Person> collection = persons.get(surname);
    return collection == null ? Collections.<Person>emptySet() : collection;
  }

  @Override
  public void addPerson(Person person) {
    String surname = person.getSurname();

    if (persons.get(surname) == null) {
      persons.put(surname, new HashSet<Person>());
    }

    // collection of persons with same surname
    Set<Person> collection = persons.get(person.getSurname());
    collection.add(person);
  }

  @Override
  public void print() {
    for (String surname : persons.keySet()) {
      for (Person person : persons.get(surname)) {
        System.out.println(person);
      }
    }
  }

  @Override
  public boolean isPersonInEvidence(Person person) {
    if (persons.get(person.getSurname()) == null) {
      return false;
    } else {
      return persons.get(person.getSurname()).contains(person);
    }
  }
}
