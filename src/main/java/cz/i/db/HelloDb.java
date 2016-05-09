package cz.i.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import cz.i.entity.Person;

/**
 * @author jan.hadas@i.cz
 */
public class HelloDb {
	private static int counter = 1;

	public void initDb() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();

		try {
      PreparedStatement statement = connection.prepareStatement("create table person(id int primary key, name varchar(255), " +
          "surname varchar(255) not null, birthdate date)");
			statement.executeUpdate();
			statement.close();

		} finally {
			connection.close();
		}
	}

	public void insertPerson(String name, String surname, LocalDate date) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();

		try {
      PreparedStatement statement = connection.prepareStatement("insert into person(id, name, surname, birthdate) values (?, ?, ?, ?)");
			statement.setInt(1, counter++);
			statement.setString(2, name);
			statement.setString(3, surname);
      if (date == null) {
        statement.setNull(4, Types.DATE);
      } else {
        // conversion from joda date to SQL date
        statement.setDate(4, new java.sql.Date(date.toDate().getTime()));
      }
			statement.executeUpdate();
			statement.close();
		} finally {
			connection.close();
		}
	}

	public List<Person> searchPerson(String surname) throws ClassNotFoundException, SQLException {
    Connection connection = getConnection();
    List<Person> result = new ArrayList<>();

    try {
      PreparedStatement statement = connection.prepareStatement(
          "select name, surname, birthdate from person where surname like ? order by name");
      statement.setString(1, surname);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Person person = new Person();
        person.setName(resultSet.getString("name"));
        person.setSurname(resultSet.getString("surname"));
        if (resultSet.getDate("birthdate") != null) {
          person.setBirthDate(new LocalDate(resultSet.getDate("birthdate").getTime()));
        }
        result.add(person);
      }
      resultSet.close();
      statement.close();
    } finally {
      connection.close();
    }
    return result;
  }


	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(H2Constants.DB_DRIVER);
    return DriverManager.getConnection(H2Constants.DB_CONNECTION_STRING, H2Constants.DB_USER,
        H2Constants.DB_PASSWORD);
	}
}
