package view;

import java.util.Scanner;

public class ConsoleView {
    private Scanner sc = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Create account");
        System.out.println("2. Select account (enter code to manage)");
        System.out.println("3. List all accounts");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
        return readInt();
    }

    public int showAccountMenu(String code) {
        System.out.println("\n--- Account Menu (" + code + ") ---");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. List history");
        System.out.println("0. Back to main");
        System.out.print("Choice: ");
        return readInt();
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
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
                System.out.print(prompt);
                String s = sc.nextLine().trim();
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("Invalid integer, try again.");
            }
        }
    }

    private int readInt() { return readInt(""); }

    public void showMessage(String s) { System.out.println(s); }
}
