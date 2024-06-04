package zus.model.utility;

import zus.model.*;
import zus.view.MainView;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static zus.view.MainView.idOSOBE;

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

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
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

    public static List<Prostori> selectAllFromProstori() {
        List<Prostori> prostori = new ArrayList<>();

        String query = "select a.prostor_id ,b.naziv, c.naziv, a.cena from prostori a join mesta_naseljavanja b using (mesto_id) join vrste_prostora c using (vrsta_prostora_id) where osoba_id is null ";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String mesto = resultSet.getString(2);
                String vrsta = resultSet.getString(3);
                int cena = resultSet.getInt(4);

                Prostori prostor = new Prostori(id ,mesto, vrsta, cena);
                prostori.add(prostor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prostori;
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

        String query = "select prevoz_id, b.naziv, a.naziv, cena, datum_polaska, vreme_polaska from prevozi a " +
                "join mesta_naseljavanja b using (mesto_id) where srednja_udaljenost between 100 and 200 " +
                "and najniza_temperatura between 150 and 250 and najvisa_temperatura between 250 and 350 and " +
                "(najvisa_temperatura - najniza_temperatura) <= 120 and max_visina >= 1000 and brzina_orbitiranja between 25 and 35" +
                " and koncetracija_kiseonika between 15 and 25 and (koncetracija_ostalih + koncetracija_kiseonika) between 90 and 99";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int prevozId = resultSet.getInt(1);
                String mesto = resultSet.getString(2);
                String naziv = resultSet.getString(3);
                int cena = resultSet.getInt(4);
                LocalDate datum = resultSet.getDate(5).toLocalDate();
                LocalTime vreme = resultSet.getTime(6).toLocalTime();

                Prevoz prevoz = new Prevoz(prevozId, mesto, naziv, cena, datum, vreme);
                prevozi.add(prevoz);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prevozi;
    }

    public static List<Prevoz> selectAllFromPrevoziHistory() {
        List<Prevoz> prevozi = new ArrayList<>();

        String query = "select a.prevoz_id, a.naziv, c.naziv, cena, datum_polaska, vreme_polaska from prevozi a" +
                " join prevoz_osoba b using (prevoz_id) join mesta_naseljavanja c using (mesto_id) where osoba_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idOSOBE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int prevozId = resultSet.getInt(1);
                String nazivPrevoza = resultSet.getString(2);
                String mesto = resultSet.getString(3);
                int cena = resultSet.getInt(4);
                LocalDate datum = resultSet.getDate(5).toLocalDate();
                LocalTime vreme = resultSet.getTime(6).toLocalTime();

                Prevoz prevoz = new Prevoz(prevozId, nazivPrevoza, mesto, cena, datum, vreme);
                prevozi.add(prevoz);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prevozi;
    }

    public static List<Prostori> selectAllFromProstoriHistory() {
        List<Prostori> prostori= new ArrayList<>();

        String query = "select a.prostor_id ,b.naziv, c.naziv, a.cena from prostori a join mesta_naseljavanja b using (mesto_id) join vrste_prostora c using (vrsta_prostora_id) where osoba_id = ? ";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idOSOBE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int prostor_id = resultSet.getInt(1);
                String mesto = resultSet.getString(2);
                String vrtsa = resultSet.getString(3);
                int cena = resultSet.getInt(4);

                Prostori prostor = new Prostori(prostor_id, mesto, vrtsa, cena);
                prostori.add(prostor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prostori;
    }

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

    public static int proveraOsobeId(String name){
        int id = 0;
        String query = "select osoba_id from osobe where username = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }

    public static boolean proveraUsername(String ime){
        String na;
        String query = "select username from osobe where username = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, ime);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                 na = resultSet.getString(1);
                 if(!na.isEmpty()){
                     return false;
                 }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public static void insertIntoPrevozOsoba(int osobaId, int prevozId) {
        String query = "insert into prevoz_osoba (osoba_id, prevoz_id)" +
                "values (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, osobaId);
            statement.setInt(2, prevozId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void changeProstora(int osobaId, int prostorId) {
        String query = "update prostori set osoba_id = ? where prostor_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, osobaId);
            statement.setInt(2, prostorId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private JDBCUtils() {

    }

}
