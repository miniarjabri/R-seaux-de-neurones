package LesFonctions;

public class FonctionCout {
	public double FonctionCout(double[] sortiesAttendues, double[] sortiesActuelles) {
	    double error = 0.0;
	    for (int k = 0; k < sortiesActuelles.length; k++) {
	        error += Math.pow(sortiesActuelles[k] - sortiesAttendues[k], 2);
	    }
	    return 0.5 * error;
	}
	public void retropropager(double[] sortiesAttendues, double[] sortiesActuelles, double learningRate) {
	    for (int i = 0; i < sortiesActuelles.length; i++) {
	        double error = sortiesActuelles[i] - sortiesAttendues[i];
	        // Calculer la dérivée de la fonction de coût par rapport à la sortie
	        double delta = error; // Pour MSE, la dérivée est simplement l'erreur
	        
	        // Ici, vous devriez calculer la dérivée de l'erreur par rapport à chaque poids.
	        // Cela dépend de l'architecture spécifique de votre réseau et de la fonction d'activation utilisée.
	        // Vous devriez également mettre à jour les poids ici, mais pour cela, vous devez avoir accès aux poids et à la sortie de chaque neurone.
	        // Pseudo-code :
	        // for (chaque poids) {
	        //     poids[i] -= learningRate * delta * sortieDuNeuroneEntrant;
	        // }
	    }
	}

}
