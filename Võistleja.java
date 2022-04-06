package src.Rühmatöö_1;

import src.Rühmatöö_1.Kaitsed;
import src.Rühmatöö_1.Rünnakud;

import java.util.ArrayList;

public class Võistleja {

    private String nimi;
    private int elud = 3;
    private int käigupunktid;
    private Kaitsed[] kaitsed = new Kaitsed[3];
    private Rünnakud[] rünnakud = new Rünnakud[3];

    Võistleja(String nimi, int käigu_punktid, Kaitsed[] kaitsed, Rünnakud[] rünnakud) {
        this.nimi = nimi;
        this.käigupunktid = käigu_punktid;

    }

    public int getElud() {
        return elud;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String toString() {
        return "Võislteja nimi: " + nimi + "\n" +
                "Võislteja elud: " + elud + "\n" +
                "Võistleja käigupunktid: " + käigupunktid;
    }
}
