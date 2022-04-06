package src;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) throws Exception {
        List<Loom> loomadeList = loeLoomad("C:/Informaatika/Kevad/OOP/src/loomad.txt");

        Jahimees[] jahimehed = new Jahimees[3];

        Jahimees jahimees1 = new Jahimees("Mimi", 1000);
        jahimehed[0] = jahimees1;
        Jahimees jahimees2 = new Jahimees("Stuhle", 1000);
        jahimehed[1] = jahimees2;
        Jahimees jahimees3 = new Jahimees("Taavi", 1000);
        jahimehed[2] = jahimees3;

        for (int i = 0; i < jahimehed.length; i++) {
            Collections.shuffle(loomadeList);
            int loomadeHulk = loomadeList.size();
            for (int j = 0; j < 10; j++) {
                jahimehed[i].lisaLoom(loomadeList.get(j));
            }

        }
        for (int i = 0; i < jahimehed.length; i++) {
            System.out.println(jahimehed[i].toString());
        }
    }

    public static List<Loom> loeLoomad(String failinimi) throws Exception {
        List<Loom> tulemus = new ArrayList<>();
        File file = new File(failinimi);
        try (Scanner s = new Scanner(file, "UTF-8")) {
            while (s.hasNextLine()) {
                String rida = s.nextLine();
                String[] tükid = rida.split(",");
                if (tükid.length == 3) {
                    tulemus.add(new Kiskja(tükid[0], Integer.parseInt(tükid[1]), Double.parseDouble(tükid[2])));
                } else {
                    tulemus.add(new Herbivoor(tükid[0], Integer.parseInt(tükid[1]), Integer.parseInt(tükid[2]), Double.parseDouble(tükid[3])));
                }
            }
        }
        return tulemus;
    }

}
