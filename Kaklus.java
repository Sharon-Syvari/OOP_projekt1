import java.util.Random;

public class Kaklus {
    // Võistleja[] võisltejad = new Võistleja[2];

    //Alustaja määramine

    //Võistleja alustaja = võistlejad[Math.round(Math.random())];

    public int kasutajaRünnak() {
        Random rand = new Random();
        if (tugevus > 12)
            int rünnakutugevus = 8 + rand.nextInt(tugevus - 8);
        else
            int rünnakutugevus = 2 + rand.nextInt(tugevus - 2);
        return 0;
    }

    public int kasutajaKaitse() {
        return 0;
    }

    public int arvutiRünnak() {
        return 0;
    }

    public int arvutiKaitse() {
        return 0;
    }


/*
    public static void main(String[] args) {
    }*/
}