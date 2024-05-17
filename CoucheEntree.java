package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoucheEntree implements Couche{
    private NeuroneEntree[] neuronnes; // Tableau des neurones d'entrée
    private int nbNeuronnes; // Nombre de neurones dans la couche d'entrée

    // Constructeur qui prend en paramètre un tableau d'entrées et le nombre de neurones dans la couche suivante
    public CoucheEntree(double[] input, int nbNeuronnes, int nbNeuronneCoucheSuivante) {
        this.nbNeuronnes = nbNeuronnes;

        // Initialisation des neurones d'entrée avec les valeurs d'entrée fournies
        for (int i = 0; i < nbNeuronnes; i++) {
            neuronnes[i] = new NeuroneEntree(input[i], nbNeuronneCoucheSuivante);
        }
    }

    // Méthode pour obtenir le nombre de neurones dans la couche
    @Override
    public int getNombreNeurones() {
        return nbNeuronnes;
    }

    // Méthode pour obtenir la liste des neurones d'entrée
    public NeuroneEntree [] getNeurones() {
        return neuronnes; // Retourne la liste des neurones d'entrée
    }

    // Méthode pour définir les neurones de la couche
    public void setNeurones(List<NeuroneEntree> neurones) {
        this.neuronnes = neurones.toArray(new NeuroneEntree[0]); // Réinitialise la liste des neurones avec une nouvelle liste
    }

    // Méthode pour obtenir le type de la couche (ici, couche d'entrée)
    @Override
    public String getTypeCouche() {
        return "Entree";
    }
    @Override
    public double[] getSortie( String TypeFonction) {
    double [] s=null;
    s[0]=0;
    return s;
}
}
