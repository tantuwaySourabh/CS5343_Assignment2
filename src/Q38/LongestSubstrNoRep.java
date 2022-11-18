
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Map, String]
         Given a string s, find the length of the longest
         substring without repeating characters.

         Input: s = "abcabcbb"
         Output: 3
         Explanation: The answer is "abc", with the length of 3.

    link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/


 **/

package Q38;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstrNoRep {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap();

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars.put(r, chars.getOrDefault(r,0) + 1);

            while (chars.get(r) > 1) {
                char l = s.charAt(left);
                chars.put(l, chars.get(l) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }


    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.println("for string s " + s);

        System.out.println("max length of substring without repeating characters will be : "  + lengthOfLongestSubstring(s) );

        s = "bbbbbb";
        System.out.println("for string s " + s);

        System.out.print("max length of substring without repeating characters will be : "  + lengthOfLongestSubstring(s) );

    }

}

//Complexity Analysis:
/**
 *
 * TC : O(n) , iterating over string of size n
 * SC : O(min(m,n)), size of sliding window,  m are alphabets
 */
