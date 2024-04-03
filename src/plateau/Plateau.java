package plateau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import personnage.Pirate;

public class Plateau {
    private List<Integer> cases = new ArrayList<>();
    public static final int KRACKEN = 1;
    public static final int PERROQUET = 2;
    public static final int POTION = 3;

    public Plateau() {
        // Initialisation 
        for (int i = 0; i < 30; i++) {
            cases.add(0); 
        }

      
        ajouterCasesSpeciales();
    }

    // Méthode pour ajouter les cases spéciales (Kraken, Perroquet, Potion)
    private void ajouterCasesSpeciales() {
        Random random = new Random();

        // Ajout des Krakens
        for (int i = 0; i < 2; i++) {
            int position = random.nextInt(30); // Position aléatoire
            cases.set(position, KRACKEN);
        }

        // Ajout des Perroquets
        for (int i = 0; i < 4; i++) {
            int position = random.nextInt(30); // Position aléatoire
            while (cases.get(position) != 0) { // si la case est déjà occupée
                position = random.nextInt(30);
            }
            cases.set(position, PERROQUET);
        }

        // Ajout des Potions
        for (int i = 0; i < 6; i++) {
            int position = random.nextInt(30); // Position aléatoire
            while (cases.get(position) != 0) { // si la case est déjà occupée
                position = random.nextInt(30);
            }
            cases.set(position, POTION);
        }
    }

    
    public void afficher(int positionJoueur1, int positionJoueur2) {
        for (int i = 1; i <= 30; i++) {
            if (i == positionJoueur1 && i == positionJoueur2) {
                System.out.print(" B "); // B , les deux joueurs sont sur la même case
            } else if (i == positionJoueur1) {
                System.out.print(" J1 "); // Marque la position du joueur 1
            } else if (i == positionJoueur2) {
                System.out.print(" J2 "); // Marque la position du joueur 2
            } else {
                System.out.print(" " + i + " "); // Affiche le numéro de la case si aucun joueur n'est présent
            }
        }
        System.out.println(); // Nouvelle ligne à la fin de l'affichage du plateau
    }

    
    public void deplacerPirateEtActiverEffet(Pirate pirate, int nombreCases) {
        int nouvellePosition = pirate.getPosition() + nombreCases;
        if (nouvellePosition > 30) {
            nouvellePosition = 30; // Limite la position à 30
        }

        int effet = cases.get(nouvellePosition - 1); // Récupère l'effet de la case cible

        switch (effet) {
            case KRACKEN:
                pirate.diminuerVie(4); 
                break;
            case PERROQUET:
                pirate.augmenterVie(2); 
                nouvellePosition += 2; 
                break;
            case POTION:
                pirate.setProtege(true); 
                break;
            default:
                break;
        }

        pirate.setPosition(nouvellePosition); 
    }

    
    public int getTypeCase(int position) {
        return cases.get(position - 1);
    }
}
