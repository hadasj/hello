package cz.i.entity;

/**
 * @author jan.hadas@i.cz
 */
public class Father extends Person {
  private int childCount;

  public Father(String name, String surname) {
    super(name, surname);
  }

  public Father(String name, String surname, int childCount) {
    this(name, surname);
    this.childCount = childCount;
  }


}
