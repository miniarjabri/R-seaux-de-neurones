package echantillon;

public class Non {
	    private static final int poids = -1;
	    private static final int seuil = 0;
	    private int sortie;

	    // Constructeur prenant l'entrée et calculant la sortie
	    public Non(int entree) {
	        int somme = poids * entree;
	        this.sortie = somme >= seuil ? 1 : 0;  // Comparaison avec le seuil pour déterminer la sortie
	    }

	    // Méthode pour récupérer la sortie
	    public int getSortie() {
	        return sortie;
	    }
}