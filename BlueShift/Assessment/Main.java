/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */

public class Main {
    public static List<String> processData(ArrayList<String> lines) {
        /* 
         * Modify this method to process `lines` as indicated
         * in the question. At the end, return a List containing the
         * appropriate values
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
        List<String> retVal = new ArrayList<String>();
        Map<String, Integer> minPrice = new HashMap<>(); // CHANGED: for min price per room type
        Map<String, Integer> maxPrice = new HashMap<>(); // CHANGED: for max price per room type
        class Booking { // CHANGED: Booking class to store booking info
            String customer;
            String roomType;
            int price;
            Booking(String c, String r, int p) {
                customer = c;
                roomType = r;
                price = p;
            }
        }
        List<Booking> bookings = new ArrayList<>(); // CHANGED: list to store all bookings
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;
            // Each line may have multiple bookings separated by '  ' (double space) or just space
            // But in the sample, each booking is separated by a single space, but fields by comma
            // So, split by ", "
            // But some lines may have multiple bookings separated by ' ' (space) and not by newlines
            // So, split by ", " and process every 6 fields
            String[] tokens = line.split(", ");
            for (int i = 0; i + 5 < tokens.length; i += 6) {
                String customer = tokens[i].trim();
                String bookedVia = tokens[i+1].trim(); // unused
                String date = tokens[i+2].trim(); // unused
                String roomType = tokens[i+3].trim();
                String priceStr = tokens[i+4].trim();
                String paymentType = tokens[i+5].trim(); // unused
                priceStr = priceStr.replaceAll("[^0-9]", ""); // CHANGED: clean price string
                int price = 0;
                try {
                    price = Integer.parseInt(priceStr);
                } catch (Exception e) {
                    continue;
                }
                bookings.add(new Booking(customer, roomType, price)); // CHANGED: add booking
                if (!minPrice.containsKey(roomType) || price < minPrice.get(roomType)) {
                    minPrice.put(roomType, price); // CHANGED: update min price
                }
                if (!maxPrice.containsKey(roomType) || price > maxPrice.get(roomType)) {
                    maxPrice.put(roomType, price); // CHANGED: update max price
                }
            }
        }
        Set<String> discountedRoomTypes = new HashSet<>(); // CHANGED: store discounted room types
        for (String roomType : minPrice.keySet()) {
            if (minPrice.get(roomType) < maxPrice.get(roomType)) {
                discountedRoomTypes.add(roomType); // CHANGED: add discounted room type
            }
        }
        Set<String> result = new LinkedHashSet<>(); // CHANGED: store result customers
        for (Booking b : bookings) {
            if (discountedRoomTypes.contains(b.roomType) && b.price == minPrice.get(b.roomType)) {
                result.add(b.customer); // CHANGED: add customer who booked at min price
            }
        }
        retVal.addAll(result); // CHANGED: add all result customers to return value
        return retVal;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine())
            inputData.add(in.nextLine());
        List<String> retVal = processData(inputData);
        PrintWriter output = new PrintWriter(System.out);
        for(String str: retVal)
            output.println(str);
        output.close();
    }
}
