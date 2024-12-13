package DAO;
import Model.Membre;
import java.util.Set;

public interface MembreDao {
    // Ajouter un membre
    void ajouterMembre(Membre membre);

    // Supprimer un membre par identifiant
    void supprimerMembre(String identifiant);

    // Obtenir un membre par identifiant
    Membre getMembre(String identifiant);

    // Obtenir tous les membres
    Set<Membre> getTousLesMembres();
}
