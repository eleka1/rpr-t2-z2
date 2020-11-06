package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna_tacka;
    private double krajnja_tacka;
    boolean pocetak;
    boolean kraj;

    public Interval() {
        this.pocetna_tacka = 0;
        this.krajnja_tacka = 0;
        this.pocetak = false;
        this. kraj = false;
    }

    public Interval(double pocetna_tacka, double krajnja_tacka, boolean pocetak, boolean kraj) {
        if(pocetna_tacka > krajnja_tacka) throw new IllegalArgumentException();
        this.pocetna_tacka = pocetna_tacka;
        this.krajnja_tacka = krajnja_tacka;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }


    public boolean isNull() {
        return (pocetna_tacka == 0 && krajnja_tacka == 0 && !pocetak && !kraj);
    }

    public boolean isIn(double v) {
        if(v == pocetna_tacka) return pocetak;
        if(v == krajnja_tacka) return kraj;
        return (v>pocetna_tacka && v<krajnja_tacka);
    }


    public Interval intersect(Interval interval) {
        if(krajnja_tacka < interval.pocetna_tacka) return new Interval();
        else if(interval.krajnja_tacka < pocetna_tacka) return new Interval();
        double n_pocetna, n_krajnja;
        boolean n_pocetak, n_kraj;
        if(pocetna_tacka > interval.pocetna_tacka)  {
            n_pocetna = pocetna_tacka;
            n_pocetak = pocetak;
        } else {
            n_pocetna = interval.pocetna_tacka;
            n_pocetak = interval.pocetak;
        }
        if(krajnja_tacka < interval.krajnja_tacka)  {
            n_krajnja = krajnja_tacka;
            n_kraj = kraj;
        } else {
            n_krajnja = interval.krajnja_tacka;
            n_kraj = interval.kraj;
        }
        return new Interval(n_pocetna,n_krajnja,n_pocetak,n_kraj);

    }

    public static Interval intersect(Interval interval1, Interval interval2){
        if(interval1.krajnja_tacka < interval2.pocetna_tacka) return new Interval();
        else if(interval2.krajnja_tacka < interval1.pocetna_tacka) return new Interval();
        double n_pocetna, n_krajnja;
        boolean n_pocetak, n_kraj;
        if(interval1.pocetna_tacka > interval2.pocetna_tacka)  {
            n_pocetna = interval1.pocetna_tacka;
            n_pocetak = interval1.pocetak;
        } else {
            n_pocetna = interval2.pocetna_tacka;
            n_pocetak = interval2.pocetak;
        }
        if(interval1.krajnja_tacka < interval2.krajnja_tacka)  {
            n_krajnja = interval1.krajnja_tacka;
            n_kraj = interval1.kraj;
        } else {
            n_krajnja = interval2.krajnja_tacka;
            n_kraj = interval2.kraj;
        }
        return new Interval(n_pocetna,n_krajnja,n_pocetak,n_kraj);
    }

    @Override
    public String toString() {
        if (pocetna_tacka == 0 && krajnja_tacka == 0 && !kraj && !pocetak) return "()";
        String povrat = "";
        if(pocetak) povrat = povrat + "[" + pocetna_tacka + ",";
        else povrat = povrat + "(" + pocetna_tacka + ",";
        if(kraj) povrat = povrat + krajnja_tacka + "]";
        else povrat = povrat + krajnja_tacka + ")";
        return povrat;
    }

    @Override
    public boolean equals(Object o){
        Interval interval = (Interval) o;
        if(pocetna_tacka == interval.pocetna_tacka && krajnja_tacka == interval.krajnja_tacka && kraj == interval.kraj && pocetak == interval.pocetak) return true;
        return false;

    }
}
