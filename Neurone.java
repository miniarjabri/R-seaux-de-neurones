package réseaux_de_neurones;
import java.util.Random;


public abstract class Neurone {
    // Méthode abstraite pour calculer les valeurs à envoyer à chaque neurone de la couche suivante
    public abstract double calculerSortie(double[] entrees);
}
