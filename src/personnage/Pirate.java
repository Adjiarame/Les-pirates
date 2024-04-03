package personnage;

import plateau.Case;

public class Pirate {
    private String nom;
    private Couleur couleur; // S'assurer que l'énumération Couleur est correctement définie.
    private int position; // La position actuelle du pirate sur le plateau est un entier simple.
    private boolean protege = false; // Indique si le pirate est protégé par une potion.

    public Pirate(String nom, Couleur couleur, int positionInitiale) {
        this.nom = nom;
        this.couleur = couleur;
        this.position = positionInitiale; // Commence à la position 1 par défaut.
    }

    public void avancer(int des) {
        this.position += des;
        if (this.position > 30) this.position = 30; // Ne dépasse pas la dernière case.
    }

    public String getNom() { return nom; }
    public int getPosition() { return position; }
    public void setPosition(int nouvellePosition) { this.position = nouvellePosition; } // Modifier pour accepter un int.
    public Couleur getCouleur() { return couleur; }
    public boolean estProtege() { return protege; }
    public void setProtege(boolean protege) { this.protege = protege; }

	public void diminuerVie(int i) {
		// TODO Auto-generated method stub
		
	}

	public void activerProtection() {
		// TODO Auto-generated method stub
		
	}

	public void augmenterVie(int i) {
		// TODO Auto-generated method stub
		
	}

	public void perdreVie(int i) {
		// TODO Auto-generated method stub
		
	}

	public void gagnerVie(int i) {
		// TODO Auto-generated method stub
		
	}
}
