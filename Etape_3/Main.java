package etape3;

public class Main {
    public static void main(String[] args) {
        // Création du réseau de neurones
        ReseauNeuronesBAC reseau = new ReseauNeuronesBAC();

        // Création des étudiants et ajout de leurs notes
        etudiant etudiant1 = new etudiant("HAL");
        etudiant1.addNote("MATH",9, 12);
        etudiant1.addNote("NSI",10, 16);
        etudiant1.addNote("PC",10, 10);
        etudiant1.addNote("SVT",14, 8);
        etudiant1.addNote("SI",14,8);
        reseau.ajouterEtudiant(etudiant1);

        // Ajoutez d'autres étudiants de la même manière...

        // Vérification de la réussite au BAC et de la mention pour chaque étudiant
        for (etudiant etudiant : reseau.getEtudiants()) {
            boolean reussi = reseau.reussiteBAC(etudiant);
            String mention = reseau.mentionBAC(etudiant);
            
            System.out.println("Étudiant : " + etudiant.getNom());
            System.out.println("Réussite au BAC : " + (reussi ? "Oui" : "Non"));
            System.out.println("Mention : " + mention);
            System.out.println("------------------------");
        }

        // Calcul de la fonction de coût
        double cout = reseau.fonctionCout();
        System.out.println("Fonction de coût : " + cout);
    }
}
