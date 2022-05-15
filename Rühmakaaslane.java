package src.Ruhmatoo1;

import java.util.ArrayList;

public class Ruhmakaaslane extends Voistleja {

    private String kõrgelennulisus;

    Ruhmakaaslane(String nimi, int käigupunktid, ArrayList<Kaitse> kaitsed, ArrayList<Runnak> rünnakud, String kõrgelennulisus) {
        super(nimi, käigupunktid, kaitsed, rünnakud);
        this.kõrgelennulisus = kõrgelennulisus;
    }

    public String getKõrgelennulisus() {
        return kõrgelennulisus;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Kõrgelennulisus: " + kõrgelennulisus;
    }
}
