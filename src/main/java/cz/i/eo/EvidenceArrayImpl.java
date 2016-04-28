package cz.i.eo;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public class EvidenceArrayImpl implements Evidence {

  private static final int MAX_PEOPLE_STORED = 100;
  private Person[] persons = new Person[MAX_PEOPLE_STORED];
  private int index = 0;

  @Override
  public void addPerson(Person person) {
    if (index >= MAX_PEOPLE_STORED) {
      throw new IllegalStateException("Překročena kapacita evidence (max. počet je " + MAX_PEOPLE_STORED + ")");
    }

    persons[index] = person;
    index += 1;
  }

  @Override
  public void print() {
    for (int i = 0; i < index; i++) {
       System.out.println(persons[i].toString());
    }
  }

  @Override
  public boolean isPersonInEvidence(Person person) {
    for (int i = 0; i < index; i++) {
      if (persons[i].equals(person)) {
        return true;
      }
    }
    return false;
  }
}
