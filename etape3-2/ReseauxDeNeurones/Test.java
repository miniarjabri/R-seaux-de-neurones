package ReseauxDeNeurones;

import java.io.IOException;
import java.util.List;

import LotEchantillon.LotEchantillon_note;
import echantillon.Echantillon_note;

public class Test {
    public static void main(String[] args) {
    	
    	Echantillon_note echantillon1 = new Echantillon_note("HAL",new double[]{14, 10, 20, 15, 16});
    	Echantillon_note echantillon2 = new Echantillon_note("IBM",new double[]{7 ,14 ,2 ,12 ,8});
    	Echantillon_note echantillon3 = new Echantillon_note("JCN",new double[]{14, 13, 6, 4, 8});
    	Echantillon_note echantillon4 = new Echantillon_note("KDO",new double[]{6, 11, 16, 12, 20});
    	Echantillon_note echantillon5 = new Echantillon_note("LEP",new double[]{4, 12, 4, 18, 12});
    	Echantillon_note echantillon6 = new Echantillon_note("MFQ",new double[]{9, 10.4, 8, 10, 13});
    	Echantillon_note echantillon7 = new Echantillon_note("NGR",new double[]{10, 7.4, 6, 14, 16});
    	Echantillon_note echantillon8 = new Echantillon_note("OHS",new double[]{4, 8, 10, 12, 18});
    	Echantillon_note echantillon9 = new Echantillon_note("PIT",new double[]{5, 13, 5, 14, 12});
    	Echantillon_note echantillon10 = new Echantillon_note("QJU",new double[]{6, 19, 12, 8, 10});
    	

        LotEchantillon_note lotsEchantillon = new LotEchantillon_note();
        lotsEchantillon.ajouterEchantillon(echantillon1);
        lotsEchantillon.ajouterEchantillon(echantillon2);
        lotsEchantillon.ajouterEchantillon(echantillon3);
        lotsEchantillon.ajouterEchantillon(echantillon4);
        lotsEchantillon.ajouterEchantillon(echantillon5);
        lotsEchantillon.ajouterEchantillon(echantillon6);
        lotsEchantillon.ajouterEchantillon(echantillon7);
        lotsEchantillon.ajouterEchantillon(echantillon8);
        lotsEchantillon.ajouterEchantillon(echantillon9);
        lotsEchantillon.ajouterEchantillon(echantillon10);
        double CoutTotal=0;
        
        for (int i=0 ; i<lotsEchantillon.nombreEchantillons();i++) {
        	Echantillon_note e =lotsEchantillon.getEchantillons().get(i);
        	double [] input = e.getNotes();
        	int[] nbreNeuroneCouche = {5, 5, 5, 1};
        	double[] coef= {12,16,10,8,8};

            // Initialiser le réseau de neurones
            ReseauNeurone reseau = new ReseauNeurone(nbreNeuroneCouche.length, nbreNeuroneCouche, input,coef);
            double moy=reseau.calculerSortieAttendue(input, coef);
            double c =reseau.fonctionCout(moy,0);
            CoutTotal += Math.pow(c, 2)/2;
            
            System.out.println("la moyenne est ="+reseau.getOutput()[0]);
            
            if (reseau.getOutput()[0] < 10) {
                System.out.println("L'étudiant "+ e.getnom() +" n'a pas réussi");
            } 
            else if (reseau.getOutput()[0] >= 10 &&  reseau.getOutput()[0] < 12 ) {
                System.out.println("Mention Passable");
            } 
            else if (reseau.getOutput()[0] >= 12 &&  reseau.getOutput()[0] < 14 ) {
                System.out.println("Mention Assez bien");}
            else if (reseau.getOutput()[0] >= 14 &&  reseau.getOutput()[0] < 16 ) {
                System.out.println("Mention bien");}
            else {
                System.out.println("Mention Très bien");
            }
            
            System.out.println("Le cout est "+c);

        	
        }
        System.out.println("Le cout Total est "+CoutTotal);
      
       
        // Définir la structure du réseau
        
}}