
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Recursion]

     Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     Input: n = 3
     Output: ["((()))","(()())","(())()","()(())","()()()"]

    link:   https://leetcode.com/problems/generate-parentheses/description/

 **/

package Q32;


import java.util.ArrayList;
import java.util.List;

public class GenrateParanthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        allCombination(ans, new StringBuilder(), 0, 0, n);
        return ans;

    }

    public static void allCombination(List<String> ans, StringBuilder cur, int open, int close, int max){
        if(cur.length() == max * 2){
            ans.add(cur.toString());
            return;
        }

        if(open < max){
            cur.append("(");
            allCombination(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if(close < open){
            cur.append(")");
            allCombination(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    public static void print(List<String> l){
        for(String s : l){
            System.out.print(s + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args){
        System.out.println("Generating for n = 3 ");
        print(generateParenthesis(3));
    }

}

//Complexity Analysis:
/**
 *
 *
 * TC : O(4^n / sqrt(n))  , Each valid sequence has at most n steps during the backtracking procedure.
 * SC : O(4^n / sqrt(n))
 */
