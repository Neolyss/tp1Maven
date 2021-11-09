import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZooTest {

    private Zoo zoo;

    @Before
    public void initZoo() {
        this.zoo = new Zoo(2);
    }

    @Test(expected=LimiteVisiteurException.class)
    public void testNouveauVisiteur() throws LimiteVisiteurException {
        for(int i=0; i<33; i++) {
            zoo.nouveauVisiteur();
        }
    }

    @Test
    public void testNouvelAnimal() {
        Chien woof = new Chien("UwU",TypeAnimal.CHIEN);
        zoo.nouvelAnimal(woof);
        assertEquals(1, zoo.getNombreAnimaux());
        for(Secteur secteur : zoo.getSecteursAnimaux()) {
            for(Animal animal : secteur.getAnimauxDansSecteur()) {
                if(woof == animal) {
                    assertEquals(secteur.obtenirType(), woof.getTypeAnimal());
                }
            }
        }
    }

    @Test
    public void testAjoutAnimalSansAjoutSecteur() {
        Chien woof = new Chien("UwU",TypeAnimal.CHIEN);
        zoo.ajouterSecteur(TypeAnimal.CHIEN);
        zoo.nouvelAnimal(woof);
        Chat chat = new Chat("oWo", TypeAnimal.CHAT);
        zoo.nouvelAnimal(chat);
        assertEquals(2, zoo.getSecteursAnimaux().size());
    }

    @Test
    public void testComparator() {
        zoo.ajouterSecteur(TypeAnimal.CHIEN);
        zoo.ajouterSecteur(TypeAnimal.CHAT);
        zoo.ajouterSecteur(TypeAnimal.TIGRE);

        Secteur chien = zoo.getSecteursAnimaux().get(0);
        Secteur chat = zoo.getSecteursAnimaux().get(1);
        Secteur tigre = zoo.getSecteursAnimaux().get(2);

        SecteurComparator c = new SecteurComparator();

        assertEquals(0, c.compare(chien,chat));
        zoo.nouvelAnimal(new Chien("oWo", TypeAnimal.CHIEN));
        assertEquals(1, c.compare(chien,chat));
        zoo.nouvelAnimal(new Tigre("uWu", TypeAnimal.TIGRE));
        zoo.nouvelAnimal(new Tigre("AwA", TypeAnimal.TIGRE));
        assertEquals(-1, c.compare(chien,tigre));
    }

    @Test
    public void testCompareTo() {
        zoo.ajouterSecteur(TypeAnimal.CHIEN);
        zoo.ajouterSecteur(TypeAnimal.CHAT);
        zoo.ajouterSecteur(TypeAnimal.TIGRE);

        Secteur chien = zoo.getSecteursAnimaux().get(0);
        Secteur chat = zoo.getSecteursAnimaux().get(1);
        Secteur tigre = zoo.getSecteursAnimaux().get(2);

        assertEquals(0, chien.compareTo(chat));
        zoo.nouvelAnimal(new Chien("oWo", TypeAnimal.CHIEN));
        assertEquals(1, chien.compareTo(chat));
        zoo.nouvelAnimal(new Tigre("uWu", TypeAnimal.TIGRE));
        zoo.nouvelAnimal(new Tigre("AwA", TypeAnimal.TIGRE));
        assertEquals(-1, chien.compareTo(tigre));
    }

}