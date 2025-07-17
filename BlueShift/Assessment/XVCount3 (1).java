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
        int count = xvowels.contains(inputString.substring(0, 1)) ? 1 : 0;
        char lastChar = inputString.charAt(0);

        for (char ch : inputString.toCharArray()) {
            if (xvowels.indexOf(ch) >= 0 && ch == lastChar) {
                count++;
            } else {
                if (count >= 2) {
                    result.append(count);
                }
                result.append(lastChar);
                result.append(ch);
                count = xvowels.indexOf(lastChar) >= 0 ? 1 : 0;
            }
            lastChar = ch;
        }

        // Handle the last character
        if (count >= 2) {
            result.append(count);
        }
        result.append(lastChar);

        return result.toString();
    }
}
