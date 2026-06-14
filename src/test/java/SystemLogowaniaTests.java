package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SystemLogowaniaTests {

    private SystemLogowania system;
    private Uzytkownik user;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        user = new Uzytkownik("admin", "1234");
        system = new SystemLogowania(user);

        // przechwycenie System.out
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testPoprawneLogowanie() {
        boolean result = system.zaloguj("admin", "1234");

        assertTrue(result);
        assertTrue(outputStream.toString().contains("sukcesem"));
    }

    @Test
    void testNiepoprawnyLogin() {
        boolean result = system.zaloguj("user", "1234");

        assertFalse(result);
        assertTrue(outputStream.toString().contains("Nieprawidłowy"));
    }

    @Test
    void testNiepoprawneHaslo() {
        boolean result = system.zaloguj("admin", "wrong");

        assertFalse(result);
        assertTrue(outputStream.toString().contains("Nieprawidłowy"));
    }

    @Test
    void testZarownoLoginIHasloNiepoprawne() {
        boolean result = system.zaloguj("x", "y");

        assertFalse(result);
        assertTrue(outputStream.toString().contains("Nieprawidłowy"));
    }

    @Test
    void testUzytkownikGetLogin() {
        assertEquals("admin", user.getLogin());
    }

    @Test
    void testSprawdzHasloPoprawne() {
        assertTrue(user.sprawdzHaslo("1234"));
    }

    @Test
    void testSprawdzHasloNiepoprawne() {
        assertFalse(user.sprawdzHaslo("9999"));
    }

    @Test
    void tearDown() {
        System.setOut(originalOut);
    }
}