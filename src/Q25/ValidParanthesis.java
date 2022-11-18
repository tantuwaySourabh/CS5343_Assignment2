
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Stack]

     Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     An input string is valid if:
     Open brackets must be closed by the same type of brackets.
     Open brackets must be closed in the correct order.
     Every close bracket has a corresponding open bracket of the same type

        example: Input: s = "()[]{}"
                  Output: true

 link:https: https://leetcode.com/problems/valid-parentheses/description/

 **/

package Q25;

import java.util.Stack;

public class ValidParanthesis {


    public static void main(String[] args){

        System.out.println("is valid parenthesis for () : " +  isValid("()") );
        System.out.println("is valid parenthesis for ()[]{} : " +  isValid("()[]{}") );
        System.out.println("is valid parenthesis for (] : " +  isValid("(]") );
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}

/**
 * TC : O(n)  , for string of size n
 * SC : O(n)  , max insert in stack.
 */
