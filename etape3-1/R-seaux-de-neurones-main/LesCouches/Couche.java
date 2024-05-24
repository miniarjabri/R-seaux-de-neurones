package LesCouches;

public interface Couche<N> {
    // Méthode pour obtenir le nombre de neurones dans la couche
    int getNombreNeurones();

    // Méthode pour obtenir le type de la couche (couche d'entrée, cachée ou de sortie)
    String getTypeCouche();

    // Méthode pour obtenir les neurones de la couche
    N[] getNeurones();

    // Méthode pour obtenir la sortie des neurones de la couche
    double[] getSortie();

    // Méthode pour mettre à jour les biais et les poids des neurones de la couche
    void updateBiasesAndWeights(double[] nablaB, double[][] nablaW);

    // Méthode pour obtenir les poids des connexions des neurones de la couche
    double[][] getPoids();

    // Méthode pour obtenir les activations des neurones de la couche
    double[] activation();

    // Méthode pour obtenir les valeurs Z (somme pondérée plus biais) des neurones de la couche
    double[] getZ(double[] activation);

    // Méthode pour obtenir la dérivée de l'activation des neurones de la couche
    double[] activationPrime(double[] ds);

    // Méthode pour obtenir la sortie des neurones de la couche en fonction des activations
    double[] sortie(double[] activations);
}
