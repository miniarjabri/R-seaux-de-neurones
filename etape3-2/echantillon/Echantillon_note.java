package echantillon;

public class Echantillon_note {
    private double[] notes;
    private String nomEleve;


    public Echantillon_note(String nomEleve, double[] notes) {
        if (notes.length != 5) {
            throw new IllegalArgumentException("Le nombre de notes doit être de 5.");
        }
        this.nomEleve = nomEleve;
        this.notes = notes;
        
    }

    public double[] getNotes() {
        return notes;
    }
    public String getnom() {
        return nomEleve;
    }
}
