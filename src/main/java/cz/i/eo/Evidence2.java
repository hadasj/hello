package cz.i.eo;

import java.util.Set;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public interface Evidence2 extends Evidence {

  /**
   * Will search for ALL persons with surname
   * @param surname @NotNull
   * @return Collection of persons with the surname
   */
  public Set<Person> filter(String surname);
}
