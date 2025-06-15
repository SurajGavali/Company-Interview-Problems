public class Problem1 {
    // IBM Coding Assessment Problem 1
    // In a distributed API system, n endpoints manage incoming traffic with capacities represented by the array endpointCapacity. Each endpoint receives a specific number of requests given by incomingTraffic, which may exceed its capacity, leading to performance issues.
    // To address this, the development team can optimize the system by doubling the capacities of up to k endpoints. Any one endpoint can only be doubled once.
    //
    // Implement a function to determine the maximum total requests that can be processed by all endpoints after optimizing the system.
    //
    // The function getMaxRequests takes the following inputs:
    // int endpointCapacity[n]: the capacity of each API endpoint
    // int incomingTraffic[n]: the incoming requests for each endpoint
    // int k: the number of endpoints whose capacities can be doubled
    //
    // The function should return the maximum total requests that can be handled after doubling the capacities of up to k endpoints.
    //
    // Example:
    // n = 4
    // endpointCapacity = [10, 4, 3, 7]
    // incomingTraffic = [3, 10, 4, 5]
    // k = 2
    // In an optimal scenario, the team can double the capacities of the second and third endpoints. Thus, the endpointCapacity will become: [10, 8, 6, 7]. The total number of requests handled is 3 + 8 + 4 + 5 = 20. It is not possible to handle all 10 requests for the second endpoint. Hence, the answer is 20.
    //
    // Constraints:
    // • 1 ≤ k ≤ n ≤ 2 * 10^5
    // • 1 ≤ endpointCapacity[i], incomingTraffic[i] ≤ 10^9

    // Optimal solution with explanation
    public static long getMaxRequests(int[] endpointCapacity, int[] incomingTraffic, int k) {
        int n = endpointCapacity.length;
        // long[] gain = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            long handled = Math.min(endpointCapacity[i], incomingTraffic[i]);
            System.out.println("Endpoint " + i + ": capacity=" + endpointCapacity[i] + ", incoming=" + incomingTraffic[i] + ", handled before doubling=" + handled);
            
            long doubledHandled = Math.min(endpointCapacity[i] * 2L, incomingTraffic[i]);

            System.out.println("Endpoint " + i + ": capacity=" + endpointCapacity[i]*2L + ", incoming=" + incomingTraffic[i] + ", handled After doubling=" + doubledHandled);

            total += doubledHandled;
        }
        System.out.println("Final total requests handled: " + total);
        return total;
    }

    // Example usage
    public static void main(String[] args) {
        int[] endpointCapacity = {10, 4, 3, 7};
        int[] incomingTraffic = {3, 10, 4, 5};
        int k = 2;
        getMaxRequests(endpointCapacity, incomingTraffic, k);
    }
}
