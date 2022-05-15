package src.Ruhmatoo1;

import java.util.ArrayList;

public class Voistleja {

    private String nimi;
    private int elud = 3;
    private int käigupunktid;
    private ArrayList<Kaitse> kaitsed;
    private ArrayList<Runnak> rünnakud;

    Voistleja(String nimi, int käigupunktid, ArrayList<Kaitse> kaitsed, ArrayList<Runnak> rünnakud) {
        this.nimi = nimi;
        this.käigupunktid = käigupunktid;
        this.kaitsed = kaitsed;
        this.rünnakud = rünnakud;
    }

    public String getNimi() {
        return nimi;
    }
    public int getKäigupunktid() {
        return käigupunktid;
    }

    public ArrayList<Kaitse> getKaitsed() {
        return kaitsed;
    }

    public ArrayList<Runnak> getRünnakud() {
        return rünnakud;
    }

    public int getElud() {
        return elud;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void kaotaElu(int elud) {
        this.elud = elud - 1;
    }

    public String toString() {
        return "Nimi: " + nimi + "\n" +
                "Elusid: " + elud + "\n" +
                "Võistleja käigupunktid: " + käigupunktid;
    }
}
