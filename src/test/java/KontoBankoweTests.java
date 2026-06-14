package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontoBankoweTests {

    private KontoBankowe konto;

    @BeforeEach
    void setUp() {
        konto = new KontoBankowe("1234567890", "Jan Kowalski", 100.0);
    }

    @Test
    void testKonstruktorINaPoczatkuSaldo() {
        assertEquals("1234567890", konto.getNumerKonta());
        assertEquals("Jan Kowalski", konto.getWlasciciel());
        assertEquals(100.0, konto.getSaldo());
    }

    @Test
    void testWplataPoprawnaKwota() {
        konto.wplata(50.0);
        assertEquals(150.0, konto.getSaldo());
    }

    @Test
    void testWplataNiepoprawnaKwota() {
        konto.wplata(-10.0);
        assertEquals(100.0, konto.getSaldo());

        konto.wplata(0.0);
        assertEquals(100.0, konto.getSaldo());
    }

    @Test
    void testWyplataSukces() {
        boolean result = konto.wyplata(40.0);

        assertTrue(result);
        assertEquals(60.0, konto.getSaldo());
    }

    @Test
    void testWyplataZaDuzaKwota() {
        boolean result = konto.wyplata(200.0);

        assertFalse(result);
        assertEquals(100.0, konto.getSaldo());
    }

    @Test
    void testWyplataZeroLubUjemna() {
        assertFalse(konto.wyplata(0.0));
        assertFalse(konto.wyplata(-5.0));
        assertEquals(100.0, konto.getSaldo());
    }
}