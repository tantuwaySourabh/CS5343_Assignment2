package Q45;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/third-maximum-number/
 * 
 * Given an integer array nums, return the third distinct maximum number in this array. If the
 * third maximum does not exist, return the maximum number.
 * 
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * 
 */
public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        
        int max = Collections.max(set);
        if(set.size() < 3) return max;
        
        set.remove(max);
        int max2 = Collections.max(set);
        set.remove(max2);
        return Collections.max(set);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(thirdMax(nums));
    }
}

/*
 * Time Complexity: O(N)
 */
