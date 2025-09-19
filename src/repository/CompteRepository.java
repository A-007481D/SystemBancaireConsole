package repository;

import model.Compte;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Collection;

public class CompteRepository {
    private Map<String, Compte> comptes = new HashMap<>();

    public void save(Compte c) {
        comptes.put(c.getCode(), c);
    }

    public Optional<Compte> findByCode(String code) {
        return Optional.ofNullable(comptes.get(code));
    }

    public Collection<Compte> findAll() {
        return comptes.values();
    }
}