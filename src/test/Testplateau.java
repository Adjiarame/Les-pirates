package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import jeu.Case;
import personnage.Pirate;
import plateau.Plateau;
import plateau.Type;

public class TestPlateau {
    
    private Plateau plateau;
    private Pirate pirate;
    
    @Before
    public void setUp() {
        plateau = new Plateau(20); // Initialiser un plateau avec 20 cases pour le test
        pirate = new Pirate("Test Pirate", 10); // Initialiser un pirate pour les tests
    }
    
    @Test
    public void testDeplacementPirate() {
        Case caseDepart = plateau.getCaseDepart();
        pirate.deplacerVers(caseDepart); // Positionner le pirate au départ
        
        Case nouvelleCase = plateau.deplacerPirate(pirate, 5); // Simuler un déplacement de 5 cases
        
        // Vérifier que le pirate a bien été déplacé de 5 cases
        assertEquals("Le pirate devrait être déplacé à la case 5", 5, nouvelleCase.getNumero());
    }
    
    @Test
    public void testDerniereCaseAtteinte() {
        Case caseDepart = plateau.getCaseDepart();
        pirate.deplacerVers(caseDepart); // Positionner le pirate au départ
        plateau.deplacerPirate(pirate, 19); // Déplacer le pirate jusqu'à la dernière case
        
        // Vérifier si le pirate a atteint la dernière case
        assertTrue("Le pirate devrait avoir atteint la dernière case", plateau.estDerniereCaseAtteinte(pirate));
    }
    
    // Vous pouvez ajouter plus de tests ici pour couvrir d'autres scénarios et méthodes
}
