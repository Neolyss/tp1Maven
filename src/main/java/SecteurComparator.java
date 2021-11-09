import java.util.Comparator;

public class SecteurComparator implements Comparator<Secteur> {

    @Override
    public int compare(Secteur o1, Secteur o2) {
        int s1 = o1.getAnimauxDansSecteur().size();
        int s2 = o2.getAnimauxDansSecteur().size();
        return Integer.compare(s1, s2);
    }
}
