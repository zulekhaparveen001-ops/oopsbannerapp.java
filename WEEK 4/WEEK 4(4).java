import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // Prefix sum + Hash Map approach - O(n) Time, O(n) Space
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        
        // Base case: prefix sum 0 occurs once
        prefixMap.put(0, 1);

        for (int num : nums) {
            currentSum += num;
            
            if (prefixMap.containsKey(currentSum - k)) {
                count += prefixMap.get(currentSum - k);
            }
            
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));  // Output: 2
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0)); // Output: 3
    }
}