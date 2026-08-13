import java.util.Scanner;

public class AssignmentP4 {

    // Convert full name to Title Case
    static String titleCase(String name) {
        String[] words = name.toLowerCase().split("\\s+");
        String result = "";

        for (String word : words) {
            result += word.substring(0, 1).toUpperCase()
                    + word.substring(1) + " ";
        }

        return result.trim();
    }

    // Mask email
    static String maskEmail(String email) {
        int atIndex = email.indexOf('@');

        String firstThree = email.substring(0, 3);
        String remaining = email.substring(3, atIndex);

        return firstThree + "*".repeat(remaining.length())
                + email.substring(atIndex);
    }

    // Validate email using regex
    static boolean validateEmail(String email) {
        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    // Reverse every word individually
    static String reverseWords(String sentence) {
        String[] words = sentence.split("\\s+");
        String result = "";

        for (String word : words) {
            String reversed = "";

            for (char ch : word.toCharArray()) {
                reversed = ch + reversed;
            }

            result += reversed + " ";
        }

        return result.trim();
    }

    // Count vowels
    static int countVowels(String sentence) {
        int count = 0;

        for (char ch : sentence.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();

        // 1. Title Case
        String formattedName = titleCase(fullName);

        // 2. Mask Email
        String maskedEmail = maskEmail(email);

        // 3. Validate Email
        boolean validEmail = validateEmail(email);

        // 4. Reverse Words
        String reversedWords = reverseWords(sentence);

        // 5. Count Vowels
        int vowelCount = countVowels(sentence);

        // 6. == vs equals()
        String str1 = new String("Java");
        String str2 = new String("Java");

        System.out.println("\nOutput:");
        System.out.println("Formatted Name: " + formattedName);
        System.out.println("Masked Email: " + maskedEmail);
        System.out.println("Valid Email: " + validEmail);
        System.out.println("Reversed Words: " + reversedWords);
        System.out.println("Vowel Count: " + vowelCount);

        System.out.println("\nString Comparison:");
        System.out.println("Using ==      : " + (str1 == str2));
        System.out.println("Using equals(): " + str1.equals(str2));

        sc.close();
    }
}