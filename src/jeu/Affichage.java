package jeu;

import personnage.Pirate;
import plateau.Plateau;

public class Affichage {
    private Plateau plateau;

   
    public Affichage(Plateau plateau) {
        this.plateau = plateau;
    }

    
    public void afficherEtatJeu() {
        System.out.println("État actuel du jeu:");
        System.out.println(plateau.getJoueur1().getNom() + " - Points de vie : " + plateau.getJoueur1().getPointsDeVie());
        System.out.println(plateau.getJoueur2().getNom() + " - Points de vie : " + plateau.getJoueur2().getPointsDeVie());
        // la méthode afficherPlateau pour afficher le plateau
        afficherPlateau();
    }

    // Méthode privée pour afficher le plateau
    private void afficherPlateau() {
        plateau.afficher();
    }

    // afficher un message
    public static void afficherMessage(String message) {
        System.out.println(message);
    }

    //  afficher un message de bienvenue
    public static void afficherBienvenue() {
        System.out.println("Bienvenue dans le jeu Les Pirates !");
    }

    //  afficher le gagnant de la partie
    public static void afficherGagnant(Pirate pirate) {
        System.out.println(pirate.getNom() + " a gagné la partie !");
    }
}
