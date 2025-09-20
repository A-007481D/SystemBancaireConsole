# Banque Console App

## Description du projet

Ce projet est une application console Java qui simule la gestion d’un système bancaire simple.
Elle permet de :

* Créer des comptes courants et épargne
* Effectuer des dépôts et retraits
* Calculer les intérêts des comptes épargne (avec un taux défini et appliqué sur une durée)
* Consulter les soldes
* Gérer un découvert autorisé pour les comptes courants

Le but est de mettre en pratique l’architecture en couches (MVC simplifié) et l’utilisation de Java orienté objet.

---

## Technologies utilisées

* **Java SE 8+**
* **IntelliJ IDEA**
* **UML Visual Paradigm Online**

---

## Structure du projet

```
src/
 ├── controller/
 │   └── BanqueController.java
 ├── model/
 │   ├── Compte.java
 │   ├── CompteCourant.java
 │   ├── CompteEpargne.java
 │   ├── Operation.java
 │   ├── Retrait.java
 │   └── Versement.java
 ├── repository/
 │   ├── OperationRepository.java
 │   └── CompteRepository.java
 ├── service/
 │   └── BanqueService.java
 ├── util/
 │   └── AccountCodeGenerator.java
 ├── view/
 │   └── ConsoleView.java
 └── Main.java
```

* **model/** → contient les entités (Compte, CompteCourant, CompteEpargne...)
* **controller/** → gère la logique entre la vue et le service
* **service/** → logique métier (dépôt, retrait, calcul d’intérêt...)
* **repository/** → gestion des données
* **view/** → interface console (affichage)
* **util/** → class utilitaire
* **Main.java** → point d’entrée du programme

---

##  Prérequis

* Installer **Java JDK 8**
* Configurer les variables d’environnement `JAVA_HOME`
* Un IDE comme IntelliJ IDEA

---

## Exécution

1. Compiler le projet :

   ```bash
   javac -d out $(find src -name "*.java")
   ```
2. Lancer l’application :

   ```bash
   java -cp out Main
   ```

---

## Génération du JAR exécutable

### Avec IntelliJ IDEA :

1. **File > Project Structure > Artifacts**
2. Cliquer sur **+** → *JAR > From modules with dependencies*
3. Sélectionner la classe **Main**
4. Appliquer et **Build > Build Artifacts > Build**
5. Le JAR sera généré dans `out/artifacts/...`

### Exécution du JAR :

```bash
java -jar BanqueApp.jar
```

