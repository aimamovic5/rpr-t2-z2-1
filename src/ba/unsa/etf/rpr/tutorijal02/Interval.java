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

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public boolean isPocetnaUkljucena() {
        return pocetnaUkljucena;
    }

    public void setPocetnaUkljucena(boolean pocetnaUkljucena) {
        this.pocetnaUkljucena = pocetnaUkljucena;
    }

    public boolean isKrajnjaUkljucena() {
        return krajnjaUkljucena;
    }

    public void setKrajnjaUkljucena(boolean krajnjaUkljucena) {
        this.krajnjaUkljucena = krajnjaUkljucena;
    }

    public Interval() {
        this.pocetnaTacka = 0;
        this.krajnjaTacka = 0;
        this.pocetnaUkljucena = false;
        this.krajnjaUkljucena = false;
    }

    public boolean isNull() {
        return (Math.abs(pocetnaTacka - krajnjaTacka) < 0.00001);
    }

    public boolean isIn(double Tacka) {
        if (Math.abs(Tacka - pocetnaTacka) < 0.00001 && this.isPocetnaUkljucena())
            return true;
        if (Math.abs(Tacka - krajnjaTacka) < 0.00001 && this.isKrajnjaUkljucena())
            return true;
        return (Tacka > pocetnaTacka && Tacka < krajnjaTacka);
    }

}
