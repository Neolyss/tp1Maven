public class LimiteVisiteurException extends Exception {

    private Zoo zoo;

    public LimiteVisiteurException(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public String toString() {
        return "LimiteVisiteurException{" +
                "limiteVisiteur=" + zoo.getLimiteVisiteur() +
                ", zoo=" + zoo +
                '}';
    }
}
