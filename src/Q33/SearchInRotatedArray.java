
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Binary Search Variant]
     There is an integer array nums sorted in ascending order (with distinct values).
     Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
     You must write an algorithm with O(log n) runtime complexity.

     Input: nums = [4,5,6,7,0,1,2], target = 0
     Output: 4

    link: https://leetcode.com/problems/search-in-rotated-sorted-array/description/


 **/

package Q33;


import java.util.ArrayList;
import java.util.List;

public class SearchInRotatedArray {

    public static  int SearchInRotatedArray(int[] nums, int target) {

        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        while(lo < hi){
            int mid = (lo + hi) / 2;

            if((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo == hi && nums[lo] == target ? lo : -1;

    }

    public static void main(String[] args){
        System.out.println("searching for array  [4,5,6,7,0,1,2] and target element 0 ");
        System.out.println("Index : " + SearchInRotatedArray(new int[]{4,5,6,7,0,1,2}, 0));
    }

}

//Complexity Analysis:
/**
 *
 *
 * TC : O(log n )  , just like binary search
 * SC : O(1)
 */
