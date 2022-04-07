import java.util.ArrayList;

public class Rühmakaaslane extends Võistleja {

    private String kõrgelennulisus;

    Rühmakaaslane(String nimi, int käigu_punktid, ArrayList<Kaitsed> kaitsed, ArrayList<Rünnakud> rünnakud, String kõrgelennulisus) {
        super(nimi, käigu_punktid, kaitsed, rünnakud);
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