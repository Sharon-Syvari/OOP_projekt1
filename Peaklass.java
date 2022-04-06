package src.Rühmatöö_1;

import src.Rühmatöö_1.Võistleja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) {
        // Siin vist luua erinevad vastased
        Võistleja võistleja1 = new Võistleja("Peeter", 15);
        Võistleja võistleja2 = new Võistleja("Minni", 25);
        Võistleja võistleja3 = new Võistleja("Bobiina", 35);

        Võistleja[] vastased = new Võistleja[];
        vastased[0] = võistleja1;
        vastased[1] = võistleja2;
        vastased[2] = võistleja3;

        Võistleja[] võistlejad = new Võistleja[2];

        //rünnakud ja kaitsed võiks vist loosida. 2 nõrka ja 1 tugev
        Kaitsed kaitse1 = new Kaitsed("kaitse1", 20);
        Kaitsed kaitse2 = new Kaitsed("kaitse2", 10);
        Kaitsed kaitse3 = new Kaitsed("kaitse3", 10);

        Rünnakud rünnak1 = new Rünnakud("rünnak1", 20);
        Rünnakud rünnak2 = new Rünnakud("rünnak2", 10);
        Rünnakud rünnak3 = new Rünnakud("rünnak3", 10);

        Kaitsed[] kõik_kaitsed = new Kaitsed[3];
        kõik_kaitsed[0] = kaitse1;
        kõik_kaitsed[1] = kaitse2;
        kõik_kaitsed[2] = kaitse3;

        //Mingi jutt alustuseks

        //Esitletakse reeglid:
        // 1. Valid enda tegelasele nime
        // 2. Valid endale vastase
        // 3. Vastase tugevuse põhjal loositakse Sulle uudne IT-teemaline projektiidee,
        // mis võib hakata sisse tooma miljoneid või hoopis mõned kopikad.
        // Rahasumma kujutab endast punktide hulka, mis Sa võidad, kui oma rühmakaaslasele pähe teed.
        // 4. Loositakse esimene ründaja
        // 5. Igal käigul üks võislteja ründab ja teine kaitseb.
        // Kasutaja saab valida kummalgi korral kas ühe terve käigu või
        // kaks osalist käiku. Käikudel on kindlad tugevused, mis määrab punktide vahemiku,
        // mille hulgast loositakse käigi lõplik punktide hulk. Näiteks kui valida käik 1,
        // mille tugevus on 10, siis sellest vahemikust loositakse punktid.
        // Valikud antakse ette käigu ajal ning valiku tegemiseks tuleb sisestada käigule vastav number.
        // 6. Mõlema rühmaliikme saadud punktid avaldatakse korraga ning 1 elu kaotab see,
        // kelle punktide hulk on väiksem. Võrdse seisu korral ei kaota kumbki.
        // 7. Kaotab see, kes esimesena kõikidest eludest ilma jääb.

        //Küsitakse kasutaja nime
        Scanner scan = new Scanner(System.in);
        System.out.println("Kirjutage oma nimi: ");
        String kasutajanimi = scan.nextLine();

        Võistleja kasutaja = new Võistleja(kasutajanimi, 25);
        võistlejad[0] = kasutaja;
        //Esitletakse kasutaja omadused
        

        //Lastakse valida vastane(int)
        //  Kaklus.võistlejad[1] = Võistleja(...)
        Scanner scan = new Scanner(System.in);
        System.out.println("Valige enda rühmakaaslane: ");
        System.out.print("1. ");
        võistleja1.toString();
        System.out.print("2. ");
        võistleja2.toString();
        System.out.print("3. ");
        int rühmakaasklase_nr = scan.nextInt();

        võistlejad[1] = vastased[rühmakaasklase_nr-1];

        //Mäng algab.
        //Loositakse alustaja ja antakse tulemusest ekraanil teada
        //Võistleja alustaja = võistlejad[(int) Math.round(Math.random())];



        //Igal korral lastakse valida kasutajal rünnaku - või kaitsevõte
        // ja selle põhjal loositakse tema punktid

        /** Kui alustab kasutaja
        if (alustaja == võistlejad[0]) {
            while (võistlejad[0].getElud() > 0 && võistlejad[0].getElud() > 0) {

            }

        }

        //Kui alustab arvuti
        if (alustaja == võistlejad[1]) {
            while (võistlejad[0].getElud() > 0 && võistlejad[0].getElud() > 0) {

            }
        }

        //Kaotab 1 elu see, kellel vähem punkte

        // Kui arvuti kaotab
        if (võistlejad[0].getElud() == 0) {

        } else { //kui kasutaja kaotab

        }*/
    }
}
