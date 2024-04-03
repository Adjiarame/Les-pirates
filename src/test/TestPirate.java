
package test;

import personnage.Pirate;
import plateau.Case;
import plateau.Type;

public class TestPirate {
    public static void main(String[] args) {
        // Création d'un pirate pour les tests
        Pirate pirate = new Pirate();
        
        // Test 1(Vérifier que les points de vie corrects)
        assert pirate.getPointsDeVie() == 5 : "Les points de vie initiaux devraient être 5";

        // Test 2 (Appliquer des dégâts au pirate et vérifier les points de vie après)
        pirate.diminuerVie(2);
        assert pirate.getPointsDeVie() == 3 : "Après avoir subi 2 points de dégât, les points de vie devraient être 3";

        // Test 3 ( Appliquer des dégâts qui dépassent les points de vie et vérifier que les points de vie ne tombent pas en dessous de zéro)
        pirate.diminuerVie(5);
        assert pirate.getPointsDeVie() == 0 : "Les points de vie ne devraient pas tomber en dessous de zéro";

        // Test4  ( Simuler le déplacement du pirate sur une case et vérifier sa nouvelle position)
        Case nouvelleCase = new Case(10, Type.NORMAL); // Simule une case normale pour le test
        pirate.deplacerVers(nouvelleCase);
        assert pirate.getPosition() == nouvelleCase : "Le pirate devrait être sur la nouvelle case";

        // Test 5: Interaction avec une case spéciale, par exemple, une case Kraken
        Case caseKraken = new Case(5, Type.KRAKEN); // Simule une case Kraken pour le test
        pirate.deplacerVers(caseKraken); // Supposons que la méthode deplacerVers applique également l'effet de la case
        caseKraken.activerEffet(pirate); // Applique l'effet du Kraken
        assert pirate.getPointsDeVie() == 0 : "Le pirate devrait perdre 4 points de vie à cause du Kraken";

        System.out.println("Tous les tests sont passés avec succès.");
        // 
    }
}
