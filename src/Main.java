import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File slownik = new File("C:\\Users\\mszga\\IdeaProjects\\Wisielec_gra\\src\\slownik.txt");

        Scanner scanner = new Scanner(slownik);
        Scanner input = new Scanner(System.in);

        ArrayList<String> slowa = new ArrayList<>();
        while (scanner.hasNextLine()) {
            slowa.add(scanner.nextLine());
        }

        String ukryty_text = slowa.get((int) Math.random() * slowa.size());
        char[] textArray = ukryty_text.toCharArray();

        char[] odpowiedzi = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            odpowiedzi[i] = '?';
        }

        boolean koniec = false;
        int zycia = 6;

        while (koniec == false) {
            System.out.println("**********************");

            String litera = input.next();
            // Sprawdzanie poprawności wprowadzenia litery
            while (litera.length() != 1 || Character.isDigit(litera.charAt(0))) {
                System.out.println("Spróbuj ponownie wprowadzić literę");
                litera = input.next();
            }
            //sprawdzanie czy litera jest w słowie
            boolean znaleziono = false;
            for (int i = 0; i < textArray.length; i++) {
                if (litera.charAt(0) == textArray[i]) {
                    odpowiedzi[i] = textArray[i];
                    znaleziono = true;
                }
            }

            if (!znaleziono) {
                zycia--;

                System.out.println("Błędna litera");
            }
            boolean zrobiono = true;
            for (int i = 0; i < odpowiedzi.length; i++) {
                if (odpowiedzi[i] == '?') {
                    System.out.println("_");
                    zrobiono = false;
                } else {
                    System.out.println(" " + odpowiedzi[i]);
                }
            }
            System.out.println("\n" + "Pozostało prób: " + zycia);
            drawHangman(zycia);

            //sprawdzanie czy gra się zakończyła
            if (zrobiono) {
                System.out.println("Gratulacje! Znalazłeś odpowiednie słowo");
                zrobiono = true;
            }

            if (zycia <= 0) {
                System.out.println("Przegrałeś.");
                zrobiono = true;
            }
        }
    }
        public static void drawHangman(int l) {
            if(l == 6) {
                System.out.println("|----------");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            else if(l == 5) {
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            else if(l == 4) {
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|    |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            else if(l == 3) {
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|   -|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            else if(l == 2) {
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|   -|-");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            else if(l == 1) {
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|   -|-");
                System.out.println("|   /");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            else{
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|   -|-");
                System.out.println("|   /|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
        }
    }
