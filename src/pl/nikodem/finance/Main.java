package pl.nikodem.finance;

public class Main {
    public static void main(String[] args) {
        Transaction t1 = new Transaction(50,"Piwo","Wyjście ze znajomymi", "12.02.2026", false);
        Transaction t2 = new Transaction(150,"Kieszonkowe","Przelew od rodziców", "10.02.2026", true);

        System.out.println(t1);
        System.out.println(t2);
    }
}