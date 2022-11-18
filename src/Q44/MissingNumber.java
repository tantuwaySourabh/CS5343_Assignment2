package Q44;

/*
 * https://leetcode.com/problems/missing-number/
 * 
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number
 * in the range that is missing from the array.
 * 
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the
 * missing number in the range since it does not appear in nums.
 * 
 * 
 * 
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
     }
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }
}

/*
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * 
 */
