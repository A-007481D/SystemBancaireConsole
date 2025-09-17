package model;

public abstract class Operation {
    private String numero;
    private LocalDateTime date;
    private double montant;


    public Operation(double montant) {
        this.montant = montant;
        this.numero = UUID.randomUUID().toString();
        this.date = LocalDateTime().now();
    }

    public String getNumer() {
        return numero;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }


    public abstract void afficherDetails();
    }

}