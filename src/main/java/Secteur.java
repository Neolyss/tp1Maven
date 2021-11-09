import java.util.*;

public class Secteur implements Comparable<Secteur> {

    private TypeAnimal typeAnimauxDansSecteur;
    private List<Animal> animauxDansSecteur;

    public Secteur(TypeAnimal typeAnimal) {
        this.typeAnimauxDansSecteur = typeAnimal;
        this.animauxDansSecteur = new ArrayList<>();
    }

    public void ajouterAnimal(Animal animal) {
        animauxDansSecteur.add(animal);
    }

    public int getNombreAnimaux() {
        return animauxDansSecteur.size();
    }

    public List<Animal> getAnimauxDansSecteur() {
        return animauxDansSecteur;
    }

    public TypeAnimal obtenirType() {
        return typeAnimauxDansSecteur;
    }

    @Override
    public int compareTo(Secteur s) {
        return this.getNombreAnimaux() - s.getNombreAnimaux();
    }
}
