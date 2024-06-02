package zus.model.base;

import lombok.Getter;
import lombok.Setter;
import zus.model.*;
import zus.model.utility.JDBCUtils;

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

    private final List<Prevoz> prevoziHistory = new ArrayList<>();

    private final List<Prostori> prostori = new ArrayList<>();


    private Server() {
        this.setPlanete(JDBCUtils.selectAllFromPlaneta());
        this.setDobrePlanete(JDBCUtils.selectAllValidFromPlaneta());
        this.setStambeniObjekti(JDBCUtils.selectAllFromStambeniObjekti());
        this.setOsobe(JDBCUtils.selectAllFromOsobe());
        this.setPrevoze(JDBCUtils.selectAllFromPrevozi());
        this.setProstori(JDBCUtils.selectAllFromProstori());
        this.setPrevozeHistory(JDBCUtils.selectAllFromPrevoziHistory());
    }

    public List<Planeta> getPlanete() {
        return planete;
    }
    public List<StambeniObjekat> getStambeniObjekati() {
        return stambeniObjekati;
    }

    public List<Prevoz> getPrevoziHistory() {
        return prevoziHistory;
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
    public void setProstori(Collection<Prostori> prostori){
        this.prostori.clear();
        this.prostori.addAll(prostori);
    }

    public void setPrevozeHistory(Collection<Prevoz> prevozi){
        this.prevoziHistory.clear();
        this.prevoziHistory.addAll(prevozi);
    }
}
