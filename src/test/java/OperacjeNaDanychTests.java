package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperacjeNaDanychTests {

    private OperacjeNaDanych operacje;

    private Produkt p1;
    private Produkt p2;
    private Produkt p3;
    private Produkt p4;

    @BeforeEach
    void setUp() {
        operacje = new OperacjeNaDanych();

        p1 = new Produkt("Laptop", "Elektronika", 3000.0);
        p2 = new Produkt("Mysz", "Elektronika", 100.0);
        p3 = new Produkt("Chleb", "Spozywcze", 5.0);
        p4 = new Produkt("Monitor", "Elektronika", 800.0);

        operacje.dodajProdukt(p1);
        operacje.dodajProdukt(p2);
        operacje.dodajProdukt(p3);
        operacje.dodajProdukt(p4);
    }

    @Test
    void testDodajProduktISortowaniePoCenie() {
        List<Produkt> posortowane = operacje.sortujPoCenie();

        assertEquals(4, posortowane.size());
        assertEquals("Chleb", posortowane.get(0).getNazwa());   // 5 zł
        assertEquals("Mysz", posortowane.get(1).getNazwa());    // 100 zł
        assertEquals("Monitor", posortowane.get(2).getNazwa());  // 800 zł
        assertEquals("Laptop", posortowane.get(3).getNazwa());   // 3000 zł
    }

    @Test
    void testFiltrujPoKategoriiElektronika() {
        List<Produkt> wynik = operacje.filtrujPoKategorii("Elektronika");

        assertEquals(3, wynik.size());
        assertTrue(wynik.stream().allMatch(p -> p.getKategoria().equals("Elektronika")));
    }

    @Test
    void testFiltrujPoKategoriiIgnoreCase() {
        List<Produkt> wynik = operacje.filtrujPoKategorii("elektronika");

        assertEquals(3, wynik.size());
    }

    @Test
    void testFiltrujPoKategoriiBrakWynikow() {
        List<Produkt> wynik = operacje.filtrujPoKategorii("Sport");

        assertTrue(wynik.isEmpty());
    }

    @Test
    void testWyszukajProduktZnaleziony() {
        Produkt wynik = operacje.wyszukajProdukt("Laptop");

        assertNotNull(wynik);
        assertEquals("Laptop", wynik.getNazwa());
    }

    @Test
    void testWyszukajProduktIgnoreCase() {
        Produkt wynik = operacje.wyszukajProdukt("laptop");

        assertNotNull(wynik);
        assertEquals("Laptop", wynik.getNazwa());
    }

    @Test
    void testWyszukajProduktNieIstnieje() {
        Produkt wynik = operacje.wyszukajProdukt("Tablet");

        assertNull(wynik);
    }

    @Test
    void testSortowanieNieModyfikujeOryginalnejListy() {
        operacje.sortujPoCenie();

        List<Produkt> poFiltrowaniu = operacje.filtrujPoKategorii("Elektronika");
        assertEquals(3, poFiltrowaniu.size());
    }
}