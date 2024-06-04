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

    public Prostori(int prostor_id, int vrsta_prostora_id, int osoba_id, int mesto_id, int cena){
        this.prostor_id = prostor_id;
        this.vrsta_prostora_id = vrsta_prostora_id;
        this.osoba_id = osoba_id;
        this.mesto_id = mesto_id;
        this.cena = cena;
    }

    public Prostori(int prostor_id, String mesto, String vrsta ,int cena) {
        this.prostor_id = prostor_id;
        this.mesto = mesto;
        this.vrsta = vrsta;
        this.cena = cena;
    }
}
