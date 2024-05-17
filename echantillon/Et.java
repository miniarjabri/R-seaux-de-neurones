package echantillon;

public class Et {
    private static final int[] poids = {1, 1};
    private static final int seuil = 1;
    private int sortie;

    // Constructeur prenant les entrées et calculant la sortie
    public Et(int entree1, int entree2) {
        int somme = poids[0] * entree1 + poids[1] * entree2;
        this.sortie = somme > seuil ? 1 : 0;  // Comparaison avec le seuil pour déterminer la sortie
    }

    // Méthode pour récupérer la sortie
    public int getSortie() {
        return sortie;
    }
}


/*public static void main(String[] args) {
    System.out.println("0 ET 0 = " + fonctionOU(0, 0)); // Attendu : 0
    System.out.println("0 ET 1 = " + fonctionOU(0, 1)); // Attendu : 0
    System.out.println("1 ET 0 = " + fonctionOU(1, 0)); // Attendu : 0
    System.out.println("1 ET 1 = " + fonctionOU(1, 1)); // Attendu : 1
}*/

