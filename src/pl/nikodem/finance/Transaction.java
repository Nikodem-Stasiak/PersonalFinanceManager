package pl.nikodem.finance;

public class Transaction {
    private double kwota;
    private String kategoria;
    private String opis;
    private boolean czyToDochod;
    private String data;

    public Transaction(double kwota, String kategoria, String opis, String data, boolean czyToDochod){
        this.kwota = kwota;
        this.kategoria = kategoria;
        this.opis = opis;
        this.data = data;
        this.czyToDochod = czyToDochod;
    }

    @Override
    public String toString() {
        String znak = (czyToDochod) ? "[+]" : "[-]";
        return data + " " + znak + " " + kwota + " PLN | " + kategoria + ": " + opis;
    }

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isCzyToDochod() {
        return czyToDochod;
    }

    public void setCzyToDochod(boolean czyToDochod) {
        this.czyToDochod = czyToDochod;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}