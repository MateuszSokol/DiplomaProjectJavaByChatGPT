package org.example;

public class Produkt {

    private String nazwa;
    private String kategoria;
    private double cena;

    public Produkt(String nazwa, String kategoria, double cena) {
        this.nazwa = nazwa;
        this.kategoria = kategoria;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getKategoria() {
        return kategoria;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", kategoria='" + kategoria + '\'' +
                ", cena=" + cena +
                '}';
    }
}