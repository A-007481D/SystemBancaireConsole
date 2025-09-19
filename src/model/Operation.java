package model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {
    protected String numero;
    protected LocalDateTime date;
    protected double montant;

    public Operation(double montant) {
        if (montant <= 0) throw new IllegalArgumentException("Amount must be positive");
        this.numero = UUID.randomUUID().toString();
        this.date = LocalDateTime.now();
        this.montant = montant;
    }

    public String getNumero() { return numero; }
    public LocalDateTime getDate() { return date; }
    public double getMontant() { return montant; }
    public abstract void afficherDetails();
}
