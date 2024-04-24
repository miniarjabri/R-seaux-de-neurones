package LesFonctions;

public class RetroPropagation {
	// La classe du neurone
	public class Neurone {
	    double[] poids;
	    double biais;
	    double sortie;

	    public Neurone(int nombreEntrees) {
	        poids = new double[nombreEntrees];
	        for (int i = 0; i < nombreEntrees; i++) {
	            poids[i] = Math.random(); // Initialisation aléatoire des poids
	        }
	        biais = Math.random(); // Initialisation aléatoire du biais
	    }

	    // Calcul de la sortie du neurone pour une donnée entrée
	    public double calculerSortie(double[] entrees) {
	        double somme = biais;
	        for (int i = 0; i < entrees.length; i++) {
	            somme += poids[i] * entrees[i];
	        }
	        sortie = 1 / (1 + Math.exp(-somme)); // Sigmoïde
	        return sortie;
	    }

	    // Calcule la dérivée de la fonction d'activation (sigmoïde)
	    public double deriveeActivation() {
	        return sortie * (1 - sortie);
	    }

	    // Met à jour les poids en fonction du gradient
	    public void mettreAJourPoids(double[] entrees, double erreur, double tauxApprentissage) {
	        for (int i = 0; i < poids.length; i++) {
	            poids[i] -= tauxApprentissage * erreur * deriveeActivation() * entrees[i];
	        }
	        biais -= tauxApprentissage * erreur * deriveeActivation(); // Mise à jour du biais
	    }
	}

	// La méthode de rétropropagation dans le réseau de neurones
	public void retropropager(double[] entrees, double[] sortiesAttendues, double tauxApprentissage) {
	    double[] erreurs = new double[sortiesAttendues.length];
	    // Calcul des erreurs pour la couche de sortie
	    for (int i = 0; i < sortiesAttendues.length; i++) {
	        erreurs[i] = sortiesAttendues[i] - neuronesDeSortie[i].sortie;
	    }

	    // Mise à jour des poids pour la couche de sortie
	    for (int i = 0; i < neuronesDeSortie.length; i++) {
	        neuronesDeSortie[i].mettreAJourPoids(entrees, erreurs[i], tauxApprentissage);
	    }

	    // Ici, vous devriez également propager l'erreur aux couches cachées et mettre à jour les poids
	    // Cela nécessite de connaître les dérivées de la sortie des neurones cachés et d'utiliser la règle de la chaîne pour calculer les erreurs cachées.
	}
}
