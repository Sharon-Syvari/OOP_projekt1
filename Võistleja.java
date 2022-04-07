import java.util.ArrayList;

public class Võistleja {

    private String nimi;
    private int elud = 3;
    private int käigupunktid;
    private ArrayList<Kaitse> kaitsed;
    private ArrayList<Rünnak> rünnakud;

    Võistleja(String nimi, int käigu_punktid, ArrayList<Kaitse> kaitsed, ArrayList<Rünnak> rünnakud) {
        this.nimi = nimi;
        this.käigupunktid = käigu_punktid;
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

    public ArrayList<Rünnak> getRünnakud() {
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
