package zus.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
public class Prevoz {
    private int prevoz_id;
    private int mesto_id;
    private String naziv;
    private int cena;
    private LocalDate datum;
    private LocalTime vreme;

    public Prevoz(int prevoz_id, int mesto_id, String naziv, int cena, LocalDate datum, LocalTime vreme){
        this.prevoz_id = prevoz_id;
        this.mesto_id = mesto_id;
        this.naziv = naziv;
        this.cena = cena;
        this.datum = datum;
        this.vreme = vreme;
    }

}
