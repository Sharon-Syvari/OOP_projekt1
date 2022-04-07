

public class Rünnak {
    private String nimetus;
    private int tugevus;

    public Rünnak(String nimetus, int tugevus) {
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

