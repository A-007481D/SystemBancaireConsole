package view;

import java.util.Scanner;

public class ConsoleView {

    Scanner sc = new Scanner(System.in);

    private int ShowMenu() {
        System.out.println("--- MENU PRINCIPAL ---");
        System.out.println("1. Creer un compte");
        System.out.println("2. Gere compte(entrer code)");
        System.out.println("3. lister toutes les comptes");
        System.out.println("4. exit");
        System.out.println("choix : ");
        return readInt();
    }

    public int showAccountMenu() {
        System.out.println("--- MENU PERSONEL ---");
        System.out.println("1. Versement");
        System.out.println("2. retraite");
        System.out.println("3. transfert");
        System.out.println("4. consulter solde");
        System.out.println("5. lister les operations");
        return readInt();
    }


    public int readInt() {
        return readInt("");
    }

    public void showMessage(String s) {
        System.out.println(s);
    }

}