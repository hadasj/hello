package cz.i.eo;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public interface Evidence {

  /**
   * Stores person to the evidence
   * @param person @NotNull
   */
  void addPerson(Person person);

  /**
   * Prints all person stored in evidence
   */
  void print();

  /**
   * @param person @NotNull
   * @return true, if the person is stored in evidence
   */
  boolean isPersonInEvidence(Person person);
}
