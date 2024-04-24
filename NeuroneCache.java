package LesNeurones;

import java.util.Arrays;
import java.util.Random;

public class NeuroneCache {
    private double[] poids;
    private double biais;
    private int position;
    private String typeFonction ;
    private double agregation;
    private double activation ; 
    
    // Constructor to initialize the neuron with weights, bias, and position
    public NeuroneCache(String typeFonction  ,Neuronne[] n , int position , int nbNeuronneCoucheSuivante) {
    	//valeau aléatoire du biais (seuil)
    	Random random = new Random();
        biais = random.nextDouble(); 
        
        //initialisation des poids aléatoirement 
        for (i=0; i<nbNeuronneCoucheSuivante ; i++)
        {
        	Random random = new Random();
            poids[i]=random
        }
        
        //position du neuronne dans la couche
        this.position = position; //position du neuronne dans la couche
        
        //calcul de l'agrégation du neuronne
        agregation = sommePonderee(n , position ) + biais;
        
        //calcul de l'activation du neuronne
        this.activation = Factivation (agregation , typeFonction);
   
    }
    double sommePonderee (Neuronne[] n , int pos )
    {double somme;
    	for (int i=0; i<pos ; i++)
    	{
    		somme=neuronne[i].getPoids()[pos-1]*neuronne[i].getActivation();
    	}
    return somme; 
    }


    public void setPoids(double[] poids) {
        this.poids = Arrays.copyOf(poids, poids.length);
    }

    public double[] getPoids() {
        return this.poids;
    }
    public void setBiais(double biais) {
        this.biais = biais;
    }

    public double getBiais() {
        return this.biais;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

/*    public double agregation(Object[] n) {
	    double z = biais;
	    for (Object neuron : n) {
	        if (neuron instanceof NeuroneEntree) {
	            NeuroneEntree entree = (NeuroneEntree) neuron;
	            z += entree.getPoids()[position] * entree.activation();  
	        } else if (neuron instanceof NeuroneCachee) {
	            NeuroneCachee cachee = (NeuroneCachee) neuron;
	            z += cachee.getPoids()[position] * cachee.activation();
	        }
	    }
	    return z;
	}
*/
// Placeholder for the activation method to avoid recursion
   public double activation(double z , String  TypeFonction) {
	   if (TypeFonction == "sigmoide" )
	    activation =  1 / (1 + Math.exp(z));
	
  return activation ; 
}
   }

