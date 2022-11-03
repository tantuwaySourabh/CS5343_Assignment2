package Q4;

/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * 
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */


public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int [] right = new int[n];
        int[] ans = new int[n];

        left[0] = 1;
        right[n-1] = 1;

        // multiplication of all left side nums
        for(int i=1;i<n;i++) {
            left[i] = nums[i-1] * left[i-1];
        }
        // multiplication of all right side nums
        for(int i=n-2;i>=0;i--) {
            right[i] = nums[i+1] * right[i+1];
        }
        // multiplication of all nums except ith
        for(int i=0;i<n;i++) {
            ans[i] = left[i] * right[i];
        }

        // return answer array.
        return ans;
    }
    public static void main(String[] args) {
        
    }
}

/*
 * TC: O(n)
 * SC: O(n)
 */
