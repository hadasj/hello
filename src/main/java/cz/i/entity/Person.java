package cz.i.entity;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author jan.hadas@i.cz
 */
public class Person {

  private String name;
  private String surname;

  public Person(){}

  public Person(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this);
    builder.append("name", name).append("surname", surname).append("hash", hashCode());
    return builder.toString();
  }

  @Override
  public int hashCode() {
    return (name + surname).hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Person) {
      Person other = (Person)obj;
      return (name + surname).equals(other.getName() + other.getSurname());
    } else {
      return false;
    }
  }
}
