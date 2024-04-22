package ET;

public class LotEchantillon {
    protected Echantillon[] ech;    // Tableau des échantillons
    protected int nombreEchantillon; // Nombre actuel d'échantillons dans le lot

    public LotEchantillon(int taille) {
        this.ech = new Echantillon[taille];
        this.nombreEchantillon = 0;
    }

    // Ajoute un échantillon d'entraînement au lot
    public void ajouterEchantillon(Echantillon echantillon) {
        if (nombreEchantillon < ech.length) {
            ech[nombreEchantillon] = echantillon;
            nombreEchantillon++;
        } else {
            // Option 1: Gérer l'erreur
            throw new IllegalStateException("Le lot est plein. Impossible d'ajouter plus d'échantillons.");
            // Option 2: Étendre le tableau (non recommandé pour les tableaux, mieux avec ArrayList)
            // ech = Arrays.copyOf(ech, ech.length * 2);
            // ech[nombreEchantillon++] = echantillon;
        }
    }

    // Récupère un échantillon d'entraînement spécifique
    public Echantillon getEchantillon(int index) {
        if (index < 0 || index >= nombreEchantillon) {
            throw new IndexOutOfBoundsException("Index " + index + " hors des limites pour le lot d'échantillons.");
        }
        return ech[index];
    }

    // Récupère le nombre d'échantillons dans le lot
    public int getNombreEchantillons() {
        return nombreEchantillon;
    }
}
