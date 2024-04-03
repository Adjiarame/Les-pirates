package jeu;

import java.util.Random;
import java.util.Scanner;
import personnage.Pirate;
import personnage.Couleur;
import plateau.Plateau;

public class Jeu {
    private Plateau plateau;
    private Pirate joueur1;
    private Pirate joueur2;
    private Scanner scanner = new Scanner(System.in);

    public Jeu() {
        plateau = new Plateau();
        initialiserPirates();
    }

    private void initialiserPirates() {
        System.out.println("Bienvenue dans le jeu Les Pirates!");

        String nomJoueur1 = "Jack Le Borgne";
        String nomJoueur2 = "Bill Jambe De Bois";

        System.out.println("Choisissez la couleur pour " + nomJoueur1 + " (1 - Rouge, 2 - Bleu):");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        Couleur couleurJoueur1 = choix == 1 ? Couleur.ROUGE : Couleur.BLEU;
        Couleur couleurJoueur2 = couleurJoueur1 == Couleur.ROUGE ? Couleur.BLEU : Couleur.ROUGE;

        joueur1 = new Pirate(nomJoueur1, couleurJoueur1, 1);
        joueur2 = new Pirate(nomJoueur2, couleurJoueur2, 1);

        System.out.println(nomJoueur1 + " sera de couleur " + couleurJoueur1);
        System.out.println(nomJoueur2 + " sera de couleur " + couleurJoueur2);
    }

    public void jouer() {
        System.out.println("Début du jeu Les Pirates !");
        System.out.println("Que le meilleur gagne !");

        boolean jeuTermine = false;
        for (int tour = 1; !jeuTermine; tour++) {
            System.out.println("Tour " + tour + ". Appuyez sur Entrée pour continuer...");
            scanner.nextLine();

            if (jouerTour(joueur1)) {
                jeuTermine = true;
            } else {
                System.out.println("Tour " + tour + ". Appuyez sur Entrée pour continuer...");
                scanner.nextLine();
                if (jouerTour(joueur2)) {
                    jeuTermine = true;
                }
            }
        }

        System.out.println("Le jeu est terminé !");
    }

    private boolean jouerTour(Pirate pirate) {
        System.out.println(pirate.getNom() + " joue...");
        scanner.nextLine(); // Attendre l'appui sur Entrée pour simuler le lancer de dés
        int des = lancerDes();
        System.out.println("Dé de " + pirate.getNom() + ": " + des);
        pirate.avancer(des);
        plateau.afficher(joueur1.getPosition(), joueur2.getPosition()); // Correction ici

        // Gérer les effets des cases spéciales
        switch (plateau.getTypeCase(pirate.getPosition())) {
            case Plateau.KRACKEN: 
                pirate.perdreVie(4);
                System.out.println("Oh non ! " + pirate.getNom() + " est attaqué par le Kraken et perd 4 points de vie !");
                break;
            case Plateau.PERROQUET: 
                Random random = new Random();
                int bonus = random.nextBoolean() ? 2 : 0;
                pirate.gagnerVie(2 + bonus);
                System.out.println(pirate.getNom() + " trouve un perroquet et gagne " + (2 + bonus) + " points de vie !");
                break;
            case Plateau.POTION: 
                pirate.activerProtection();
                System.out.println(pirate.getNom() + " trouve une potion et est protégé pour le prochain tour !");
                break;
            default:
                break;
        }

        if (pirate.getPosition() >= 30) {
            System.out.println(pirate.getNom() + " a gagné la partie !");
            return true; // fin jeu
        }
        return false; // Continue le jeu
    }

    private int lancerDes() {
        Random random = new Random();
        return random.nextInt(6) + 1 + random.nextInt(6) + 1; // Simuler le lancer de deux dés
    }

    public static void main(String[] args) {
        new Jeu().jouer();
    }

    public Object getPirate1() {
        return null;
    }
}
