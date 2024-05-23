package ReseauxDeNeurones;

import LesCouches.*;
import LesNeurones.*;

import java.util.ArrayList;
import java.util.List;

public class ReseauNeurone {
	  private Couche<?>[] couches; // Liste des couches du réseau
	    private int nombreCouches; // Nombre total de couches dans le réseau
	    private double[] input; // Données d'entrée
	    private double[] Ouroutput; // Sortie attendue

	    // Constructeur
	    public ReseauNeurone(int nombreCouches, int[] nbreNeuroneCouche, double[] input) {
	        this.nombreCouches = nombreCouches;
	        this.input = input;
	       

	        // Initialiser le tableau de couches
	        couches = new Couche<?>[nombreCouches];

	        // Créer la couche d'entrée
	        couches[0] = new CoucheEntree(input[0], nbreNeuroneCouche[0], nbreNeuroneCouche[1]);

	        // Créer les couches cachées
	        for (int i = 1; i < nombreCouches - 1; i++) {
	            if (i == 1) {
	                couches[i] = new CoucheCachee(nbreNeuroneCouche[i], (NeuroneEntree[]) couches[i - 1].getNeurones(), nbreNeuroneCouche[i + 1]);
	            } else {
	                couches[i] = new CoucheCachee(nbreNeuroneCouche[i], (NeuroneCache[]) couches[i - 1].getNeurones(), nbreNeuroneCouche[i + 1]);
	            }
	        }

	        // Créer la couche de sortie
	        couches[nombreCouches - 1] = new CoucheSortie(nbreNeuroneCouche[nombreCouches - 1], (NeuroneCache[]) couches[nombreCouches - 2].getNeurones());
	        Ouroutput=couches[nombreCouches-1].getSortie();
	    }
	  public double[]  getOutput ()
	  {return Ouroutput;}

}

