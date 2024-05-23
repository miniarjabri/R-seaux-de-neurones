package LesCouches;

public interface Couche<N> {
    // Méthode pour obtenir le nombre de neurones dans la couche
    int getNombreNeurones();

    // Méthode pour obtenir le type de la couche (couche d'entrée, cachée ou de sortie)
    String getTypeCouche();

    N[] getNeurones();

    double[] getSortie();

    void updateBiasesAndWeights(double[] nablaB, double[][] nablaW);

    double[][] getPoids();

    double[] activation();

    double[] getZ(double[] activation);

    double[] activationPrime(double[] ds);

    double[] sortie(double[] activations);
}

/*package LesCouches;

public interface Couche<N> {
    // Méthode pour obtenir le nombre de neurones dans la couche
    int getNombreNeurones();

    // Méthode pour obtenir le type de la couche (couche d'entrée, cachée ou de sortie)
    String getTypeCouche();

    N[] getNeurones();

    double[] getSortie();

    void updateBiasesAndWeights(double[] nablaB, double[][] nablaW);

    double[][] getPoids();

    double[] activation();

    double[] getZ(double[] activation);

    double[] activationPrime(double[] ds);

    double[] sortie(double[] activations);
}
*/