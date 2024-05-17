package LesCouches;

import LesNeurones.*;
import java.util.Arrays;
import java.util.List;

public class CoucheCachee implements Couche <NeuroneCache>{
    private NeuroneCache[] neuronnes; // Tableau des neurones de la couche cachée
    private int nbNeuronne; // Nombre de neurones dans la couche cachée

    // Constructeur prenant en paramètres le nombre de neurones, le type de fonction, une liste de neurones et le nombre de neurones dans la couche suivante
    public CoucheCachee(int nbNeuronne, String typeFonction, Object[] objects, int nbreNeuronneCoucheSuivante) {
        this.nbNeuronne = nbNeuronne;
        this.neuronnes = new NeuroneCache[nbNeuronne]; // Initialize the neuron array

        // Initialisation des neurones de la couche cachée avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neuronnes[i] = new NeuroneCache(typeFonction, (Neuronne[]) objects, i, nbreNeuronneCoucheSuivante);
        }
    }

	// Méthode pour obtenir le nombre de neurones dans la couche
    @Override
    public int getNombreNeurones() {
        return nbNeuronne;
    }
    @Override
    // Méthode pour obtenir la liste des neurones de la couche cachée
    public NeuroneCache [] getNeurones() {
        return neuronnes; // Retourne la liste des neurones de la couche cachée
    }

    // Méthode pour définir les neurones de la couche cachée
    public void setNeurones(List<NeuroneCache> neurones) {
        this.neuronnes = neurones.toArray(new NeuroneCache[0]); // Réinitialise la liste des neurones avec une nouvelle liste
    }

    // Méthode pour obtenir le type de la couche (ici, couche cachée)
    @Override
    public String getTypeCouche() {
        return "Cachee";}
     @Override
     public double[] getSortie( String TypeFonction) {
     double [] s=null;
     s[0]=0;
     return s;
}
}