package Q5;

/*
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * 
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 */

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for(int i=1;i<nums.length;i++) {
            int curr = nums[i];

            int temp_max = Math.max(curr, Math.max(max_so_far*curr, min_so_far*curr));
            min_so_far = Math.min(curr, Math.min(max_so_far*curr, min_so_far*curr));

            max_so_far = temp_max;
            result = Math.max(max_so_far, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}

/*
 * TC: O(n)
 * SC: O(1)
 */