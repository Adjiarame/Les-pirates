package personnage;

public class Pion {
    private Couleur couleurPion;

    public Pion(Couleur couleur) {
        this.setCouleurPion(couleur);
    }

	public Couleur getCouleurPion() {
		return couleurPion;
	}

	public void setCouleurPion(Couleur couleurPion) {
		this.couleurPion = couleurPion;
	}

    
}
