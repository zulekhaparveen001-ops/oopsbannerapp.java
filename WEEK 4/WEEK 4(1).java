import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: calculate prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: multiply suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] res1 = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(res1)); // Output: [24, 12, 8, 6]

        int[] res2 = productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        System.out.println(Arrays.toString(res2)); // Output: [0, 0, 9, 0, 0]
    }
}