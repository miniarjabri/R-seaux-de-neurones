package echantillon;

public class Equivalent {
	    private final int poidsX;
	    private final int poidsY;
	    private final int seuil;

	    public Equivalent(int poidsX, int poidsY, int seuil) {
	        this.poidsX = poidsX;
	        this.poidsY = poidsY;
	        this.seuil = seuil;
	    }

	    public int evaluer(int entreeX, int entreeY) {
	        // Calcul de la somme pondérée
	        int sommePonderee = poidsX * entreeX + poidsY * entreeY;

	        // Calcul de la sortie en fonction de la somme pondérée et du seuil
	        if (sommePonderee ==seuil) {
	            return 0;
	        } else {
	            return 1;
	        }
	    }
	}
