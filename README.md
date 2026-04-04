# 🏦 Personal Finance Manager

Prosty, ale potężny system do zarządzania finansami osobistymi napisany w **Javie**, w pełni zintegrowany z **Microsoft Excel**. Aplikacja pozwala na precyzyjne śledzenie budżetu domowego oraz generowanie profesjonalnych raportów.

## 🚀 Nowości w wersji 2.1 (Słownik i Elastyczność)
Ostatnia aktualizacja wprowadziła inteligentne zarządzanie kategoriami oraz dalsze usprawnienia stabilności:

* **Słownik Kategorii**: Użytkownik wybiera kategorię z predefiniowanej listy (np. 1-Jedzenie, 2-Transport). Eliminuje to ryzyko literówek, które mogłyby zepsuć późniejszą analizę danych i wykresy.
* **Inteligentny Fallback ("Inne")**: System nie ogranicza użytkownika – wybranie opcji "Inne" pozwala na wpisanie własnej, unikalnej nazwy kategorii, która zostanie poprawnie zapisana w bazie.
* **Pancerna Walidacja 2.0**: Program jest w pełni odporny na wpisanie tekstu zamiast numeru kategorii oraz na podanie numeru spoza dostępnej listy.
* **Naprawa zasięgu zmiennych**: Zoptymalizowano strukturę kodu, rozwiązując problemy z widocznością zmiennych sterujących (Variable Scope).

## 📈 Funkcje i Integracje
* **Zarządzanie transakcjami**: Dodawanie kwoty, kategorii (ze słownika), opisu oraz daty.
* **Automatyczne Saldo**: Dynamiczne wyliczanie aktualnego stanu konta na podstawie całej historii wpisów.
* **Standard Daty ISO 8601**: Obsługa `java.time.LocalDate` z domyślnym formatem `RRRR-MM-DD` dla bezbłędnego sortowania chronologicznego.
* **Eksport do Excela**: Zapis do CSV zoptymalizowany pod polską lokalizację (średniki, polskie znaki ISO-8859-2, przecinki jako separatory dziesiętne).

## 🛠️ Technologia
* **Język**: Java 21+
* **Standardy**: ISO 8601 (daty), ISO-8859-2 (kodowanie tekstu).
* **Narzędzia**: IntelliJ IDEA, Git, Microsoft Excel.

## 📋 Planowane ulepszenia (Roadmap)
* [ ] **Statystyki Wydatków**: Szybkie podsumowanie w konsoli: „Ile łącznie wydałem na daną kategorię?”.
* [ ] **Zabezpieczenie danych**: Mechanizm tworzenia automatycznej kopii zapasowej pliku `finanse.csv`.
* [ ] **Interfejs Graficzny (GUI)**: Implementacja okienkowego interfejsu użytkownika w JavaFX lub Swing.
