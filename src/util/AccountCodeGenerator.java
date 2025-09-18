package util;

public class AccountCodeGenerator {
    private static int counter = 1;

    public static synchronized String nextCode() {
        String digits = String.format("%05d", counter++);
        return "CPT" + digits;
    }
}