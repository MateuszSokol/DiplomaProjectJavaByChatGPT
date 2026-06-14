package org.example;

import java.util.ArrayList;
import java.util.List;

public class Biblioteka {

    private List<Ksiazka> ksiazki;

    public Biblioteka() {
        ksiazki = new ArrayList<>();
    }

    public void dodajKsiazke(Ksiazka ksiazka) {
        ksiazki.add(ksiazka);
        System.out.println("Dodano książkę: " + ksiazka.getTytul());
    }

    public boolean usunKsiazke(String isbn) {
        for (Ksiazka ksiazka : ksiazki) {
            if (ksiazka.getIsbn().equals(isbn)) {
                ksiazki.remove(ksiazka);
                System.out.println("Usunięto książkę: " + ksiazka.getTytul());
                return true;
            }
        }

        System.out.println("Nie znaleziono książki o podanym ISBN.");
        return false;
    }

    public Ksiazka wyszukajKsiazke(String tytul) {
        for (Ksiazka ksiazka : ksiazki) {
            if (ksiazka.getTytul().equalsIgnoreCase(tytul)) {
                return ksiazka;
            }
        }
        return null;
    }

    public void wyswietlKsiazki() {
        if (ksiazki.isEmpty()) {
            System.out.println("Biblioteka jest pusta.");
            return;
        }

        System.out.println("Lista książek:");
        for (Ksiazka ksiazka : ksiazki) {
            System.out.println(ksiazka);
        }
    }
}