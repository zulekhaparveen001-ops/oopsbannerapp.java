public class FindMinInRotatedSortedArray {

    // Modified Binary Search - O(log n) Time
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1; // Minimum must be in right half
            } else {
                right = mid;    // Minimum is mid or in left half
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));       // Output: 1
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // Output: 0
        System.out.println(findMin(new int[]{11, 13, 15, 17}));     // Output: 11
    }
}