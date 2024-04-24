package ET;

public class Entrainer extends LotEchantillon {
	private double mse; 
	public void Entrainer ()
	{ 
		
		
	}
	public double fonctionCout() {
	    double mse = 0.0;
	    
	    for (int i = 0; i < nombre_echantillon; i++) {
	    	 for (int j = 0; j < ech[i].len(); j++) {   	
	            mse += Math.pow( ech[i].getSortie()[j] - output[j], 2);
	    }
	    return mse / 2; // La division par 2 est souvent incluse pour simplifier la dérivée
	}}
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
		    }}



