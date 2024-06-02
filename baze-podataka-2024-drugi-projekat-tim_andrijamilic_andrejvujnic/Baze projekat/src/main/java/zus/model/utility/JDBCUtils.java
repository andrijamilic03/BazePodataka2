package zus.model.utility;

import zus.model.Osoba;
import zus.model.Planeta;
import zus.model.Prevoz;
import zus.model.StambeniObjekat;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    public static Connection connection = null;

    public static void connect() {
        System.out.println("ee");
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/zus", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Planeta> selectAllFromPlaneta() {
        List<Planeta> planete = new ArrayList<>();

        String query = "select mesto_id, b.naziv, a.naziv from mesta_naseljavanja a join vrste_tela b using (vrsta_id)";
        /*String query = "select naziv from mesta_naseljavanja where srednja_udaljenost between 100 and 200 " +
                "and najniza_temperatura between 150 and 250 " +
                "and najvisa_temperatura between 250 and 350 and (najvisa_temperatura - najniza_temperatura) <= 120";*/
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                /*int mestoId = resultSet.getInt(1);
                int vrstaId = resultSet.getInt(2);
                String naziv = resultSet.getString(3);
                int srednjaUdaljenost = resultSet.getInt(4);
                int minTemperatura = resultSet.getInt(5);
                int maxTemperatura = resultSet.getInt(6);
                int maxVisina = resultSet.getInt(7);
                int brzinaOrbitiranja = resultSet.getInt(8);*/

                //Planeta planeta = new Planeta(mestoId, vrstaId, naziv, srednjaUdaljenost, minTemperatura, maxTemperatura, maxVisina, brzinaOrbitiranja);
                int mestoId = resultSet.getInt(1);
                String naziv = resultSet.getString(2);
                String nazivTela = resultSet.getString(3);

                Planeta planeta = new Planeta(mestoId, naziv, nazivTela);
                planete.add(planeta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return planete;
    }

    public static List<Planeta> selectAllValidFromPlaneta() {
        List<Planeta> planete = new ArrayList<>();

        String query = "select naziv from mesta_naseljavanja where srednja_udaljenost between 100 and 200 ";/* +
                "and najniza_temperatura between 150 and 250 " +
                "and najvisa_temperatura between 250 and 350 and (najvisa_temperatura - najniza_temperatura) <= 120";*/
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                String naziv = resultSet.getString(1);



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

    public static List<Osoba> selectAllFromOsobe() {
        List<Osoba> osobe = new ArrayList<>();

        String query = "select  * from osobe";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int osobaId = resultSet.getInt(1);
                String ime = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                String username = resultSet.getString(4);
                String sifra = resultSet.getString(5);
                int starost = resultSet.getInt(6);

                Osoba osoba = new Osoba(osobaId, ime, prezime, username, sifra, starost);
                osobe.add(osoba);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return osobe;
    }

    public static List<Prevoz> selectAllFromPrevozi() {
        List<Prevoz> prevozi = new ArrayList<>();

        String query = "select  * from prevozi";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int prevozId = resultSet.getInt(1);
                int mestoId = resultSet.getInt(2);
                String naziv = resultSet.getString(3);
                int cena = resultSet.getInt(4);
                LocalDate datum = resultSet.getDate(5).toLocalDate();
                LocalTime vreme = resultSet.getTime(6).toLocalTime();

                Prevoz prevoz = new Prevoz(prevozId, mestoId, naziv, cena, datum, vreme);
                prevozi.add(prevoz);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prevozi;
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
        String query = "insert into osobe (ime, prezime, username, password, starost)" +
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

    public static boolean provera(String name, String pass){
        String ime = null;
        String sifra = null;
        String query = "SELECT username, password FROM osobe WHERE username = ? AND password = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ime = resultSet.getString(1);
                sifra = resultSet.getString(2);
            }

            if (ime != null && !ime.isEmpty() && sifra != null && !sifra.isEmpty()) {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private JDBCUtils() {

    }

}
