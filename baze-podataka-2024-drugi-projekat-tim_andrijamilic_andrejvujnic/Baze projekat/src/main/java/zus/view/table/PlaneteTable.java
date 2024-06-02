package zus.view.table;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.Planeta;
import java.util.List;

public class PlaneteTable extends TableView<Planeta> {
    public PlaneteTable(List<Planeta> planete) {
        super(FXCollections.observableArrayList(planete));

        TableColumn<Planeta, Integer> mesto_id = new TableColumn<>("ID");
        TableColumn<Planeta, String> naziv = new TableColumn<>("Naziv");
        TableColumn<Planeta, String> nazivTela = new TableColumn<>("NazivTela");

        mesto_id.setCellValueFactory(new PropertyValueFactory<>("mesto_id"));
        naziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        nazivTela.setCellValueFactory(new PropertyValueFactory<>("nazivTela"));

        super.getColumns().add(mesto_id);
        super.getColumns().add(naziv);
        super.getColumns().add(nazivTela);

    }
}
