package src.Ruhmatoo1;

public class Runnak {
    private String nimetus;
    private int tugevus;

    public Runnak(String nimetus, int tugevus) {
        this.nimetus = nimetus;
        this.tugevus = tugevus;
    }

    public int getTugevus() {
        return tugevus;
    }

    public String getNimetus() {
        return nimetus;
    }


    @Override
    public String toString() {
        return nimetus + " (Tugevus: "+ tugevus + ")";
    }
}
