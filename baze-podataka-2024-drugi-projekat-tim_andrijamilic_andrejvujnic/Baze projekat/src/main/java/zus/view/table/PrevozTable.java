package zus.view.table;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.Prevoz;

import javax.swing.text.Element;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PrevozTable extends TableView<Prevoz> {
    public PrevozTable(List<Prevoz> prevozi) {
        super(FXCollections.observableArrayList(prevozi));

        TableColumn<Prevoz, Integer> prevozId = new TableColumn<>("ID");
        TableColumn<Prevoz, String> mesto = new TableColumn<>("Mesto");
        TableColumn<Prevoz, String> naziv = new TableColumn<>("Naziv");
        TableColumn<Prevoz, Integer> cena = new TableColumn<>("Cena");
        TableColumn<Prevoz, LocalDate> datum = new TableColumn<>("Datum polaska");
        TableColumn<Prevoz, LocalTime> vreme = new TableColumn<>("Vreme polaska");

        prevozId.setCellValueFactory(new PropertyValueFactory<>("prevoz_id"));
        mesto.setCellValueFactory(new PropertyValueFactory<>("mestoNaziv"));
        naziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        cena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        datum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        vreme.setCellValueFactory(new PropertyValueFactory<>("vreme"));

        super.getColumns().add(prevozId);
        super.getColumns().add(mesto);
        super.getColumns().add(naziv);
        super.getColumns().add(cena);
        super.getColumns().add(datum);
        super.getColumns().add(vreme);
    }
}
