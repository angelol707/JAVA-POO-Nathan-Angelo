import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestEtudiant {
    public static void main (String[] args) {

        // 1) Créer l'étudiant à partir des notes
        Notation[] tab = {
                new Notation(2, 19),
                new Notation(1, 18),
                new Notation(3, 2)
        };

        Etudiant e = new Etudiant("Angelo", tab);
        e.afficher();

        Notation[] tabb = {
                new Notation(2, 20),
                new Notation(1, 8),
                new Notation(3, 10)
        };

        Etudiant b = new Etudiant("Nathan", tabb);
        e.afficher();

        String url = "jdbc:mysql://localhost:3306/test-jdbc?createDatabaseIfNotExist=true";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database successfully");

            // 3) INSERT de l'étudiant
            String insertSql = "INSERT INTO etudiants (name, moyenne, avis) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
                stmt.setString(1, e.getNom());
                stmt.setDouble(2, e.getMoyenne());
                stmt.setString(3, e.getAvis());
                stmt.executeUpdate();

                stmt.setString(1, b.getNom());
                stmt.setDouble(2, b.getMoyenne());
                stmt.setString(3, b.getAvis());
                stmt.executeUpdate();

            }

            // 4) SELECT et affichage de tous les étudiants
            ResultSet data = conn
                    .prepareStatement("SELECT * FROM etudiants")
                    .executeQuery();

            while (data.next()) {
                String name = data.getString("name");
                double moyenne = data.getDouble("moyenne");
                String avis = data.getString("avis");

                System.out.printf("Name: %s, Moyenne: %.2f, Avis: %s%n",
                        name, moyenne, avis);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
