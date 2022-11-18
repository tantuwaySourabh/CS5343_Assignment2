
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT:


 A peak element is an element that is strictly greater than its neighbors.
 Given a 0-indexed integer array nums, find a peak element, and return its index.
 If the array contains multiple peaks, return the index to any of the peaks.
 You may imagine that nums[-1] = nums[n] = -∞.
 In other words, an element is always considered to be strictly greater than
 a neighbor that is outside the array.
 You must write an algorithm that runs in O(log n) time.

 link:  https://leetcode.com/problems/find-peak-element/

 **/

package Q2;
public class FindPeak {
    public static void main(String[] args){

        //driver code for passing input array
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println("Peak element index is : " + findPeakElement(arr));

    }
    public static int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public static int search(int[] nums, int l, int r){

        if(l == r) return l;
        int mid = (l + r) / 2;

        if(nums[mid] > nums[mid + 1])
            return search(nums, l, mid);

        return search(nums, mid + 1, r);
    }
}

//Complexity Analysis:
/**
 * TC : O(log n),  n size array
 * SC : O(1)  , No additional space required
 */