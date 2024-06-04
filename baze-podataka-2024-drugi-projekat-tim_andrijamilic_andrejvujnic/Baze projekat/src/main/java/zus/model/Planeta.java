package zus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class Planeta {
    private int mesto_id;
    private int vrsta_id;
    private String naziv;
    private int srednjaUdaljenost;
    private int najnizaTemperatura;
    private int najvisaTemperatura;
    private int maxVisina;
    private int brzinaOrbitiranja;
    private String nazivTela;

    public Planeta(int mesto_id, String naziv, String nazivTela) {
        this.mesto_id = mesto_id;
        this.naziv = naziv;
        this.nazivTela = nazivTela;
    }

    @Override
    public String toString() {
        return naziv;
    }
}