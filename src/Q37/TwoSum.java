
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Map, Array]
     Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Input: nums = [2,7,11,15], target = 9
     Output: [0,1]
     Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    link: https://leetcode.com/problems/two-sum/description/



 **/

package Q37;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i < nums.length ; i++){

            if(!mp.containsKey(target-nums[i])){
                mp.put(nums[i],i);
            }else{
                return new int[]{mp.get(target-nums[i]),i};
            }

        }

        return new int[]{0,0};
    }


    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        System.out.println("for array [2,7,11,15] and target 9 ");
        int[] result = twoSum(nums, 9);
        System.out.print("indexes of elements which sums to target will be:  " );
        for(int i= 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println("");

    }

}

//Complexity Analysis:
/**
 *
 *
 * TC : O(n) , iterating over the array
 * SC : O(n), size of map
 */
