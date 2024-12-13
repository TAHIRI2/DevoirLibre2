package DAO;
import Model.Incident;
import java.util.List;

public interface IncidentDao {
    // Ajouter un incident
    void ajouterIncident(Incident incident);

    // Supprimer un incident par identifiant
    void supprimerIncident(String id);

    // Obtenir un incident par identifiant
    Incident getIncident(String id);

    // Obtenir tous les incidents
    List<Incident> getTousLesIncidents();
}
