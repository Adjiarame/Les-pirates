package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import plateau.De;

public class TestDe {

    @Test
    public void testLancerDe() {
        var De = new De();
        int resultat = plateau.De.lancer(); 
        assertTrue("Le résultat devrait être entre 1 et 6", resultat >= 1 && resultat <= 6);
    }
}
