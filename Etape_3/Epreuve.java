package etape3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Epreuve {
    private String nom;
    private int coefficient;
    private double note;

    public Epreuve(String nom, double note, int coefficient) {
        this.nom = nom;
        this.note=note;
        this.coefficient = coefficient;
    }

    public String getNom() {
        return nom;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
