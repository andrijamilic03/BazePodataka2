package zus.model;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

public class StambeniObjekat {
    private int objekatId;
    private String naziv;

    public StambeniObjekat(int objekatId, String naziv){
        this.objekatId = objekatId;
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
