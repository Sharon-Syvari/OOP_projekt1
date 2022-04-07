import java.io.File;
import java.util.*;

public class Peaklass {

    public static List<Rünnakud> loeRünnakud(String failinimi) throws Exception {
        List<Rünnakud> tulemus = new ArrayList<Rünnakud>();
        File file = new File(failinimi);
        try (Scanner s = new Scanner(file, "UTF-8")) {
            while (s.hasNextLine()) {
                String rida = s.nextLine();
                String[] atribuudid = rida.split(";"); //rünnak kujul nimetus;tase;tugevus
                tulemus.add(new Rünnakud(atribuudid[0], Integer.parseInt(atribuudid[1])));
            }
        }
        return tulemus;
    }

    public static List<Kaitsed> loeKaitsed(String failinimi) throws Exception {
        List<Kaitsed> tulemus = new ArrayList<Kaitsed>();
        File file = new File(failinimi);
        try (Scanner s = new Scanner(file, "UTF-8")) {
            while (s.hasNextLine()) {
                String rida = s.nextLine();
                String[] atribuudid = rida.split(";"); //rünnak kujul nimetus;tase;tugevus
                tulemus.add(new Kaitsed(atribuudid[0], Integer.parseInt(atribuudid[1])));
            }
        }
        return tulemus;
    }

    public static void main(String[] args) throws Exception {

        Random rand = new Random();

        // Projektid
        String[] projektid = {"Eesti Nokia", "Metsaistutamisklubi kaardirakendus", "Interneti väljaprintimine", "Duell rühmakaaslasega", "Saa Hegeli ajaloofilosoofiast aru kolme minutiga", "Kuidas võita inimesi ja mõjutada sõpru", "N-mõõtmeline tetris"};

        // Loeb failist rünnakud ja kaitsed
        ArrayList<Rünnakud> rünnakud = (ArrayList<Rünnakud>) loeRünnakud("rynnakud.txt");
        ArrayList<Kaitsed> kaitsed = (ArrayList<Kaitsed>) loeKaitsed("kaitsed.txt");

        // Juhuslikud rünnakud ja kaitsed kasutajale (1 tugev ja 2 nõrka rünnet ja kaitset)
        ArrayList<Kaitsed> kaitsedKasutajale = new ArrayList<Kaitsed>();
        ArrayList<Rünnakud> ründedKasutajale = new ArrayList<Rünnakud>();
        int loendaTugevaid = 0;
        int loendaNõrku = 0;
        while (loendaNõrku < 2 && loendaTugevaid < 1) {
            Kaitsed lisa = kaitsed.get(rand.nextInt((kaitsed.size() - 1)));
            if (lisa.getTugevus() > 12 && loendaTugevaid < 1) {
                kaitsedKasutajale.add(lisa);
                loendaTugevaid += 1;
            }
            else if (lisa.getTugevus() <= 12 && loendaNõrku < 2) {
                kaitsedKasutajale.add(lisa);
                loendaTugevaid += 1;
            }
        }

        loendaTugevaid = 0;
        loendaNõrku = 0;
        while (loendaNõrku < 2 && loendaTugevaid < 1) {
            Rünnakud lisa = rünnakud.get(rand.nextInt((rünnakud.size() - 1)));
            if (lisa.getTugevus() > 12 && loendaTugevaid < 1) {
                ründedKasutajale.add(lisa);
                loendaTugevaid += 1;
            }
            else if (lisa.getTugevus() <= 12 && loendaNõrku < 2) {
                ründedKasutajale.add(lisa);
                loendaTugevaid += 1;
            }
        }

        // Jagab rünnakud ja kaitsed kolme rühmaliikme vahel
        ArrayList<Kaitsed> kaitsedEsimesele = new ArrayList<Kaitsed>();
        kaitsedEsimesele.add(kaitsed.get(0));
        kaitsedEsimesele.add(kaitsed.get(1));
        kaitsedEsimesele.add(kaitsed.get(6));

        ArrayList<Kaitsed> kaitsedTeisele = new ArrayList<Kaitsed>();
        kaitsedEsimesele.add(kaitsed.get(2));
        kaitsedEsimesele.add(kaitsed.get(3));
        kaitsedEsimesele.add(kaitsed.get(7));

        ArrayList<Kaitsed> kaitsedKolmandale = new ArrayList<Kaitsed>();
        kaitsedEsimesele.add(kaitsed.get(4));
        kaitsedEsimesele.add(kaitsed.get(5));
        kaitsedEsimesele.add(kaitsed.get(8));

        //Ründed
        ArrayList<Rünnakud> ründedEsimesele = new ArrayList<Rünnakud>();
        ründedEsimesele.add(rünnakud.get(0));
        ründedEsimesele.add(rünnakud.get(1));
        ründedEsimesele.add(rünnakud.get(6));

        ArrayList<Rünnakud> ründedTeisele = new ArrayList<Rünnakud>();
        ründedTeisele.add(rünnakud.get(2));
        ründedTeisele.add(rünnakud.get(3));
        ründedTeisele.add(rünnakud.get(7));

        ArrayList<Rünnakud> ründedKolmandale = new ArrayList<Rünnakud>();
        ründedKolmandale.add(rünnakud.get(4));
        ründedKolmandale.add(rünnakud.get(5));
        ründedKolmandale.add(rünnakud.get(8));


        Rühmakaaslane kaaslane1 = new Rühmakaaslane("Peeter", 15, kaitsedEsimesele, ründedEsimesele, "Madal");
        Rühmakaaslane kaaslane2 = new Rühmakaaslane("Minni", 25, kaitsedTeisele, ründedTeisele, "Keskmine");
        Rühmakaaslane kaaslane3 = new Rühmakaaslane("Bobiina", 35, kaitsedKolmandale, ründedKolmandale, "Geenius");

        Rühmakaaslane[] kaaslased = {kaaslane1, kaaslane2, kaaslane3};

        //Mingi jutt alustuseks

        //Esitletakse reeglid:
        System.out.println("----------");
        System.out.println("RÜHMATÖÖ MÄNG"); //+ "\n" +
        System.out.println("----------");

        System.out.println("Mängu reeglid:" + "\n");
        System.out.println(
                "1. Valid enda tegelasele nime" + "\n" +
                "2. Valid endale rühmakaaslase" + "\n" +
                "3. Rühmakaaslase kõrgelennulisuse põhjal loositakse Sulle uudne IT-teemaline projektiidee," + "\n" +
                "mis võib hakata sisse tooma miljoneid või hoopis mõned kopikad." + "\n" +
                "Rahasumma kujutab endast punktide hulka, mis Sa võidad, kui oma rühmakaaslasele pähe teed." + "\n" +
                "4. Loositakse esimene ründaja" + "\n" +
                "5. Igal käigul üks võistleja ründab ja teine kaitseb." + "\n" +
                "Kasutaja saab valida kummalgi korral kas ühe terve käigu või" + "\n" +
                "kaks osalist käiku. Käikudel on kindlad tugevused, mis määrab punktide vahemiku," + "\n" +
                "mille hulgast loositakse käigi lõplik punktide hulk. Näiteks kui valida käik 1," + "\n" +
                "mille tugevus on 10, siis sellest vahemikust loositakse punktid." + "\n" +
                "Valikud antakse ette käigu ajal ning valiku tegemiseks tuleb sisestada käigule vastav number." + "\n" +
                "6. Mõlema rühmaliikme saadud punktid avaldatakse korraga ning 1 elu kaotab see," + "\n" +
                "kelle punktide hulk on väiksem. Võrdse seisu korral ei kaota kumbki." + "\n" +
                "7. Kaotab see, kes esimesena kõikidest eludest ilma jääb."
        );

        //Küsitakse kasutaja nime
        Scanner scan = new Scanner(System.in);
        System.out.println("Kirjutage oma nimi: ");
        String kasutajanimi = scan.nextLine();

        // Kasutaja võistleja loomine
        Võistleja kasutaja = new Võistleja(kasutajanimi, 20, kaitsedKasutajale, ründedKasutajale);

        //Lastakse valida rühmakaaslane(int) ning väljastatakse selleks valikud
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Tere, " + kasutajanimi + "! On aeg alustada kursuse rühmatööga.");
        System.out.println("Selleks tuleb endale paariline valida.");
        System.out.println("Võimalikud rühmakaaslased on:");
        System.out.println("");
        for (int i = 0; i < kaaslased.length; i++) {
            System.out.print((i + 1) + ") ");
            System.out.println(kaaslased[i]);
            System.out.println("");
        }

        System.out.println("Sisesta enda valitud rühmakaaslase number:");
        int rühmakaasklase_nr = scan.nextInt();
        Rühmakaaslane vastane = kaaslased[rühmakaasklase_nr - 1];
        System.out.println("----------");
        System.out.println("Sinu rühmakaaslane: " + vastane.getNimi());

        // Loositakse projekt ning juhuslikult leitakse selle rahaline väärtus sõltuvalt rühmakaaslase kõrgelennulisusele
        int valitudProjekt = rand.nextInt(projektid.length - 1);
        int teenitudMiljonid = 0;

        // Mida "kõrgelennulisem" on rühmakaaslane, seda rohkem tulu teenitakse
        if (kaaslased[rühmakaasklase_nr - 1].getKõrgelennulisus() == "Madal")
            teenitudMiljonid = (int) (Math.random() * 10 * 1000000);
        else if (kaaslased[rühmakaasklase_nr - 1].getKõrgelennulisus() == "Keskmine")
            teenitudMiljonid = (int) (Math.random() * 100 * 1000000);
        else
            teenitudMiljonid = (int) (Math.random() * 1000 * 1000000);

        System.out.println("----------");
        System.out.println("Pärast rasket tööd valmis teil projekt '" + projektid[valitudProjekt] + "'.");
        System.out.println("Teenisite projektiga " + teenitudMiljonid + " eurot.");
        System.out.println("----------");
        System.out.println("OH HÄDA! Sina ja " + vastane.getNimi() + " ei suuda oma teenitud miljoneid ära jagada!");
        System.out.println("On aeg asuda võitlema!");

        //Mäng algab.
        //Loositakse alustaja ja antakse tulemusest ekraanil teada
        boolean alustabArvuti;

        if (Math.random() > 0.5) {
            alustabArvuti = true;
            System.out.println("Oma käiku alustab " + vastane.getNimi() + "!");
        }
        else {
            alustabArvuti = false;
            System.out.println("Oma käiku alustad sina, " + kasutajanimi + "!");
        }

        //Igal korral lastakse valida kasutajal rünnaku - või kaitsevõte
        // ja selle põhjal loositakse tema punktid

        if (alustabArvuti == true) {
            while (vastane.getElud() > 0 && kasutaja.getElud() > 0) {
            }
        } else {
            while (vastane.getElud() > 0 && kasutaja.getElud() > 0) {
            }
        }

        if (kasutaja.getElud() == 0) {
            System.out.println("Kaotasid mängu!");
            System.out.println("Kogu projektist teenitud tulu sai endale " + vastane.getNimi());
        }

        else {
            System.out.println("Võitsid mängu!");
            System.out.println("Said endale " + teenitudMiljonid + " eurot.");
        }


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