package echantillon;

public class Ou {
    private static final int[] poids = {1, 1};
    private static final int seuil = 1;
    private int sortie;

    // Constructeur prenant les entrées et calculant la sortie
    public Ou(int entree1, int entree2) {
        int somme = poids[0] * entree1 + poids[1] * entree2;
        this.sortie = somme >= seuil ? 1 : 0;  // Comparaison avec le seuil pour déterminer la sortie
    }

    // Méthode pour récupérer la sortie
    public int getSortie() {
        return sortie;
    }
}
