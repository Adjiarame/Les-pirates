package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import personnage.Pirate;
import plateau.Case;
import plateau.Type;

public class TestCase {

    private Pirate pirate;
    private Case caseNormale, caseKraken, casePerroquet, casePotion;

    @Before
    public void setUp() {
        // Initialisation des objets pour les tests
        pirate = new Pirate("Test Pirate", 10);
        caseNormale = new Case(1, Type.NORMAL);
        caseKraken = new Case(2, Type.KRAKEN);
        casePerroquet = new Case(3, Type.PERROQUET);
        casePotion = new Case(4, Type.POTION);
    }

    @Test
    public void testEffetKraken() {
        int vieInitiale = pirate.getPointsDeVie();
        caseKraken.activerEffet(pirate);
        assertEquals("La vie du pirate devrait diminuer de 4 après une rencontre avec Kraken", vieInitiale - 4, pirate.getPointsDeVie());
    }

    @Test
    public void testEffetPotion() {
        casePotion.activerEffet(pirate);
        assertTrue("Le pirate devrait être immunisé après avoir trouvé une Potion", pirate.estImmunise());
    }

    // Test pour Perroquet et autres cases spéciales...

    // Note: Vous devrez implémenter des méthodes dans Pirate pour que ces tests fonctionnent, par exemple, estImmunise() pour tester l'effet de Potion.
}
