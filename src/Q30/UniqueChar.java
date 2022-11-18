
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Map, String]

     Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
     Input: s = "loveleetcode"
     Output: 2
    link:https: https://leetcode.com/problems/first-unique-character-in-a-string/

 **/

package Q30;

import java.util.HashMap;

public class UniqueChar {

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // finding the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args){
        //passing the string in function
        System.out.println("first unique character for the string, 'loveleetcode' : " + firstUniqChar("loveleetcode"));
        System.out.println("first unique character for the string, 'aabb' : " + firstUniqChar("aabb"));

    }

}

//Complexity Analysis:
/**
 * TC : O(n)  , iterating all characters of string
 * SC : O(1)  , 26 letters only, not changing as input changes
 */
