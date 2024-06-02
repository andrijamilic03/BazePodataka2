package zus.model.base;

import lombok.Getter;
import lombok.Setter;
import zus.model.Osoba;
import zus.model.Prevoz;
import zus.model.StambeniObjekat;
import zus.model.utility.JDBCUtils;
import zus.model.Planeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class Server {

    public static final Server SERVER = new Server();

    private final List<Planeta> planete = new ArrayList<>();

    private final List<Planeta> dobrePlanete = new ArrayList<>();

    private final List<StambeniObjekat> stambeniObjekati = new ArrayList<>();

    private final List<Osoba> osobe = new ArrayList<>();

    private final List<Prevoz> prevozi = new ArrayList<>();

    private Server() {
        this.setPlanete(JDBCUtils.selectAllFromPlaneta());
        this.setDobrePlanete(JDBCUtils.selectAllValidFromPlaneta());
        this.setStambeniObjekti(JDBCUtils.selectAllFromStambeniObjekti());
        this.setOsobe(JDBCUtils.selectAllFromOsobe());
        this.setPrevoze(JDBCUtils.selectAllFromPrevozi());
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

    public void setDobrePlanete(Collection<Planeta> planeta) {
        this.dobrePlanete.clear();
        this.dobrePlanete.addAll(planeta);
    }

    public void setStambeniObjekti(Collection<StambeniObjekat> stambeniObjekat) {
        this.stambeniObjekati.clear();
        this.stambeniObjekati.addAll(stambeniObjekat);
    }

    public void setOsobe(Collection<Osoba> osobe){
        this.osobe.clear();
        this.osobe.addAll(osobe);
    }

    public void setPrevoze(Collection<Prevoz> prevozi){
        this.prevozi.clear();
        this.prevozi.addAll(prevozi);
    }
}
