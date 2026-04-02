package pl.nikodem.finance;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaction> historiaTransakcji = new ArrayList<>();
        boolean programDziała = true;

        File plik = new File("finanse.csv");
        if (plik.exists()) {
            try (Scanner fileScanner = new Scanner(plik)) {
                while (fileScanner.hasNextLine()) {
                    String linia = fileScanner.nextLine();
                    String[] czesci = linia.split(";");
                    double kwota = Double.parseDouble(czesci[0]);
                    String kategoria = czesci[1];
                    String opis = czesci[2];
                    String data = czesci[3];
                    boolean czyToDochod = Boolean.parseBoolean(czesci[4]);
                    historiaTransakcji.add(new Transaction(kwota, kategoria, opis, data, czyToDochod));
                }
                System.out.println("Wczytano poprzednie transakcje!");
            } catch (FileNotFoundException e) {
                System.out.println("Błąd: nie znaleziono pliku!");
            }
        }

        while (programDziała) {
            System.out.println("\n--- MENU GŁÓWNE ---");
            System.out.println("1. Dodaj transakcję");
            System.out.println("2. Pokaż historię i saldo");
            System.out.println("3. Zapisz i wyjdź");
            System.out.print("Wybierz opcję: ");

            int wybór = scanner.nextInt();
            scanner.nextLine();

            switch (wybór) {
                case 1:
                    boolean czyDodaćKolejną = true;
                    while (czyDodaćKolejną) {
                        System.out.println("=== DODAWANIE WPISU ===");
                        System.out.print("Podaj kwotę: ");
                        double kwota = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Podaj kategorię: ");
                        String kategori = scanner.nextLine();

                        System.out.print("Podaj opis: ");
                        String opis = scanner.nextLine();

                        System.out.print("Podaj datę: ");
                        String data = scanner.nextLine();

                        System.out.print("Czy jest to dochód (true/false): ");
                        boolean czyToDochod = scanner.nextBoolean();
                        scanner.nextLine();

                        historiaTransakcji.add(new Transaction(kwota, kategori, opis, data, czyToDochod));

                        System.out.print("Czy dodać kolejną? (true/false): ");
                        czyDodaćKolejną = scanner.nextBoolean();
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    double saldoAktualne = 0.0;
                    System.out.println("\n--- TWOJA HISTORIA ---");
                    for (Transaction t : historiaTransakcji) {
                        System.out.println(t);
                        if (t.isCzyToDochod()) {
                            saldoAktualne += t.getKwota();
                        } else {
                            saldoAktualne -= t.getKwota();
                        }
                    }
                    System.out.println("---------------------------------");
                    System.out.println("STAN KONTA: " + saldoAktualne + " PLN");
                    break;

                case 3:
                    System.out.println("Zapisywanie danych i zamykanie...");
                    programDziała = false;
                    break;

                default:
                    System.out.println("Nieprawidłowy wybór!");
                    break;
            }
        }

        try (PrintWriter writer = new PrintWriter("finanse.csv")) {
            for (Transaction t : historiaTransakcji) {
                writer.println(t.getKwota() + ";" + t.getKategoria() + ";" + t.getOpis() + ";" + t.getData() + ";" + t.isCzyToDochod());
            }
            System.out.println("Dane zostały bezpiecznie zapisane.");
        } catch (IOException e) {
            System.out.println("Błąd zapisu pliku!");
        }
    }
}