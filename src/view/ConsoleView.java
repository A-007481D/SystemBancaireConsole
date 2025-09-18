package view;

import java.util.Scanner;

public class ConsoleView {

    private Scanner sc = new Scanner(System.in);

    private int ShowMenu() {
        System.out.println("--- MENU PRINCIPAL ---");
        System.out.println("1. Creer un compte");
        System.out.println("2. Gere compte(entrer code)");
        System.out.println("3. lister toutes les comptes");
        System.out.println("4. exit");
        System.out.println("choix : ");
        return readInt();
    }

    public int showAccountMenu(String code) {
        System.out.println("--- MENU PERSONEL (" + code + ") ---");
        System.out.println("1. Versement");
        System.out.println("2. retraite");
        System.out.println("3. transfert");
        System.out.println("4. consulter solde");
        System.out.println("5. lister les operations");
        System.out.println("choix : ");
        return readInt();
    }

    public String readLIne(String prompt) {
        System.out.println(prompt);
        return sc.nextLine().trim();
    }

    public double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String s = sc.nextLine().trim();
                return Double.parseDouble(s);
            } catch (Exception e) {
                System.out.println("choix invalid.");
            }
        }
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String s = sc.nextLine().trim();
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("integer invalid");
            }
        }
    }
    public int readInt() {
        return readInt("");
    }

    public void showMessage(String s) {
        System.out.println(s);
    }

}