// IBM Coding Assessment Problem 2
// A network security analyst needs to verify the integrity of data packets. Each character in a data packet has been assigned a numerical value. The integrity score is determined by the number of substrings where the sum of the numerical values is divisible by the substring's length.
//
// The character mapping is:
// • "a", "b": 1
// • "c", "d", "e": 2
// • "f", "g", "h": 3
// • "i", "j", "k": 4
// • "l", "m", "n": 5
// • "o", "p", "q": 6
// • "r", "s", "t": 7
// • "u", "v", "w": 8
// • "x", "y", "z": 9
//
// Example:
// dataPacket = "hey"
// Substrings:
// • "h": sum = 3, divisible by length 1
// • "e": sum = 2, divisible by length 1
// • "y": sum = 9, divisible by length 1
// • "he": sum = 3+2 = 5, not divisible by length 2
// • "ey": sum = 2+9 = 11, not divisible by length 2
// • "hey": sum = 3+2+9 = 14, not divisible by length 3
// There are 3 substrings where the sum is divisible by the length. Return 3.
//
// Function Description
// Complete the function integrityScore in the editor with the following parameters:
// string dataPacket: a string of length n
//
// Returns
// int: the number of non-empty substrings of dataPacket that meet the given criterion
//
// Constraints
// • 1 ≤ n ≤ 2000
// • All characters of dataPacket are lowercase English letters.
//
// Sample Input For Custom Testing
// dataPacket = "cat"
// Sample Output
// 4

import java.util.HashMap;

public class Problem2 {

    public static void main(String[] args) {
        
        System.out.println("Integrity Score :: "+ getIntegrityScore("hey"));
    }

    public static int getIntegrityScore(String s) {

        int integrityScore = s.length();
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(char c : new char[]{'a','b'}) charMap.put(c, 1);
        for(char c : new char[]{'c','d','e'}) charMap.put(c, 2);
        for(char c : new char[]{'f','g','h'}) charMap.put(c, 3);
        for(char c : new char[]{'i','j','k'}) charMap.put(c, 4);
        for(char c : new char[]{'l','m','n'}) charMap.put(c, 5);
        for(char c : new char[]{'o','p','q'}) charMap.put(c, 6);
        for(char c : new char[]{'r','s','t'}) charMap.put(c, 7);
        for(char c : new char[]{'u','v','w'}) charMap.put(c, 8);
        for(char c : new char[]{'x','y','z'}) charMap.put(c, 9);

        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            int sum = 0;
            for(int j = i; j < s.length(); j++) {
                sum += charMap.get(s.charAt(j));
                int len = j - i + 1;
                if(len > 1){
                    if(sum % len == 0) {
                        count++;
                    }
                }
                
            }
        }
        return integrityScore+count;
    }    
}
