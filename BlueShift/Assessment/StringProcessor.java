// Bug: The original code incorrectly handled the counting and placement of vowels and non-vowels, leading to duplicated characters and wrong counts. The count logic and sequence handling were incorrect.
// Fix: Properly track sequences of consecutive vowels, append the count only when 2 or more vowels are found, and avoid duplicating characters. Handle the last sequence after the loop.

import java.util.Scanner;

public class StringProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String outputLine = processString(inputLine);
        System.out.println(outputLine);
    }

    private static String processString(String inputString) {
        String xvowels = "aeinou";
        StringBuilder result = new StringBuilder();
        int count = 0;
        int lastVowelPos = -1;

        // CHANGED: Now count any sequence of consecutive vowels, not just repeated vowels
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if (xvowels.indexOf(ch) >= 0) {
                if (count == 0) {
                    lastVowelPos = i;
                }
                count++;
            } else {
                // CHANGED: If a sequence of 2+ vowels ended, append the count; else append the vowel
                if (count >= 2) {
                    result.append(count);
                } else if (count == 1) {
                    result.append(inputString.charAt(lastVowelPos));
                }
                count = 0;
                result.append(ch);
            }
        }
        // CHANGED: Handle any trailing vowels at the end of the string
        if (count >= 2) {
            result.append(count);
        } else if (count == 1) {
            result.append(inputString.charAt(lastVowelPos));
        }
        return result.toString();
    }
}
