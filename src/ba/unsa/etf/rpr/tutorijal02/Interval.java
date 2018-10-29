package ba.unsa.etf.rpr.tutorijal02;
import java.lang.*;
public class Interval {
    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetnaUkljucena;
    private boolean krajnjaUkljucena;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaUkljucena, boolean krajnjaUkljucena) {
        if (pocetnaTacka > krajnjaTacka) throw new IllegalArgumentException ("Greška");
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pocetnaUkljucena = pocetnaUkljucena;
        this.krajnjaUkljucena = krajnjaUkljucena;
    }


}
