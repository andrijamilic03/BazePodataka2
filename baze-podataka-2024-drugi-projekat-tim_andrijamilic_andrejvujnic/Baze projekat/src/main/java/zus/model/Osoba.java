package zus.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Osoba {
    private int osobaId;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private int starost;

    public Osoba(int osobaId, String ime, String prezime, String username, String password, int starost){
        this.osobaId = osobaId;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.starost = starost;
    }

}
