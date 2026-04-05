# 🏦 Personal Finance Manager v2.2

Zaawansowany system do zarządzania budżetem domowym w Javie, zintegrowany z arkuszem MS Excel.

## 📊 Nowości w wersji 2.2: Moduł Analizy
* **Dwuetapowa Analiza**: Program automatycznie rozdziela wpływy od wydatków, tworząc dwa niezależne raporty.
* **Nowe Menu Główne**: Wydzielono moduł analizy jako osobną funkcję (opcja nr 3), co pozwala na szybki wgląd w statystyki bez konieczności przeglądania całej historii transakcji.
* **Grupowanie Kategorii**: Inteligentne sumowanie kwot dla tych samych kategorii, niezależnie od tego, czy są to kategorie systemowe, czy zdefiniowane przez użytkownika.
* **Obsługa Stanów Pustych**: Program inteligentnie informuje, jeśli w danej sekcji (przychody/wydatki) nie odnotowano jeszcze żadnych wpisów.

## 📈 Kluczowe Funkcje
1. **Dodawanie Transakcji**: Z pancerną walidacją kwot i inteligentnym słownikiem kategorii.
2. **Historia i Saldo**: Pełny wgląd w chronologiczną listę operacji z dynamicznym wyliczaniem stanu konta.
3. **Analiza Finansowa**: Czytelny podział na 🟢 Przychody i 🔴 Wydatki z podsumowaniem per kategoria.
4. **Zapis do CSV**: Pełna kompatybilność z polską lokalizacją Excela (kodowanie ISO-8859-2, średniki).

## 🛠️ Technologie
* Java 21+
* HashMap & ArrayList (Zarządzanie danymi w pamięci)
* Java I/O (Persystencja danych)
