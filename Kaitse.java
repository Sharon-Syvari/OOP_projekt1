package src.Ruhmatoo1;

public class Kaitse {
    private String nimetus;
    private int tugevus;

    public Kaitse(String nimetus, int tugevus) {
        this.nimetus = nimetus;
        this.tugevus = tugevus;
    }

    public String getNimetus() {
        return nimetus;
    }

    public int getTugevus() {
        return tugevus;
    }

    @Override
    public String toString() {
        return nimetus + " (Tugevus: "+ tugevus + ")";
    }
}
