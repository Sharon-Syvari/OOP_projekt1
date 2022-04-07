import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Kaklus {
    // Võistleja[] võisltejad = new Võistleja[2];

    //Alustaja määramine

    //Võistleja alustaja = võistlejad[Math.round(Math.random())];

    /**
     *
     * @param kasutaja Võistleja tüüpi objekt, kelleks on kasutaja
     * @param arvuti Rühmakaaslase tüüpi objekt, kelleks on arvuti
     * @param arvutiKäiguTugevus genereeritud käigutugevus
     * @param kasutajaKäigutugevus genereeritud käigutugevus
     * @param arvutiRünnak kas arvuti ründab (false'i puhul kaitseb)
     * @param kasutajaRünnak kas kasutaja ründab (false'i puhul kaitseb)
     *
     * Võrreldakse kasutaja ja arvuti käiku
     *                       1) arvuti ründab, kasutaja kaitseb –> nõrgema käigutugevusega kaotab elu
     *                       2) arvuti kaitseb, kasutaja ründab –> nõrgema käigutugevusega kaotab elu
     *                       3) arvuti ründab, kasutaja ründab –> nõrgema käigutugevusega kaotab elu
     *                       4) arvuti kaitseb, kasutaja kaitseb —> kumbki ei kaota elu
     */
    public void kasutajaVõidabKäigu(Võistleja kasutaja, Rühmakaaslane arvuti, int arvutiKäiguTugevus, int kasutajaKäigutugevus, boolean arvutiRünnak, boolean kasutajaRünnak) {
        System.out.println("----------");
        System.out.println("Käigu tulemus: ");

        // Arvuti ja kasutaja mõlemad kaitsevad
        if (arvutiRünnak == false && kasutajaRünnak == false)
            System.out.println("Viik");
        else {
            // Arvuti ründab edukalt, kasutaja ründab või kaitseb
            if (arvutiKäiguTugevus > kasutajaKäigutugevus && arvutiRünnak) {
                System.out.println(arvuti.getNimi() + "võidab käigu!");
                // KASUTAJA KAOTAB ELU
            }
            // Kasutaja ründab edukalt, arvuti ründab või kaitseb
            else if (arvutiKäiguTugevus > kasutajaKäigutugevus && kasutajaRünnak) {
                System.out.println(kasutaja.getNimi() + "võidab käigu!");
                // ARVUTI KAOTAB ELU
            }

            // Kasutaja või arvuti ründab nõrgemalt kui vastase kaitse
            else if ((arvutiKäiguTugevus < kasutajaKäigutugevus && kasutajaRünnak == false) || (arvutiKäiguTugevus > kasutajaKäigutugevus && arvutiRünnak == false)) {
                System.out.println("Viik");
            }
        }
    }

    /**
     * Genereerib juhuslikult läägitugevuse (sõltuvalt kas on nõrk või tugev rünnak)
     *
     * @param rünnak kasutaja valitud rünnak
     * @return tagastab valitud rünnakuga tehtud löögi tugevuse (int kaitsetugevus)
     */
    public int kasutajaRünnak(Rünnak rünnak) {
        System.out.println("Valitud rünnak: " + rünnak.getNimetus());
        Random rand = new Random();

        // Juhusliku rünnakutugevuse genereerimine
        int rünnakutugevus;
        if (rünnak.getTugevus() > 12)
            rünnakutugevus = 8 + rand.nextInt(rünnak.getTugevus() - 8);
        else
            rünnakutugevus = 2 + rand.nextInt(rünnak.getTugevus() - 2);
        System.out.println("Rünnaku tugevus: " + rünnakutugevus);
        return rünnakutugevus;
    }

    /**
     * Genereerib juhuslikult kaitsetugevuse (sõltuvalt kas on nõrk või tugev kaitse)
     *
     * @param kaitse kasutaja valitud kaitse
     * @return tagastab valitud kaitse tugevuse (int kaitsetugevus)
     */
    public int kasutajaKaitse(Kaitse kaitse) {
        System.out.println("Valitud kaitse: " + kaitse.getNimetus());
        Random rand = new Random();

        // Juhusliku kaitsetugevuse genereerimine
        int kaitsetugevus;
        if (kaitse.getTugevus() > 12)
            kaitsetugevus = 8 + rand.nextInt(kaitse.getTugevus() - 8);
        else
            kaitsetugevus = 1 + rand.nextInt(kaitse.getTugevus() - 1);
        System.out.println("Kaitse tugevus: " + kaitsetugevus);
        return kaitsetugevus;
    }

    /**
     * Genereerib juhuslikult rünnaku ning selle tugevuse (eristus nõrgal ja tugeval ründel)
     *
     *
     * @param arvuti vastase objekt, millest kasutatakse vastase rünnakute ArrayList'i
     * @return tagastab rünnaku tugevuse (int rünnakutugevus)
     */
    public int arvutiRünnak(Rühmakaaslane arvuti) {
        Random rand = new Random();
        ArrayList<Rünnak> rünnakud = arvuti.getRünnakud();
        boolean sobivRünnak = false;
        Rünnak valitudRünnak = null;
        while (sobivRünnak == false) {
            valitudRünnak = rünnakud.get(rand.nextInt(rünnakud.size() - 1));
            if (valitudRünnak.getTugevus() <= arvuti.getKäigupunktid())
                sobivRünnak = true;
        }
        System.out.println("Valitud rünnak: " + valitudRünnak.getNimetus());

        // Juhusliku rünnakutugevuse genereerimine
        int rünnakutugevus;
        if (valitudRünnak.getTugevus() > 12)
            rünnakutugevus = 8 + rand.nextInt(valitudRünnak.getTugevus() - 8);
        else
            rünnakutugevus = 1 + rand.nextInt(valitudRünnak.getTugevus() - 1);
        System.out.println("Rünnaku tugevus: " + rünnakutugevus);
        return rünnakutugevus;
    }

    /**
     * Genereerib juhuslikult kaitse ning selle tugevuse (eristus nõrgal ja tugeval kaitsel)
     *
     *
     * @param arvuti vastase objekt, millest kasutatakse vastase kaitse ArrayList'i
     * @return tagastab kaitse tugevuse (int kaitsetugevus)
     */
    public int arvutiKaitse(Rühmakaaslane arvuti) {
        Random rand = new Random();
        ArrayList<Kaitse> kaitsed = arvuti.getKaitsed();
        boolean sobivKaitse = false;
        Kaitse valitudKaitse = null;
        while (sobivKaitse == false) {
            valitudKaitse = kaitsed.get(rand.nextInt(kaitsed.size() - 1));
            if (valitudKaitse.getTugevus() <= arvuti.getKäigupunktid())
                sobivKaitse = true;
        }

        // Juhusliku kaitsetugevuse genereerimine
        System.out.println("Valitud kaitse: " + valitudKaitse.getNimetus());
        int kaitsetugevus;
        if (valitudKaitse.getTugevus() > 12)
            kaitsetugevus = 8 + rand.nextInt(valitudKaitse.getTugevus() - 8);
        else
            kaitsetugevus = 2 + rand.nextInt(valitudKaitse.getTugevus() - 2);
        System.out.println("Kaitse tugevus: " + kaitsetugevus);
        return kaitsetugevus;
    }


/*
    public static void main(String[] args) {
    }*/
}
