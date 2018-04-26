package Aufgabe2.Master_Worker;

public class Matrix {

    public int zeile;
    public int spalte;

    public Matrix(int zeile, int spalte) {
        this.zeile = zeile;
        this.spalte = spalte;

    }

    public int getZeile() {
        return zeile;
    }

    public void setZeile(int zeile) {
        this.zeile = zeile;
    }

    public int getSpalte() {
        return spalte;
    }

    public void setSpalte(int spalte) {
        this.spalte = spalte;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "zeile=" + zeile +
                ", spalte=" + spalte +
                '}';
    }
}






