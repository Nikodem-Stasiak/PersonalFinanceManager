# 🏦 Personal Finance Manager

Prosty, ale potężny system do zarządzania finansami osobistymi napisany w **Javie**, w pełni zintegrowany z **Microsoft Excel**. Aplikacja pozwala na precyzyjne śledzenie budżetu domowego oraz generowanie profesjonalnych raportów.

## 🚀 Nowości w wersji 2.0 (Pancerna Walidacja)
Ostatnia aktualizacja skupiła się na stabilności systemu oraz komforcie użytkownika (UX):

* **Pancerna Walidacja**: Program jest odporny na błędy wprowadzania danych. Dzięki zastosowaniu bloków `try-catch` oraz pętli walidacyjnych, wpisanie liter zamiast kwoty lub błędnych opcji w menu nie powoduje zamknięcia aplikacji.
* **Standard Daty ISO 8601**: Przejście na międzynarodowy standard zapisu daty (`RRRR-MM-DD`), co zapewnia bezbłędne sortowanie chronologiczne w plikach tekstowych oraz pełną kompatybilność z bazami danych.
* **Inteligentna Data**: Wdrożono obsługę `java.time.LocalDate`. Użytkownik może zatwierdzić dzisiejszą datę systemową za pomocą jednego klawisza **Enter**.
* **Ulepszony UX**: Zamieniono techniczne parametry logiczne (`true/false`) na intuicyjne odpowiedzi `tak/nie`. System automatycznie radzi sobie z wielkością liter oraz przypadkowymi spacjami (`.toLowerCase().trim()`).

## 📈 Funkcje i Integracje
* **Zarządzanie transakcjami**: Dodawanie kwoty, kategorii, opisu oraz daty.
* **Automatyczne Saldo**: Dynamiczne wyliczanie aktualnego stanu konta w widoku historii.
* **Eksport do Excela**: Dane są zapisywane w formacie CSV zoptymalizowanym pod polską lokalizację (średniki jako separatory, przecinki w liczbach), co umożliwia błyskawiczne tworzenie Tabel Przestawnych i wykresów w MS Excel.
* **Persystencja danych**: Automatyczny zapis i odczyt z pliku `finanse.csv` przy użyciu kodowania `ISO-8859-2`.

## 🛠️ Technologia
* **Język**: Java 21+
* **Środowisko**: IntelliJ IDEA
* **Biblioteki**: Standardowa biblioteka Javy (`java.time`, `java.io`, `java.util`).
* **Analiza**: Microsoft Excel / Power Query.

## 📋 Planowane ulepszenia (Roadmap)
* [ ] **Słownik Kategorii**: Wybór kategorii z predefiniowanej listy (np. 1-Jedzenie, 2-Transport), aby uniknąć literówek psujących raporty.
* [ ] **Statystyki w Konsoli**: Szybkie podsumowanie wydatków z podziałem na kategorie bezpośrednio w oknie programu.
* [ ] **Interfejs Graficzny (GUI)**: Implementacja widoków okienkowych przy użyciu biblioteki Swing lub JavaFX.
