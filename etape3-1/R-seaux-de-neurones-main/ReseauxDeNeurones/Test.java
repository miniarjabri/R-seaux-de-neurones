package ReseauxDeNeurones;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
    	
    	double[] input = {14, 10, 2, 9, 17};
       double [][] output= {};
       
        // Définir la structure du réseau
        int[] nbreNeuroneCouche = {5, 5, 5, 1};

        // Initialiser le réseau de neurones
        ReseauNeurone reseau = new ReseauNeurone(nbreNeuroneCouche.length, nbreNeuroneCouche, input);
        
        for (int i=0;i<reseau.getOutput().length;i++)
        {System.out.println("la moyenne est ="+reseau.getOutput()[i]);
        }
        if (reseau.getOutput()[0]<10 ) {
        	System.out.println("l'étudiant n'a pas réussi");
        } else {
        	System.out.println("l'étudiant a réussi");
        }
    
        
    }
}