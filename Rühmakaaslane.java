import java.util.ArrayList;

public class Rühmakaaslane extends Võistleja {

    private String kõrgelennulisus;

    Rühmakaaslane(String nimi, int käigupunktid, ArrayList<Kaitse> kaitsed, ArrayList<Rünnak> rünnakud, String kõrgelennulisus) {
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
