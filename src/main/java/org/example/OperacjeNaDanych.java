package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OperacjeNaDanych {

    private List<Produkt> produkty;

    public OperacjeNaDanych() {
        produkty = new ArrayList<>();
    }

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
    }

    // Sortowanie po cenie rosnąco
    public List<Produkt> sortujPoCenie() {
        List<Produkt> wynik = new ArrayList<>(produkty);
        wynik.sort(Comparator.comparingDouble(Produkt::getCena));
        return wynik;
    }

    // Filtrowanie po kategorii
    public List<Produkt> filtrujPoKategorii(String kategoria) {
        List<Produkt> wynik = new ArrayList<>();

        for (Produkt produkt : produkty) {
            if (produkt.getKategoria().equalsIgnoreCase(kategoria)) {
                wynik.add(produkt);
            }
        }

        return wynik;
    }

    // Wyszukiwanie po nazwie
    public Produkt wyszukajProdukt(String nazwa) {
        for (Produkt produkt : produkty) {
            if (produkt.getNazwa().equalsIgnoreCase(nazwa)) {
                return produkt;
            }
        }
        return null;
    }

    public void wyswietlProdukty(List<Produkt> lista) {
        for (Produkt produkt : lista) {
            System.out.println(produkt);
        }
    }
}