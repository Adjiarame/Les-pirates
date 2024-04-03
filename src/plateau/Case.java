package plateau;


import personnage.Pirate;

public class Case {
    private final int numero;
    private final Type type;

    public Case(int numero, Type type) {
        this.numero = numero;
        this.type = type;
    }

    public void activerEffet(Pirate pirate) {
        switch (type) {
            case KRAKEN:
                if (!pirate.estProtege()) {
                    pirate.diminuerVie(4);
                    System.out.println("Un Kraken attaque ! " + pirate.getNom() + " perd 4 points de vie.");
                } else {
                    pirate.activerProtection();
                    System.out.println(pirate.getNom() + " est protégé par une potion et survit à l'attaque du Kraken !");
                }
                break;
            case PERROQUET:
                pirate.augmenterVie(2);
                System.out.println("Un Perroquet apporte un bonus ! " + pirate.getNom() + " gagne 2 points de vie.");
                break;
            case POTION:
                pirate.activerProtection();
                System.out.println(pirate.getNom() + " trouve une potion et est maintenant protégé pour le prochain tour.");
                break;
            case NORMAL:
            default:
                System.out.println(pirate.getNom() + " est sur une case normale.");
                break;
        }
    }

    public int getNumero() {
        return numero;
    }

    public Type getType() {
        return type;
    }
}
