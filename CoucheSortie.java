package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.List;

public class CoucheSortie implements Couche<NeuroneSortie> {
    private NeuroneSortie[] neurones; // Tableau des neurones de la couche de sortie

    // Constructeur prenant en paramètres le nombre de neurones, le type de fonction et une liste de neurones
    public CoucheSortie(int nbNeuronne, String typeFonction, Neuronne[] n) {
        this.nbNeuronne = nbNeuronne;

        // Initialisation des neurones de la couche de sortie avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neurones[i] = new NeruonneCachee(typeFonction, n, i);
        }
    }

    // Méthode pour obtenir le nombre de neurones dans la couche
    @Override
    public int getNombreNeurones() {
        return neurones.size(); 
    }

    // Méthode pour obtenir la liste des neurones de la couche de sortie
    @Override
    public List<NeuroneSortie> getNeurones() {
        return neurones; // Retourne la liste des neurones de la couche de sortie
    }

    // Méthode pour définir les neurones de la couche de sortie
    @Override
    public void setNeurones(List<NeuroneSortie> neurones) {
        this.neurones = new ArrayList<>(neurones); // Réinitialise la liste des neurones avec une nouvelle liste
    }

    // Méthode pour obtenir le type de la couche (ici, couche de sortie)
    @Override
    public String getTypeCouche() {
        return "Sortie";
    }
}
