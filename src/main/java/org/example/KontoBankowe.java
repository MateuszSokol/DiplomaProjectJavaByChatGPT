package org.example;

public class KontoBankowe {

    private String numerKonta;
    private String wlasciciel;
    private double saldo;

    public KontoBankowe(String numerKonta, String wlasciciel, double saldoPoczatkowe) {
        this.numerKonta = numerKonta;
        this.wlasciciel = wlasciciel;
        this.saldo = saldoPoczatkowe;
    }

    public String getNumerKonta() {
        return numerKonta;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public double getSaldo() {
        return saldo;
    }

    public void wplata(double kwota) {
        if (kwota > 0) {
            saldo += kwota;
            System.out.println("Wpłacono: " + kwota + " zł");
        } else {
            System.out.println("Kwota wpłaty musi być większa od 0.");
        }
    }

    public boolean wyplata(double kwota) {
        if (kwota <= 0) {
            System.out.println("Kwota wypłaty musi być większa od 0.");
            return false;
        }

        if (kwota > saldo) {
            System.out.println("Brak wystarczających środków.");
            return false;
        }

        saldo -= kwota;
        System.out.println("Wypłacono: " + kwota + " zł");
        return true;
    }

    public void wyswietlInformacje() {
        System.out.println("Numer konta: " + numerKonta);
        System.out.println("Właściciel: " + wlasciciel);
        System.out.println("Saldo: " + saldo + " zł");
    }
}