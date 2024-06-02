package zus.view;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import zus.model.Prevoz;
import zus.model.Prostori;
import zus.model.base.Server;
import zus.model.utility.JDBCUtils;
import zus.view.table.PrevozTable;
import zus.view.table.ProstoriTable;

public class HistoryView extends Stage {
    //private TableView<Prevoz> prevozi = new PrevozTable(Server.SERVER.getPrevoziHistory(username));
    private TableView<Prostori> prostori = new ProstoriTable(Server.SERVER.getProstori());
    public HistoryView(String username) {
        int id = JDBCUtils.proveraOsobeId(username);
        TableView<Prevoz> prevozi = new PrevozTable(Server.SERVER.getPrevoziHistory());
        super.setScene(new Scene(prevozi, 700,500));
    }
}
