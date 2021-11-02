import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private int visiteurs;
    private List<Secteur> secteursAnimaux;
    private static final int NB_VISITEUR_MAX_PAR_SECTEUR = 15;

    public Zoo(int nbVisiteurMaxParSecteur) {
        this.visiteurs = 0;
        this.secteursAnimaux = new ArrayList<>();
    }

    public void ajouterSecteur(TypeAnimal typeAnimal) {
        secteursAnimaux.add(new Secteur(typeAnimal));
    }

    public void nouveauVisiteur() throws LimiteVisiteurException {
        if(visiteurs+1 > NB_VISITEUR_MAX_PAR_SECTEUR * secteursAnimaux.size()) {
            throw new LimiteVisiteurException(this);
        }
        visiteurs++;
    }

    public int getLimiteVisiteur() {
        return NB_VISITEUR_MAX_PAR_SECTEUR * secteursAnimaux.size();
    }

    public List<Secteur> getSecteursAnimaux() {
        return secteursAnimaux;
    }

    public void nouvelAnimal(Animal animal) {
        for (TypeAnimal type : TypeAnimal.values()) {

        }
    }

    public int getNombreAnimaux() {
        return secteursAnimaux.stream().mapToInt(Secteur::getNombreAnimaux).sum();
    }
}
