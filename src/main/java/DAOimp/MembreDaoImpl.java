package DAOimp;

import DAO.MembreDao;
import Model.Membre;
import java.util.HashSet;
import java.util.Set;

public class MembreDaoImpl implements MembreDao {
    private Set<Membre> membres;

    // Constructeur
    public MembreDaoImpl() {
        this.membres = new HashSet<>();
    }

    @Override
    public void ajouterMembre(Membre membre) {
        membres.add(membre);
    }

    @Override
    public void supprimerMembre(String identifiant) {
        membres.removeIf(membre -> membre.getIdentifiant().equals(identifiant));
    }

    @Override
    public Membre getMembre(String identifiant) {
        return membres.stream()
                .filter(membre -> membre.getIdentifiant().equals(identifiant))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Membre> getTousLesMembres() {
        return new HashSet<>(membres);
    }
}

