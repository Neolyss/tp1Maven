public class AnimalDansMauvaisSecteurException extends Exception {

    private Animal animal;
    private Secteur secteur;

    public AnimalDansMauvaisSecteurException(Animal animal, Secteur secteur) {
        this.animal = animal;
        this.secteur = secteur;
    }

    @Override
    public String toString() {
        return "AnimalDansMauvaisSecteurException{" +
                "animal=" + animal +
                ", secteur=" + secteur +
                '}';
    }
}
