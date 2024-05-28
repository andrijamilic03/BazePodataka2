package zus.model.utility;

import zus.model.Planeta;
import zus.model.StambeniObjekat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    public static Connection connection = null;

    public static void connect() {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zus", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Planeta> selectAllFromPlaneta() {
        List<Planeta> planete = new ArrayList<>();

        String query = "select  * from mesta_naseljavanja";

        /*String query = "select naziv from mesta_naseljavanja where srednja_udaljenost between 100 and 200 " +
                "and najniza_temperatura between 150 and 250 " +
                "and najvisa_temperatura between 250 and 350 and (najvisa_temperatura - najniza_temperatura) <= 120";*/
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int mestoId = resultSet.getInt(1);
                int vrstaId = resultSet.getInt(2);
                String naziv = resultSet.getString(3);
                int srednjaUdaljenost = resultSet.getInt(4);
                int minTemperatura = resultSet.getInt(5);
                int maxTemperatura = resultSet.getInt(6);
                int maxVisina = resultSet.getInt(7);
                int brzinaOrbitiranja = resultSet.getInt(8);

                Planeta planeta = new Planeta(mestoId, vrstaId, naziv, srednjaUdaljenost, minTemperatura, maxTemperatura, maxVisina, brzinaOrbitiranja);
                planete.add(planeta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return planete;
    }

    public static List<StambeniObjekat> selectAllFromStambeniObjekti() {
        List<StambeniObjekat> stambeniObjekti = new ArrayList<>();

        String query = "select  * from vrste_prostora";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int objekatId = resultSet.getInt(1);
                String naziv = resultSet.getString(2);

                StambeniObjekat stambeniObjekat = new StambeniObjekat(objekatId, naziv);
                stambeniObjekti.add(stambeniObjekat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stambeniObjekti;
    }

    /*public static List<Person> selectFromPerson(String firstName, String lastName, String yearOfBirth) {
        List<Person> oldPeople = selectAllFromPerson();
        Server.SERVER.setPeople(oldPeople);
        List<Person> people = new ArrayList<>();
        for (Person oldPerson : oldPeople) {
            if (yearOfBirth == null || yearOfBirth.length() != 4) {
                if (oldPerson.getFirstName().toLowerCase().contains(firstName.toLowerCase())
                        && oldPerson.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                    people.add(oldPerson);
                continue;
            }
            if (oldPerson.getFirstName().toLowerCase().contains(firstName.toLowerCase())
                    && oldPerson.getLastName().toLowerCase().contains(lastName.toLowerCase())
                    && oldPerson.getDateOfBirth().getYear() == Integer.parseInt(yearOfBirth))
                people.add(oldPerson);
        }
        return people;
    }*/

    public static void insertIntoOsobe(String ime, String prezime, String username, String password, int starost) {
        String query = "insert into osobe (first_name, last_name, date_of_birth)" +
                "values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, ime);
            statement.setString(2, prezime);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setInt(5, starost);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private JDBCUtils() {

    }

}
