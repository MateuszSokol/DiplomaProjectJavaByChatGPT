package org.example;

public class Uzytkownik {

    private String login;
    private String haslo;

    public Uzytkownik(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }

    public String getLogin() {
        return login;
    }

    public boolean sprawdzHaslo(String haslo) {
        return this.haslo.equals(haslo);
    }
}