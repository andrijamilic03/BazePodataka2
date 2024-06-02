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

    private String mestoNaziv;

    public Prevoz(int prevoz_id, String mestoNaziv, String naziv, int cena, LocalDate datum, LocalTime vreme){
        this.prevoz_id = prevoz_id;
        this.mestoNaziv = mestoNaziv;
        this.naziv = naziv;
        this.cena = cena;
        this.datum = datum;
        this.vreme = vreme;
    }

}
