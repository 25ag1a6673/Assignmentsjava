import java.util.Arrays;
import java.util.Scanner;

public class AssignmentP3 {

    // Method to clean the string
    static String cleanString(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Check palindrome
    static boolean isPalindrome(String str) {
        String cleaned = cleanString(str);
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    // Check anagram
    static boolean isAnagram(String str1, String str2) {
        String s1 = cleanString(str1);
        String s2 = cleanString(str2);

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter string 1: ");
        String str1 = sc.nextLine();

        System.out.print("Enter string 2: ");
        String str2 = sc.nextLine();

        System.out.print("Enter substring to search: ");
        String sub = sc.nextLine();

        // Clean string
        String cleaned = cleanString(str1);

        // Regex validation using matches()
        boolean valid = cleaned.matches("[a-zA-Z0-9]+");

        // Palindrome check
        boolean palindrome = isPalindrome(str1);

        // Anagram check
        boolean anagram = isAnagram(str1, str2);

        // Substring check
        boolean contains = str1.toLowerCase().contains(sub.toLowerCase());

        // String pool demonstration
        String s1 = "listen";
        String s2 = new String("listen");

        String interned1 = s1.intern();
        String interned2 = s2.intern();

        boolean sameHashCode = interned1.hashCode() == interned2.hashCode();

        // Formatting using String.format()
        String line1 = String.format("Palindrome: %b", palindrome);
        String line2 = String.format("Anagram: %b", anagram);

        // Combining lines using String.join()
        String report = String.join(" | ", line1, line2);

        // Output
        System.out.println("\nOutput:");
        System.out.println("Palindrome Check: \"" + str1 + "\" -> " + palindrome);
        System.out.println("Anagram Check: \"" + str1 + "\" & \"" + str2 + "\" -> " + anagram);
        System.out.println("Cleaned String: " + cleaned);
        System.out.println("Regex Validation (Alphanumeric): " + valid);
        System.out.println("Formatted Report: [" + report + "]");
        System.out.println("Contains '" + sub + "': " + contains);
        System.out.println("HashCodes equal for interned strings: " + sameHashCode);

        sc.close();
    }
}