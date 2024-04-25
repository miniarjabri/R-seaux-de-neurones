package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.List;

public class CoucheCachee implements Couche<NeuroneCachee> {
    private NeuroneCachee[] neuronnes; // Tableau des neurones de la couche cachée
    private int nbNeuronne; // Nombre de neurones dans la couche cachée

    // Constructeur prenant en paramètres le nombre de neurones, le type de fonction, une liste de neurones et le nombre de neurones dans la couche suivante
    public CoucheCachee(int nbNeuronne, String typeFonction, Neuronne[] n, int nbreNeuronneCoucheSuivante) {
        this.nbNeuronne = nbNeuronne;

        // Initialisation des neurones de la couche cachée avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neuronnes[i] = new NeuroneCachee(typeFonction, n, i, nbreNeuronneCoucheSuivante);
        }
    }

    // Méthode pour obtenir le nombre de neurones dans la couche
    @Override
    public int getNombreNeurones() {
        return nbNeuronne;
    }

    // Méthode pour obtenir la liste des neurones de la couche cachée
    @Override
    public List<NeuroneCachee> getNeurones() {
        return Arrays.asList(neuronnes); // Retourne la liste des neurones de la couche cachée
    }

    // Méthode pour définir les neurones de la couche cachée
    @Override
    public void setNeurones(List<NeuroneCachee> neurones) {
        this.neuronnes = neurones.toArray(new NeuroneCachee[0]); // Réinitialise la liste des neurones avec une nouvelle liste
    }

    // Méthode pour obtenir le type de la couche (ici, couche cachée)
    @Override
    public String getTypeCouche() {
        return "Cachee";
    }
}
