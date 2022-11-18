
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Binary Search Variant]
     Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

     If target is not found in the array, return [-1, -1].

     You must write an algorithm with O(log n) runtime complexity.

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]


    link:  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/


 **/

package Q34;


public class FirstLastPos {

    public static int[] searchRange(int[] nums, int target) {

        if(nums.length == 0)
            return new int[] {-1, -1};
        //System.out.println("before calculating start");
        int start = find(nums, target);
        //System.out.println("start " + start);

        if(start == nums.length || nums[start] != target)
            return new int[]{-1, -1};
        if(nums[start] == target){

            //System.out.println("before calculating end");
            int end = find(nums, target + 1);
            //System.out.println("end " + end);
            return new int[]{start, end != 0 && nums[end] != target ? end - 1 : end};
//return new int[]{start, end != 0 && end != nums.length-1 ? end - 1 : end};
        }

        return new int[] {-1, -1};
    }
    public  static int find(int[] nums, int target){
        int hi = nums.length - 1;
        int lo = 0;
        //System.out.println("target " + target);

        while(lo < hi){
            int mid = (lo + hi) / 2;
            // System.out.println("lo " + lo);
            // System.out.println("hi " + hi);
            //System.out.println("mid " + mid);

            if(target <= nums[mid]){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        // System.out.println("lo out" + lo);
        // System.out.println("hi out" + hi);

        return lo;
    }
    public static void print(int[] arr){
        System.out.print("[");
        for(int a : arr){
            System.out.print(a + " ");
        }
        System.out.print("]");
    }
    public static void main(String[] args){
        System.out.println("searching for array  [5,7,7,8,8,10] and target element 8 ");
        System.out.print("range is : ");
        print(searchRange(new int[]{5,7,7,8,8,10}, 8));
    }

}

//Complexity Analysis:
/**
 *
 *
 * TC : O(log n ) , just like binary search
 * SC : O(1)
 */
