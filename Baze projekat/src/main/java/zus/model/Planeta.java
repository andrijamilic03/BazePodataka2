package zus.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Planeta {
    private int mestoId;
    private int vrstaId;
    private String naziv;
    private int srednjaUdaljenost;
    private int najnizaTemperatura;
    private int najvisaTemperatura;
    private int maxVisina;
    private int brzinaOrbitiranja;


    public Planeta(int mestoId, int vrstaId, String naziv, int srednjaUdaljenost, int najnizaTemperatura, int najvisaTemperatura, int maxVisina, int brzinaOrbitiranja){
        this.mestoId = mestoId;
        this.vrstaId = vrstaId;
        this.naziv = naziv;
        this.srednjaUdaljenost = srednjaUdaljenost;
        this.najnizaTemperatura = najnizaTemperatura;
        this.najvisaTemperatura = najvisaTemperatura;
        this.maxVisina = maxVisina;
        this.brzinaOrbitiranja = brzinaOrbitiranja;
    }

    @Override
    public String toString() {
        return naziv;
    }
}