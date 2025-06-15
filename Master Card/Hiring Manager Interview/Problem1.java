import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Problem1
 *
 * <p>
 * Given an array of integers (int[]), find all unique elements from the array using Java Streams only.
 * The method should return a list of distinct integers present in the input array.
 * </p>
 *
 * <p>
 * This problem was asked in an interview and requires the use of Java Streams to process the array and extract unique elements.
 * </p>
 */
public class Problem1 {

    // 
    
    public static void main(String[] args) {
        
        int[] arr = {1,3,4,5,6,3,6,46,3,34,5,335,4,4,45,6,6,9,9,9};

        List<Integer> uniqueElements = findDistinct(arr);

        System.out.println("Unque elements are :: "+uniqueElements);
    }

    public static List<Integer> findDistinct(int[] arr){

        return Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                     .entrySet().stream().filter(entry -> entry.getValue() == 1)
                     .map(Map.Entry::getKey)
                     .collect(Collectors.toList());
    }
}
