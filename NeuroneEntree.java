package réseaux_de_neurones;
import java.util.Random;


public class NeuroneEntree extends Neurone {
	int tailleEntree;
	private double[] poids;
    // Constructeur
    public NeuroneEntree(int tailleEntree) {
        this.tailleEntree=tailleEntree;
        initialiserPoidsAleatoirement(); // Initialiser les poids aléatoirement
    }

    @Override
    public double calculerSortie(double[] entrees) {
        // Fonction qui calcule les valeurs à envoyer à chaque neurone de la couche suivante
        // Dans le cas d'un neurone d'entrée, il renvoie simplement les entrées
        double sommePonderee = 0;
        for (int i = 0; i < poids.length; i++) {
            sommePonderee += poids[i] * entrees[i];
        }
        // Appliquer une fonction d'activation si nécessaire
        return sommePonderee;
    }

    // Méthode pour initialiser les poids aléatoirement
    private void initialiserPoidsAleatoirement() {
        Random random = new Random();
        for (int i = 0; i < poids.length; i++) {
            poids[i] = random.nextDouble(); // Génère un nombre aléatoire entre 0 (inclus) et 1 (exclus)
        }
    }
}
