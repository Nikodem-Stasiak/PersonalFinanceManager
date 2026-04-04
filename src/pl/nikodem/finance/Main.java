package pl.nikodem.finance;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaction> historiaTransakcji = new ArrayList<>();
        boolean programDziała = true;

        File plik = new File("finanse.csv");
        if (plik.exists()) {
            try (Scanner fileScanner = new Scanner(plik, "ISO-8859-2")) {
                if (fileScanner.hasNextLine()) {
                    fileScanner.nextLine();
                }

                while (fileScanner.hasNextLine()) {
                    String linia = fileScanner.nextLine();
                    if (linia.trim().isEmpty()) continue;

                    String[] czesci = linia.split(";");

                    double kwotaRaw = Double.parseDouble(czesci[0].trim().replace(',', '.'));
                    double kwota = Math.abs(kwotaRaw);
                    String kategoria = czesci[1];
                    String opis = czesci[2];
                    String data = czesci[3];
                    boolean czyToDochod = Boolean.parseBoolean(czesci[4].trim());

                    historiaTransakcji.add(new Transaction(kwota, kategoria, opis, data, czyToDochod));
                }
                System.out.println("Wczytano " + historiaTransakcji.size() + " transakcji.");
            } catch (Exception e) {
                System.out.println("Problem przy wczytywaniu danych: " + e.getMessage());
            }
        }

        while (programDziała) {
            System.out.println("\n--- MENU GŁÓWNE ---");
            System.out.println("1. Dodaj transakcję");
            System.out.println("2. Pokaż historię i saldo");
            System.out.println("3. Zapisz i wyjdź");

            int wybor = 0;
            while (true) {
                try {
                    System.out.print("Wybierz opcję: ");
                    wybor = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Błąd podano nieznaną wartość:" + e.getMessage());
                }
            }

            switch (wybor) {
                case 1:
                    boolean czyDodaćKolejną = true;
                    while (czyDodaćKolejną) {
                        System.out.println("=== DODAWANIE WPISU ===");

                        double kwota = 0;
                        while (true) {
                            try {
                                System.out.print("Podaj kwotę: ");
                                String wejscie = scanner.nextLine().replace(',', '.');
                                kwota = Double.parseDouble(wejscie);
                                if (kwota > 0) {
                                    break;
                                } else {
                                    System.out.println("BŁĄD: Kwota musi być większa od zera!");
                                }
                            } catch (Exception e) {
                                System.out.println("Błąd: podano nieprawidłową wartość!");
                            }
                        }

                        String[] dostepneKategorie = {"Jedzenie", "Rozrywka", "Transport", "Rachunki", "Inne"};
                        String kategoriaWybrana = "";
                        int nr = 0;

                        while (true) {
                            System.out.println("--- WYBIERZ KATEGORIĘ ---");
                            for (int i = 0; i < dostepneKategorie.length; i++) {
                                System.out.println((i + 1) + "." + dostepneKategorie[i]);
                            }

                            try {
                                System.out.print("Wybierz numer: ");
                                nr = Integer.parseInt(scanner.nextLine());

                                if (nr >= 1 && nr <= dostepneKategorie.length) {
                                    break;
                                } else {
                                    System.out.println("BŁĄD: Wybierz poprawny numer z listy!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("BŁĄD: Musisz podać liczbę, a nie tekst!");
                            }
                        }

                        if (nr == dostepneKategorie.length) {
                            System.out.print("Podaj nazwę własnej kategorii: ");
                            kategoriaWybrana = scanner.nextLine().trim();
                            if (kategoriaWybrana.isEmpty()) {
                                kategoriaWybrana = "Inne";
                            }
                        } else {
                            kategoriaWybrana = dostepneKategorie[nr - 1];
                        }

                        System.out.print("Podaj opis: ");
                        String opis = scanner.nextLine();

                        System.out.print("Podaj datę (RRRR-MM-DD) [Enter dla dzisiaj: " + LocalDate.now() + "]: ");
                        String wejscieDaty = scanner.nextLine().trim();
                        String data;
                        if (wejscieDaty.isEmpty()) {
                            data = LocalDate.now().toString();
                        } else {
                            data = wejscieDaty;
                        }

                        boolean czyToDochod = false;
                        while (true) {
                            System.out.print("Czy jest to dochód? (tak/nie): ");
                            String odp = scanner.nextLine().toLowerCase().trim();

                            if (odp.equals("tak")) {
                                czyToDochod = true;
                                break;
                            } else if (odp.equals("nie")) {
                                czyToDochod = false;
                                break;
                            } else {
                                System.out.println("BŁĄD: Napisz 'tak' lub 'nie'!");
                            }
                        }

                        historiaTransakcji.add(new Transaction(kwota, kategoriaWybrana, opis, data, czyToDochod));

                        while (true) {
                            System.out.print("Czy dodać kolejną transakcję? (tak/nie): ");
                            String wejscie = scanner.nextLine().toLowerCase().trim();

                            if (wejscie.equals("tak")) {
                                czyDodaćKolejną = true;
                                break;
                            } else if (wejscie.equals("nie")) {
                                czyDodaćKolejną = false;
                                break;
                            } else {
                                System.out.println("BŁĄD: Musisz wpisać 'tak' lub 'nie'!");
                            }
                        }
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

        try (PrintWriter writer = new PrintWriter("finanse.csv", "ISO-8859-2")) {
            writer.println("Kwota;Kategoria;Opis;Data;CzyToDochod");
            for (Transaction t : historiaTransakcji) {
                double kwotaDoZapisu = t.isCzyToDochod() ? t.getKwota() : -t.getKwota();
                String kwotaString = String.valueOf(kwotaDoZapisu).replace('.', ',');
                writer.println(kwotaString + ";" + t.getKategoria() + ";" + t.getOpis() + ";" + t.getData() + ";" + t.isCzyToDochod());
            }
        } catch (IOException e) {
            System.out.println("Błąd zapisu pliku!");
        }
    }
}