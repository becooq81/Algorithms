package concepts.completesearch;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the largest index i such that nums[i] < nums[i + 1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If no such index exists, the array is sorted in descending order
        if (i >= 0) {
            int j = n - 1;
            
            // Step 2: Find the largest index j such that nums[i] < nums[j]
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Step 3: Swap nums[i] with nums[j]
            swap(nums, i, j);
        }

        // Step 4: Reverse the sequence from i + 1 to end
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // Output should be [1, 3, 2]

        nums = new int[]{3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // Output should be [1, 2, 3]

        nums = new int[]{1, 1, 5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // Output should be [1, 5, 1]
    }
}
