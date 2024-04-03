package test;

import static org.junit.Assert.assertEquals;

import jeu.Affichage;
import jeu.Jeu;
import personnage.Pirate;

import org.junit.Test;

public class Testaffichage {
    
    @Test
    public void testMessageBienvenue() {
        String expected = "Bienvenue dans le jeu Les Pirates !";
        assertEquals(expected, Affichage.messageBienvenue());
    }
    
    @Test
    public void testGagnant() {
        Pirate pirate = new Pirate("Jack", 100); // Assurez-vous que cette signature de constructeur existe
        String expected = "Jack a gagné la partie !";
        assertEquals(expected, Affichage.gagnant(pirate));
    }
    
    // Vous pouvez ajouter d'autres tests pour les méthodes restantes
}
