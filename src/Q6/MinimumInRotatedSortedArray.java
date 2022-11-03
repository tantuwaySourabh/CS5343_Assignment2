package Q6;
/*
 * Given the sorted rotated array nums of unique elements, 
 * return the minimum element of this array.
 * 
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * 
 */

public class MinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];

        int start = 0;
        int end = nums.length -1;

        // no rotation
        if(nums[0] < nums[end]) return nums[0];

        while(start <= end) {
            int mid = (start+end) / 2;

            if(nums[mid] > nums[mid+1]) return nums[mid+1];

            if(nums[mid] < nums[mid-1]) return nums[mid];

            if(nums[mid] >= nums[0]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {3,4,5,1,2};
        System.out.println(findMin(nums));
    }
}

/*
 * TC: O(log(N))
 * SC: O(1)
 */
