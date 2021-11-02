import org.junit.Before;
import org.junit.Test;

public class ZooTest {

    private Zoo zoo;

    @Before
    public void initZoo() {
        this.zoo = new Zoo(2);
        zoo.ajouterSecteur(TypeAnimal.CHAT);
        zoo.ajouterSecteur(TypeAnimal.TIGRE);
        zoo.nouvelAnimal(new Chat("Titi", TypeAnimal.CHAT));
        zoo.nouvelAnimal(new Tigre("OwO", TypeAnimal.TIGRE));
    }

    @Test(expected=LimiteVisiteurException.class)
    public void testNouveauVisiteur() throws LimiteVisiteurException {
        for(int i=0; i<33; i++) {
            zoo.nouveauVisiteur();
        }
    }

    @Test
    public void testNouvelAnimal() {
        //Chien woof = new Chien("UwU",TypeAnimal.CHIEN);
        //zoo.nouvelAnimal(woof);

    }
}