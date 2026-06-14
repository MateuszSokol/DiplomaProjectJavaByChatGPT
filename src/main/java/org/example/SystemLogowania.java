package org.example;

public class SystemLogowania {

    private Uzytkownik uzytkownik;

    public SystemLogowania(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public boolean zaloguj(String login, String haslo) {
        if (uzytkownik.getLogin().equals(login)
                && uzytkownik.sprawdzHaslo(haslo)) {

            System.out.println("Logowanie zakończone sukcesem.");
            return true;
        }

        System.out.println("Nieprawidłowy login lub hasło.");
        return false;
    }
}