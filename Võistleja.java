package src;

import src.Rühmatöö_1.Kaitsed;
import src.Rühmatöö_1.Rünnakud;

public class Võistleja<kõik_kaitsed> {

    private String nimi;
    private int elud = 3;
    private int käigupunktid;
    private Kaitsed[] kaitsed = new Kaitsed[3];
    private Rünnakud[] rünnakud = new Rünnakud[3];

    //rünnakud ja kaitsed võiks vist loosida. 2 nõrka ja 1 tugev
    Kaitsed kaitse1 = new Kaitsed("kaitse1", 20);
    Kaitsed kaitse2 = new Kaitsed("kaitse2", 10);
    Kaitsed kaitse3 = new Kaitsed("kaitse3", 10);

    Rünnakud rünnak1 = new Rünnakud("rünnak1", 20);
    Rünnakud rünnak2 = new Rünnakud("rünnak2", 10);
    Rünnakud rünnak3 = new Rünnakud("rünnak3", 10);

    Kaitsed[] kõik_kaitsed = new Kaitsed[3];
    kõik_kaitsed[0] = kaitse1;
    Rünnakud[] kõik_rünnakud = new Rünnakud[3];

    Võistleja(String nimi, int käigu_punktid, Kaitsed[] kaitsed, Rünnakud[] rünnakud) {
        this.nimi = nimi;
        this.käigupunktid = käigu_punktid;

    }

    public String toString() {
        return "Võislteja nimi: " + nimi + "\n" +
                "Võislteja elud: " + elud + "\n" +
                "Võistleja käigupunktid: " + käigupunktid;
    }
}

