//Siin puudu kasutaja käigupunktidega asjatamine

import java.io.File;
import java.util.*;

public class Peaklass {

    public static List<Rünnak> loeRünnakud(String failinimi) throws Exception {
        List<Rünnak> tulemus = new ArrayList<Rünnak>();
        File file = new File(failinimi);
        try (Scanner s = new Scanner(file, "UTF-8")) {
            while (s.hasNextLine()) {
                String rida = s.nextLine();
                String[] atribuudid = rida.split(";"); //rünnak kujul nimetus;tase;tugevus
                tulemus.add(new Rünnak(atribuudid[0], Integer.parseInt(atribuudid[1])));
            }
        }
        return tulemus;
    }

    public static List<Kaitse> loeKaitsed(String failinimi) throws Exception {
        List<Kaitse> tulemus = new ArrayList<Kaitse>();
        File file = new File(failinimi);
        try (Scanner s = new Scanner(file, "UTF-8")) {
            while (s.hasNextLine()) {
                String rida = s.nextLine();
                String[] atribuudid = rida.split(";"); //rünnak kujul nimetus;tase;tugevus
                tulemus.add(new Kaitse(atribuudid[0], Integer.parseInt(atribuudid[1])));
            }
        }
        return tulemus;
    }


    private static int kasutajaKaitse(Kaitse kaitse) {
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

    private static int kasutajaRünnak(Rünnak rünnak) {
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

    private static int arvutiRünnak(Rühmakaaslane arvuti) {
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

    private static int arvutiKaitse(Rühmakaaslane arvuti) {
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

    private static int kesVõitis(int kasutajaPunktid, int arvutiPunktid) {
        int võitja;
        if (kasutajaPunktid > arvutiPunktid) {
            võitja = 1;
        } else if (kasutajaPunktid < arvutiPunktid) {
            võitja = -1;
        } else {
            võitja = 0;
        }
        return võitja;
    }

    public static void main(String[] args) throws Exception {

        Random rand = new Random();

        // Projektid
        String[] projektid = {"Eesti Nokia", "Metsaistutamisklubi kaardirakendus", "Interneti väljaprintimine", "Duell rühmakaaslasega", "Saa Hegeli ajaloofilosoofiast aru kolme minutiga", "Kuidas võita inimesi ja mõjutada sõpru", "N-mõõtmeline tetris"};

        // Loeb failist rünnakud ja kaitsed
        ArrayList<Rünnak> rünnakud = (ArrayList<Rünnak>) loeRünnakud("rynnakud.txt");
        ArrayList<Kaitse> kaitsed = (ArrayList<Kaitse>) loeKaitsed("kaitsed.txt");


        // Juhuslikud rünnakud ja kaitsed kasutajale (1 tugev ja 2 nõrka rünnet ja kaitset)
        ArrayList<Kaitse> kaitsedKasutajale = new ArrayList<Kaitse>();
        ArrayList<Rünnak> ründedKasutajale = new ArrayList<Rünnak>();

        int loendaTugevaid = 0;
        int loendaNõrku = 0;
        while (kaitsedKasutajale.size() < 3) {
            Kaitse lisa = kaitsed.get(rand.nextInt((kaitsed.size() - 1)));
            if (lisa.getTugevus() > 12 && loendaTugevaid < 1) {
                kaitsedKasutajale.add(lisa);
                loendaTugevaid += 1;
            }
            else if (lisa.getTugevus() <= 12 && loendaNõrku < 2) {
                kaitsedKasutajale.add(lisa);
                loendaNõrku += 1;
            }
        }

        loendaTugevaid = 0;
        loendaNõrku = 0;
        while (ründedKasutajale.size() < 3) {
            Rünnak lisa = rünnakud.get(rand.nextInt((rünnakud.size() - 1)));
            if (lisa.getTugevus() > 12 && loendaTugevaid < 1) {
                ründedKasutajale.add(lisa);
                loendaTugevaid += 1;
            }
            else if (lisa.getTugevus() <= 12 && loendaNõrku < 2) {
                ründedKasutajale.add(lisa);
                loendaNõrku += 1;
            }
        }

        // Jagab rünnakud ja kaitsed kolme rühmaliikme vahel

        // Kaitsed
        ArrayList<Kaitse> kaitsedEsimesele = new ArrayList<Kaitse>();
        kaitsedEsimesele.add(kaitsed.get(0));
        kaitsedEsimesele.add(kaitsed.get(1));
        kaitsedEsimesele.add(kaitsed.get(6));

        ArrayList<Kaitse> kaitsedTeisele = new ArrayList<Kaitse>();
        kaitsedTeisele.add(kaitsed.get(2));
        kaitsedTeisele.add(kaitsed.get(3));
        kaitsedTeisele.add(kaitsed.get(7));


        ArrayList<Kaitse> kaitsedKolmandale = new ArrayList<Kaitse>();
        kaitsedKolmandale.add(kaitsed.get(4));
        kaitsedKolmandale.add(kaitsed.get(5));
        kaitsedKolmandale.add(kaitsed.get(8));

        //Ründed
        ArrayList<Rünnak> ründedEsimesele = new ArrayList<Rünnak>();
        ründedEsimesele.add(rünnakud.get(0));
        ründedEsimesele.add(rünnakud.get(1));
        ründedEsimesele.add(rünnakud.get(6));

        ArrayList<Rünnak> ründedTeisele = new ArrayList<Rünnak>();
        ründedTeisele.add(rünnakud.get(2));
        ründedTeisele.add(rünnakud.get(3));
        ründedTeisele.add(rünnakud.get(7));

        ArrayList<Rünnak> ründedKolmandale = new ArrayList<Rünnak>();
        ründedKolmandale.add(rünnakud.get(4));
        ründedKolmandale.add(rünnakud.get(5));
        ründedKolmandale.add(rünnakud.get(8));


        Rühmakaaslane kaaslane1 = new Rühmakaaslane("Peeter", 15, kaitsedEsimesele, ründedEsimesele, "Madal");
        Rühmakaaslane kaaslane2 = new Rühmakaaslane("Minni", 25, kaitsedTeisele, ründedTeisele, "Keskmine");
        Rühmakaaslane kaaslane3 = new Rühmakaaslane("Bobiina", 35, kaitsedKolmandale, ründedKolmandale, "Geenius");

        Rühmakaaslane[] kaaslased = {kaaslane1, kaaslane2, kaaslane3};


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
                        "7. Kaotab see, kes esimesena kõikidest eludest ilma jääb." + "\n" +
                        "----------"
        );

        //Küsitakse kasutaja nime
        Scanner scan = new Scanner(System.in);
        System.out.println("Kirjutage oma nimi: ");
        String kasutajanimi = scan.nextLine();
        System.out.println("----------");

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




        if (alustabArvuti) {
            int käik = 1;
            while (vastane.getElud() > 0 && kasutaja.getElud() > 0) {


                if (käik % 2 == 0) { // kasutaja ründab, arvuti kaitseb
                    System.out.println("Sinu kord on rünnata!" + "\n" +
                                        "Sinu valikud: " + "\n" +
                                        " ");

                    int ründePunktid = 0;
                    for (int i = 0; i < ründedKasutajale.size(); i++) {
                        System.out.println(i+1 + ". " + ründedKasutajale.get(i));
                    }
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("Kirjuta oma ründevõtte number: ");
                    int ründeNr = scan.nextInt();

                    int punktid = kasutajaRünnak(ründedKasutajale.get(ründeNr-1));
                    ründePunktid += punktid;

                    int kaitsePunktid = arvutiKaitse(vastane);

                    int tulemus = kesVõitis(ründePunktid, kaitsePunktid);
                    String nimi = vastane.getNimi();
                    if (tulemus == 1) {
                        System.out.println("Õnnitlused! Sina võitsid käigu! " + nimi + " kaotas 1 elu.");
                        vastane.kaotaElu(vastane.getElud());
                    } else if (tulemus == -1) {

                        System.out.println("Läks kehvasti, " + nimi + " oli Sinust tugevam. Kaotasid 1 elu.");
                        kasutaja.kaotaElu(kasutaja.getElud());
                    } else {
                        System.out.println("Viik! Kumbki ei kaotanud elusid.");
                    }
                    käik += 1;

                } else { // arvuti ründab, kasutaja kaitseb

                    System.out.println("Ründab " + vastane.getNimi() + "." + "\n" +
                                    "Sina kaitsed. " + "\n" +
                                    " ");

                    int kaitsePunktid = 0;
                    System.out.println("Sinu valikud on: ");
                    for (int i = 0; i < kaitsedKasutajale.size(); i++) {
                        System.out.println(i+1 + ". " + kaitsedKasutajale.get(i));
                    }
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("Kirjuta oma kaitsevõtte number: ");
                    int kaitseNr = scan.nextInt();

                    int punktid = kasutajaKaitse(kaitsedKasutajale.get(kaitseNr-1));
                    kaitsePunktid += punktid;

                    /* kasutaja.getKäigupunktid() -= punktid;

                    if (kaitsedKasutajale.get(kaitseNr-1).getTugevus() <= 12 && valitudVõtted.size() == 1) {
                        Scanner scan4 = new Scanner(System.in);
                        System.out.println("Vali enda kaitsevõte: ");
                        int kaitseNr2 = scan.nextInt(); */ /** POOLELI SEE ET KAS SAAB VEEL ÜHE KÄIGU VALIDA**/

                    int ründePunktid = arvutiRünnak(vastane);

                    int tulemus = kesVõitis(kaitsePunktid, ründePunktid);
                    String nimi = vastane.getNimi();
                    if (tulemus == 1) {
                        System.out.println("Õnnitlused! Sina võitsid käigu! " + nimi + " kaotas 1 elu.");
                        vastane.kaotaElu(vastane.getElud());
                    } else if (tulemus == -1) {

                        System.out.println("Läks kehvasti, " + nimi + " oli Sinust tugevam. Kaotasid 1 elu.");
                        kasutaja.kaotaElu(kasutaja.getElud());
                    } else {
                        System.out.println("Viik! Kumbki ei kaotanud elusid.");
                    }
                    käik += 1;

                }
            }

        } else {
            int käik = 1;
            while (vastane.getElud() > 0 && kasutaja.getElud() > 0) {


                if (käik % 2 != 0) { // kasutaja ründab, arvuti kaitseb
                    System.out.println("Sinu kord on rünnata!" + "\n" +
                            "Sinu valikud: " + "\n" +
                            " ");

                    int ründePunktid = 0;
                    for (int i = 0; i < ründedKasutajale.size(); i++) {
                        System.out.println(i+1 + ". " + ründedKasutajale.get(i));
                    }
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("Kirjuta oma ründevõtte number: ");
                    int ründeNr = scan.nextInt();

                    int punktid = kasutajaRünnak(ründedKasutajale.get(ründeNr-1));
                    ründePunktid += punktid;

                    int kaitsePunktid = arvutiKaitse(vastane);

                    int tulemus = kesVõitis(ründePunktid, kaitsePunktid);
                    String nimi = vastane.getNimi();
                    if (tulemus == 1) {
                        System.out.println("Õnnitlused! Sina võitsid käigu! " + nimi + " kaotas 1 elu.");
                        vastane.kaotaElu(vastane.getElud());
                    } else if (tulemus == -1) {

                        System.out.println("Läks kehvasti, " + nimi + " oli Sinust tugevam. Kaotasid 1 elu.");
                        kasutaja.kaotaElu(kasutaja.getElud());
                    } else {
                        System.out.println("Viik! Kumbki ei kaotanud elusid.");
                    }
                    käik += 1;

                } else { // arvuti ründab, kasutaja kaitseb
                    System.out.println("Ründab " + vastane.getNimi() + "." + "\n" +
                            "Sina kaitsed. " + "\n" +
                            " ");

                    int kaitsePunktid = 0;
                    for (int i = 0; i < kaitsedKasutajale.size(); i++) {
                        System.out.println(i+1 + ". " + kaitsedKasutajale.get(i));
                    }
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("Kirjuta oma kaitsevõtte number: ");
                    int kaitseNr = scan.nextInt();

                    int punktid = kasutajaKaitse(kaitsedKasutajale.get(kaitseNr-1));
                    kaitsePunktid += punktid;

                    /* kasutaja.getKäigupunktid() -= punktid;

                    if (kaitsedKasutajale.get(kaitseNr-1).getTugevus() <= 12 && valitudVõtted.size() == 1) {
                        Scanner scan4 = new Scanner(System.in);
                        System.out.println("Vali enda kaitsevõte: ");
                        int kaitseNr2 = scan.nextInt(); */ /** POOLELI SEE ET KAS SAAB VEEL ÜHE KÄIGU VALIDA**/

                    int ründePunktid = arvutiRünnak(vastane);

                    int tulemus = kesVõitis(kaitsePunktid, ründePunktid);
                    String nimi = vastane.getNimi();
                    if (tulemus == 1) {
                        System.out.println("Õnnitlused! Sina võitsid käigu! " + nimi + " kaotas 1 elu.");
                        vastane.kaotaElu(vastane.getElud());
                    } else if (tulemus == -1) {

                        System.out.println("Läks kehvasti, " + nimi + " oli Sinust tugevam. Kaotasid 1 elu.");
                        kasutaja.kaotaElu(kasutaja.getElud());
                    } else {
                        System.out.println("Viik! Kumbki ei kaotanud elusid.");
                    }
                    käik += 1;

                }
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
    }
}
