import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //2. feladat
        Scanner sc = new Scanner(System.in);
        List<Bejegyzes> bejegyzes_lista = new ArrayList<Bejegyzes>();
        List<Bejegyzes> bejegyzes_lista2 = new ArrayList<Bejegyzes>();

        System.out.println("Adjon meg egy számot");
        try {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.println("Adja meg a szerző nevét");
                String nev = sc.next();
                System.out.println("Adja meg a tartalmat");
                String tartalmat = sc.next();
                bejegyzes_lista.add(new Bejegyzes(nev, tartalmat));
            }

        } catch (InputMismatchException e) {
            System.out.println("Természetes számot adjon meg!");
        }
        System.out.println(bejegyzes_lista);

        try {
            File f = new File("bejegyzesek.csv");
            Scanner sc2 = new Scanner(f);
            while (sc2.hasNextLine()) {
                String line = sc2.nextLine();
                String[] split = line.split(";");
                bejegyzes_lista2.add(new Bejegyzes(split[0], split[1]));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Random r = new Random();

        for (int i = 0; i < bejegyzes_lista2.size()*20; i++) {
            bejegyzes_lista2.get(r.nextInt(bejegyzes_lista2.size())).Like();
        }

        System.out.println("Adja meg a 2. szöveg új tartalmát:");
        bejegyzes_lista2.get(1).setTartalom(sc.next());

        System.out.println(bejegyzes_lista2);

        //3. feladat

        Bejegyzes max = bejegyzes_lista2.get(0);
        for (Bejegyzes b : bejegyzes_lista2) {
            if (b.getLikes() > max.getLikes()) {
                max = b;
            }
        }
        System.out.println(max);

        boolean boll = false;
        boolean boll2 = false;
        for (Bejegyzes b : bejegyzes_lista2) {
            if (b.getLikes() > 35) {
                boll = true;
            }
            if (b.getLikes() < 15) {
                boll2 = true;
            }
        }
        if (!boll) {
            System.out.println("Nincs 35-nél nagyobb likeos bejegyzés.");
        }
        else {
            System.out.println("Van 35-nél nagyobb likeos bejegyzés.");
        }

        if (!boll2) {
            System.out.println("Nincs 15-nél kisebb likeos bejegyzés.");
        }
        else {
            System.out.println("Van 15-nél kisebb likeos bejegyzés.");
        }

        Collections.sort(bejegyzes_lista2, new Comparator<Bejegyzes>() {

            @Override
            public int compare(Bejegyzes o1, Bejegyzes o2) {
                return o1.getLikes() - o2.getLikes();
            }
        });

        System.out.println(bejegyzes_lista2);


        try {
            FileWriter myWriter = new FileWriter("bejegyzesek_rendezett.txt");
            for (Bejegyzes b : bejegyzes_lista2) {
                myWriter.write(b.toString());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //test
    }
}