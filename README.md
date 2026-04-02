# 💰 Personal Finance Manager v2.0

Zaawansowana aplikacja konsolowa w Javie do zarządzania budżetem osobistym. Program pozwala na pełną interakcję z użytkownikiem oraz zachowywanie danych między sesjami.

---

## 🚀 Nowe Funkcjonalności
* **System Menu**: Interaktywne menu główne sterowane liczbami (Switch-case).
* **Trwałość danych (Persistence)**: Automatyczny zapis i odczyt historii z pliku `finanse.csv`.
* **Dynamiczna Lista**: Zarządzanie nieograniczoną liczbą transakcji przy użyciu `ArrayList`.
* **Silnik Obliczeniowy**: Automatyczne przeliczanie salda końcowego na podstawie całej historii.

---

## 🛠️ Technologie
* **Język**: Java 21
* **I/O**: Java File, Scanner, PrintWriter (Obsługa plików CSV)
* **Struktury**: ArrayList, Programowanie Obiektowe (OOP)

---

## 📂 Struktura Pliku Danych
Dane są przechowywane w formacie CSV (Semicolon Separated):
`KWOTA;KATEGORIA;OPIS;DATA;CZY_DOCHOD`

---

## ⚙️ Jak używać?
1. Uruchom `Main.java`.
2. Wybierz opcję z menu:
   - `1` aby dodać nowe wydatki/przychody.
   - `2` aby sprawdzić stan konta i historię.
   - `3` aby bezpiecznie zapisać dane i wyjść.
3. Plik `finanse.csv` zostanie utworzony automatycznie w folderze głównym.

---

## 📈 Plany na przyszłość
- [ ] Export danych do sformatowanego arkusza Excel.
- [ ] Generowanie raportów miesięcznych.
- [ ] Walidacja wprowadzanych danych (zabezpieczenie przed błędnym formatem liczb).
