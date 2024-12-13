package DAOimp;
import DAO.IncidentDao;
import Model.Incident;
import java.util.ArrayList;
import java.util.List;

public class IncidentDaoImpl implements IncidentDao {
    private List<Incident> incidents;

    // Constructeur
    public IncidentDaoImpl() {
        this.incidents = new ArrayList<>();
    }

    @Override
    public void ajouterIncident(Incident incident) {
        incidents.add(incident);
    }

    @Override
    public void supprimerIncident(String id) {
        incidents.removeIf(incident -> incident.getId().equals(id));
    }

    @Override
    public Incident getIncident(String id) {
        return incidents.stream()
                .filter(incident -> incident.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Incident> getTousLesIncidents() {
        return new ArrayList<>(incidents);
    }
}
