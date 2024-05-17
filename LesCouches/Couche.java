package LesCouches;

import LesNeurones.*;

import java.util.List;

// Interface définissant les méthodes communes pour toutes les couches du réseau de neurones
public interface Couche<N> {
    // Méthode pour obtenir le nombre de neurones dans la couche
    int getNombreNeurones();

// Méthode pour obtenir la liste des neurones de la couche
  
    //  List<N> getNeurones();

// Méthode pour définir les neurones de la couche
   
    // void setNeurones(List<N> neurones);

 // Méthode pour obtenir le type de la couche (couche d'entrée, cachée ou de sortie)
    String getTypeCouche();

		N[] getNeurones();
		 double[] getSortie(String TypeFonction) ;
}
