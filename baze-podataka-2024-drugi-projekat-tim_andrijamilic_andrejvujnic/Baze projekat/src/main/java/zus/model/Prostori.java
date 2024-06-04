package zus.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Prostori {
    private int prostor_id;
    private int vrsta_prostora_id;
    private int osoba_id;
    private int mesto_id;
    private int cena;
    private String vrsta;
    private String mesto;

    public Prostori(int prostor_id, String mesto, String vrsta ,int cena) {
        this.prostor_id = prostor_id;
        this.mesto = mesto;
        this.vrsta = vrsta;
        this.cena = cena;
    }
}
