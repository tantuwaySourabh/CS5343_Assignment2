
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Array]
     Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
     The relative order of the elements should be kept the same.
     Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
     More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
     It does not matter what you leave beyond the first k elements.

     Input: nums = [0,0,1,1,1,2,2,3,3,4]
     Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     It does not matter what you leave beyond the returned k (hence they are underscores).

     link:  https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/


 **/

package Q36;


public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        int n = nums.length;
        int prev = -200;
        int curr = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] != prev){
                nums[curr] = nums[i];
                curr++;
                prev = nums[i];
            }
        }
        return curr;
    }


    public static void main(String[] args){
        int[] num = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("removing duplicates for [0,0,1,1,1,2,2,3,3,4] ");
        int finalSize = removeDuplicates(num);
        System.out.print("final array will be :  " );
        for(int i= 0; i < finalSize; i++){
            System.out.print(num[i] + " ");
        }
        System.out.println("");

    }

}

//Complexity Analysis:
/**
 *
 *
 * TC : O(n) , iterating over the array
 * SC : O(1), in-place removal
 */
