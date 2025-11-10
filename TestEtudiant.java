public class TestEtudiant {
    public static void main(String[] args) {

        Etudiant alice = new Etudiant("Alice Dupont");
        alice.ajouterNote(new Notation(15.0, 3));
        alice.ajouterNote(new Notation(8.0, 2));
        alice.ajouterNote(new Notation(12.5, 4));
        alice.afficher();


        Etudiant bob = new Etudiant("Bob Martin");
        bob.ajouterNote(new Notation(7.0, 5));
        bob.ajouterNote(new Notation(11.0, 1));
        bob.afficher();
    }
}
