package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import DAO.MembreDao;
import DAOimp.MembreDaoImpl;
import Model.Membre;

public class MembreImporter {



    public Set<Membre> chargerListeMembre(String nomFichier) {
        Set<Membre> membres = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] details = ligne.split(","); // Séparer les colonnes par la virgule
                if (details.length == 4) {
                    String nom = details[0].trim();
                    String prenom = details[1].trim();
                    String email = details[2].trim();
                    String phone = details[3].trim();

                    // Générer un identifiant aléatoire pour chaque membre
                    String identifiant = "ID-" + (int) (Math.random() * 10000);

                    // Créer un nouveau membre
                    Membre membre = new Membre(identifiant, nom, prenom, email, phone);
                    System.out.println(membre);
                    // Ajouter au Set (HashSet filtre automatiquement les doublons grâce à equals et hashCode)
                    membres.add(membre);
                    
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }

        return membres;
    }
    
   
    


}
