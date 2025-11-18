public class Etudiant {
    private String nom;
    private double moyenne;
    private String avis;
    private Notation[] notes;

    public Etudiant(String nom, Notation[] notes) {
        this.nom = nom;
        this.notes = notes;
        this.calculerMoyenne();
        this.calculerAvis();
    }

    private void calculerMoyenne() {
        double sum = 0;
        double coefSum = 0;

        for (Notation n : notes) {
            sum += n.getNote() * n.getCoef();
            coefSum += n.getCoef();
        }

        if (coefSum == 0) moyenne = 0;
        else moyenne = sum / coefSum;
    }

    private void calculerAvis() {
        if (moyenne >= 10) avis = "Admis";
        else avis = "Refusé";
    }

    public String getNom() {
        return nom;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public String getAvis() {
        return avis;
    }

    public void afficher() {
        System.out.println("Nom : " + nom);
        System.out.println("Notes :");
        for (Notation n : notes) n.afficher();
        System.out.println("Moyenne : " + moyenne);
        System.out.println("Avis : " + avis);
    }
}
