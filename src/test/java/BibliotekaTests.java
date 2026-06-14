package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotekaTests {

    private Biblioteka biblioteka;

    @BeforeEach
    void setUp() {
        biblioteka = new Biblioteka();

        biblioteka.dodajKsiazke(new Ksiazka("Lalka", "Bolesław Prus", "111"));
        biblioteka.dodajKsiazke(new Ksiazka("Hobbit", "J.R.R. Tolkien", "222"));
    }

    @Test
    void testDodawanieKsiazki() {
        Ksiazka wynik = biblioteka.wyszukajKsiazke("Lalka");
        assertNotNull(wynik);
        assertEquals("Bolesław Prus", wynik.getAutor());
    }

    @Test
    void testWyszukiwanieKsiazkiNieIstnieje() {
        Ksiazka wynik = biblioteka.wyszukajKsiazke("Nieistniejaca");
        assertNull(wynik);
    }

    @Test
    void testUsuwanieKsiazki() {
        boolean usunieto = biblioteka.usunKsiazke("111");
        assertTrue(usunieto);

        Ksiazka wynik = biblioteka.wyszukajKsiazke("Lalka");
        assertNull(wynik);
    }

    @Test
    void testUsuwanieNieistniejacejKsiazki() {
        boolean usunieto = biblioteka.usunKsiazke("999");
        assertFalse(usunieto);
    }

    @Test
    void testWyszukiwaniePoTytule() {
        Ksiazka wynik = biblioteka.wyszukajKsiazke("Hobbit");

        assertNotNull(wynik);
        assertEquals("J.R.R. Tolkien", wynik.getAutor());
    }
}