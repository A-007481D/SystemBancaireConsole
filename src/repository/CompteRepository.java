package repository;

public interface CompteRepository {
    private Map<String, Compte> comptes = new Hashmap<>();

    public void save(compte c) {comptes.put(getCode(), c)};

    public Optional<Compte> findByCode(String code) {
        return Optional.ofNullable(comptes.get(code));
    }

    public Collection<Compte> findAll() {
        return comptes.values();
    }



}