import java.util.Scanner;

public class AssignmentP2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Input : ");
        String sentence = sc.nextLine();

        // 1. Split sentence into words
        String[] words = sentence.split(" ");
        int wordCount = words.length;

        // 2. Extract first and last word using substring()
        String firstWord = sentence.substring(0, sentence.indexOf(" "));
        String lastWord = sentence.substring(sentence.lastIndexOf(" ") + 1);

        // 3. First and last occurrence of character 'J'
        char ch = 'J';
        int firstIndex = sentence.indexOf(ch);
        int lastIndex = sentence.lastIndexOf(ch);

        // 4. Lexicographic comparison
        int comparison = firstWord.compareTo(lastWord);

        // 5. Convert sentence to character array
        char[] charArray = sentence.toCharArray();

        // First character and its ASCII value
        char firstChar = charArray[0];
        int asciiValue = firstChar;

        // String.valueOf() demonstration
        String asciiString = String.valueOf(asciiValue);

        // Output
        System.out.println("Output:");
        System.out.println("Word Count: " + wordCount);
        System.out.println("First Word: " + firstWord);
        System.out.println("Last Word: " + lastWord);
        System.out.println("First '" + ch + "' index: " + firstIndex);
        System.out.println("Last '" + ch + "' index: " + lastIndex);
        System.out.println("Comparison (first vs last word): " + comparison);
        System.out.println("First character: " + firstChar);
        System.out.println("ASCII value of first character: " + asciiString);

        sc.close();
    }
}