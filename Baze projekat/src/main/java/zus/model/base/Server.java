package zus.model.base;

import zus.model.StambeniObjekat;
import zus.model.utility.JDBCUtils;
import zus.model.Planeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private final List<Planeta> planete = new ArrayList<>();
    private final List<StambeniObjekat> stambeniObjekati = new ArrayList<>();

    private Server() {
        this.setPlanete(JDBCUtils.selectAllFromPlaneta());
        this.setStambeniObjekti(JDBCUtils.selectAllFromStambeniObjekti());
    }

    public List<Planeta> getPlanete() {
        return planete;
    }
    public List<StambeniObjekat> getStambeniObjekati() {
        return stambeniObjekati;
    }


    public void setPlanete(Collection<Planeta> planeta) {
        this.planete.clear();
        this.planete.addAll(planeta);
    }

    public void setStambeniObjekti(Collection<StambeniObjekat> stambeniObjekat) {
        this.stambeniObjekati.clear();
        this.stambeniObjekati.addAll(stambeniObjekat);
    }

}
