public class Notation {

    private double note;
    private int coef;

    public Notation(double note, int coef) {
        if (note < 0 || note > 20) {
            throw new IllegalArgumentException("La note doit être comprise entre 0 et 20.");
        }
        if (coef <= 0) {
            throw new IllegalArgumentException("Le coefficient doit être supérieur à 0.");
        }
        this.note = note;
        this.coef = coef;
    }

    public double getCoef() {
        return coef;
    }

    public double getNote() {
        return note;
    }

    public void afficher() {
        System.out.println("Note: " + note + " | Coef: " + coef);
    }
}
