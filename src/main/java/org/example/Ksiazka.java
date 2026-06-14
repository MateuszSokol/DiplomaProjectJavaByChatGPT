package org.example;

public class Ksiazka {

    private String tytul;
    private String autor;
    private String isbn;

    public Ksiazka(String tytul, String autor, String isbn) {
        this.tytul = tytul;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTytul() {
        return tytul;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Tytuł: " + tytul +
                ", Autor: " + autor +
                ", ISBN: " + isbn;
    }
}