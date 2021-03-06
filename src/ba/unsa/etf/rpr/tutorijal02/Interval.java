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

    public Interval intersect(Interval interval) {
        if (Math.abs(interval.getPocetnaTacka() - this.getPocetnaTacka()) < 0.00001 && Math.abs(interval.getKrajnjaTacka() - this.getKrajnjaTacka()) < 0.00001) {
            if (interval.isPocetnaUkljucena() && this.isPocetnaUkljucena())
                if (interval.isKrajnjaUkljucena() && this.isKrajnjaUkljucena())
                    return new Interval(this.getPocetnaTacka(), this.getKrajnjaTacka(),false,false);
                else
                    return new Interval(this.getPocetnaTacka(), this.getKrajnjaTacka(), true, false);
            else
                return new Interval(this.getPocetnaTacka(), this.getKrajnjaTacka(),false,false);
        }
        if (interval.getKrajnjaTacka() < this.getPocetnaTacka() || interval.getPocetnaTacka() > this.getKrajnjaTacka())
            return new Interval();
        if (interval.getPocetnaTacka() > this.getPocetnaTacka() && interval.getKrajnjaTacka() < this.getKrajnjaTacka())
            return new Interval(interval.getPocetnaTacka(), interval.getKrajnjaTacka(), interval.isPocetnaUkljucena(), interval.isKrajnjaUkljucena());
        if (interval.getPocetnaTacka() < this.getPocetnaTacka() && interval.getKrajnjaTacka() > this.getKrajnjaTacka())
            return new Interval(this.getPocetnaTacka(), this.getKrajnjaTacka(), this.isPocetnaUkljucena(), this.isKrajnjaUkljucena());
        if (interval.getPocetnaTacka() < this.getPocetnaTacka())
            return new Interval(this.getPocetnaTacka(), interval.getKrajnjaTacka(), this.isPocetnaUkljucena(), interval.isKrajnjaUkljucena());
        return new Interval(interval.getPocetnaTacka(), this.getKrajnjaTacka(), interval.isPocetnaUkljucena(), this.isKrajnjaUkljucena());
    }
    public static Interval intersect(Interval prviInterval, Interval drugiInterval) {
        if (Math.abs(drugiInterval.getPocetnaTacka() - prviInterval.getPocetnaTacka()) < 0.00001 && Math.abs(drugiInterval.getKrajnjaTacka() - prviInterval.getKrajnjaTacka()) < 0.00001) {
            if (drugiInterval.isPocetnaUkljucena() && prviInterval.isPocetnaUkljucena())
                if (drugiInterval.isKrajnjaUkljucena() && prviInterval.isKrajnjaUkljucena())
                    return new Interval(prviInterval.getPocetnaTacka(), prviInterval.getKrajnjaTacka(),false,false);
                else
                    return new Interval(prviInterval.getPocetnaTacka(), prviInterval.getKrajnjaTacka(), true, false);
            else
                return new Interval(prviInterval.getPocetnaTacka(), prviInterval.getKrajnjaTacka(),false,false);
        }
        if (drugiInterval.getKrajnjaTacka() < prviInterval.getPocetnaTacka() || drugiInterval.getPocetnaTacka() > prviInterval.getKrajnjaTacka())
            return new Interval();
        if (drugiInterval.getPocetnaTacka() > prviInterval.getPocetnaTacka() && drugiInterval.getKrajnjaTacka() < prviInterval.getKrajnjaTacka())
            return new Interval(drugiInterval.getPocetnaTacka(), drugiInterval.getKrajnjaTacka(), drugiInterval.isPocetnaUkljucena(), drugiInterval.isKrajnjaUkljucena());
        if (drugiInterval.getPocetnaTacka() < prviInterval.getPocetnaTacka() && drugiInterval.getKrajnjaTacka() > prviInterval.getKrajnjaTacka())
            return new Interval(prviInterval.getPocetnaTacka(), prviInterval.getKrajnjaTacka(), prviInterval.isPocetnaUkljucena(), prviInterval.isKrajnjaUkljucena());
        if (drugiInterval.getPocetnaTacka() < prviInterval.getPocetnaTacka())
            return new Interval(prviInterval.getPocetnaTacka(), drugiInterval.getKrajnjaTacka(), prviInterval.isPocetnaUkljucena(), drugiInterval.isKrajnjaUkljucena());
        return new Interval(drugiInterval.getPocetnaTacka(), prviInterval.getKrajnjaTacka(), drugiInterval.isPocetnaUkljucena(), prviInterval.isKrajnjaUkljucena());
    }

    @Override
    public boolean equals(Object obj) {
        Interval interval = (Interval)obj;
        return (this.getPocetnaTacka() == interval.getPocetnaTacka() && this.getKrajnjaTacka() == interval.getKrajnjaTacka()
                && this.isPocetnaUkljucena() == interval.isPocetnaUkljucena() && this.isKrajnjaUkljucena() == interval.isKrajnjaUkljucena());
    }

    @Override
    public String toString() {
        if (Math.abs(this.getPocetnaTacka()) < 0.00001 && Math.abs(this.getKrajnjaTacka()) < 0.00001)
            return new String("()");
        if(this.isPocetnaUkljucena() && this.isKrajnjaUkljucena())
            return new String("[" + Double.toString(this.getPocetnaTacka()) + "," + Double.toString(this.getKrajnjaTacka()) + "]");
        if(!this.isPocetnaUkljucena() && this.isKrajnjaUkljucena())
            return new String("(" + Double.toString(this.getPocetnaTacka()) + "," + Double.toString(this.getKrajnjaTacka()) + "]");
        if(this.isPocetnaUkljucena() && !this.isKrajnjaUkljucena())
            return new String("[" + Double.toString(this.getPocetnaTacka()) + "," + Double.toString(this.getKrajnjaTacka()) + ")");
        //if(!this.isPocetnaUkljucena() && !this.isKrajnjaUkljucena())
        return new String("(" + Double.toString(this.getPocetnaTacka()) + "," + Double.toString(this.getKrajnjaTacka()) + ")");

    }
}
