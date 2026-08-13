import java.util.Scanner;

public class AssignmentP1 {

    public static String process(String input) {

        // 1. Remove leading and trailing spaces
        String str = input.trim();

        // 2. Check if empty
        if (str.isEmpty()) {
            return "EMPTY_STRING";
        }

        // 3. Check for reserved word "admin"
        if (str.equalsIgnoreCase("admin")) {
            return "RESERVED_WORD";
        }

        // 4. Replace '_' with space
        str = str.replace("_", " ");

        // 5. Check if starts with "temp" and ends with "user"
        String lower = str.toLowerCase();

        if (lower.startsWith("temp") && lower.endsWith("user")) {
            str = str.concat("_FLAGGED");
        }

        // 6. Return final string
        return str;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Input: ");
        String input = sc.nextLine();

        System.out.println("Output: " + process(input));

        sc.close();
    }
}