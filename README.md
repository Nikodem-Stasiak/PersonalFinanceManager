# 🏦 Personal Finance Manager

Prosty, ale potężny system do zarządzania finansami osobistymi napisany w **Javie**, w pełni zintegrowany z **Microsoft Excel**. Aplikacja pozwala na śledzenie dochodów i wydatków oraz generowanie profesjonalnych raportów wizualnych.

## 🚀 Funkcje
* **Zarządzanie transakcjami**: Dodawanie kwoty, kategorii, opisu oraz daty.
* **Automatyczne Saldo**: Program na bieżąco wylicza aktualny stan konta w menu historii.
* **Persystencja danych**: Automatyczny zapis i odczyt z pliku `finanse.csv`.
* **Eksport do Excela**: Dane są formatowane pod polską lokalizację Excela (średniki jako separatory, przecinki w liczbach).
* **Inteligentne Wydatki**: System automatycznie zamienia wydatki na liczby ujemne, co pozwala na błyskawiczne tworzenie Tabel Przestawnych i wykresów Salda.

## 📈 Integracja z Excelem
Dzięki zastosowaniu formatowania CSV zgodnego ze standardami finansowymi, projekt umożliwia:
1. **Tworzenie Tabel Przestawnych** do szczegółowej analizy kategorii.
2. **Generowanie Wykresów Kołowych** (struktura wydatków) oraz słupkowych (przychody).
3. **Monitorowanie Salda** w czasie rzeczywistym poprzez funkcję "Odśwież wszystko" w Excelu.

## 🛠️ Technologia
* **Język**: Java 21+
* **Format danych**: CSV (kodowanie ISO-8859-2 dla poprawnej obsługi polskich znaków w Excelu).
* **Analiza**: MS Excel / Power Query.

## 📋 Planowane ulepszenia (Roadmap)
* [ ] **Pancerna Walidacja**: Odporność na błędne wprowadzanie danych (obsługa wyjątków `try-catch`).
* [ ] **Automatyczna Data**: Systemowe pobieranie daty transakcji przyciskiem Enter.
* [ ] **Menu Kategorii**: Wybór kategorii z predefiniowanej listy zamiast wpisywania ręcznego.
