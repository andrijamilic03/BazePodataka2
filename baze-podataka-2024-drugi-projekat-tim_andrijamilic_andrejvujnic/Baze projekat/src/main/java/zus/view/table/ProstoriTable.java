package zus.view.table;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.Prostori;

import java.util.List;

public class ProstoriTable extends TableView<Prostori> {
    public ProstoriTable(List<Prostori> prostori) {
        super(FXCollections.observableArrayList(prostori));

        TableColumn<Prostori, Integer> id = new TableColumn<>("ID");
        TableColumn<Prostori, String> mesto = new TableColumn<>("Mesto");
        TableColumn<Prostori, String> vrsta = new TableColumn<>("Vrtsa prostora");
        TableColumn<Prostori, Integer> cena = new TableColumn<>("Cena");

        id.setCellValueFactory(new PropertyValueFactory<>("prostor_id"));
        mesto.setCellValueFactory(new PropertyValueFactory<>("mesto"));
        vrsta.setCellValueFactory(new PropertyValueFactory<>("vrsta"));
        cena.setCellValueFactory(new PropertyValueFactory<>("cena"));

        super.getColumns().add(id);
        super.getColumns().add(mesto);
        super.getColumns().add(vrsta);
        super.getColumns().add(cena);

    }
}
