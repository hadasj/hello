package cz.i.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author jan.hadas@i.cz
 */
public class Person {

  private String name;
  private String surname;
  private Date birthDate;

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

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    String birthDateFormatted = getBirthDateFormatted();

    ToStringBuilder builder = new ToStringBuilder(this);
    builder.append("name", name).append("surname", surname).append("birthDate", birthDateFormatted).append("hash", hashCode());
    return builder.toString();
  }

  public String getBirthDateFormatted() {
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    return birthDate == null ? null : format.format(birthDate);
  }

  @Override
  public int hashCode() {
    return (name + surname).hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Person) {
      Person other = (Person)obj;

      return nullSafeEquals(surname, other.surname) && nullSafeEquals(name, other.name)
          && nullSafeEquals(birthDate, other.birthDate);
    } else {
      return false;
    }
  }

  private boolean nullSafeEquals(Object first, Object second) {
    if (first == null && second == null) {
      return true;
    } else if (first != null && second != null) {
      return first.equals(second);
    } else {
      return false;
    }
  }
}
