
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Recursion]

    Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
    Example:
     Input: x = 2.10000, n = 3
     Output: 9.26100

 link:https: https://leetcode.com/problems/powx-n/description/

 **/

package Q26;

import java.util.Stack;

public class FunctionPOW {


    public static void main(String[] args){

        System.out.println("value for pow(2.0, 10) : " +  myPow(2.0, 10 ));
        System.out.println("value for pow(2.1, 3) : " +  myPow(2.1, 3 ));
        System.out.println("value for pow(2.0, -2) :  : " +  myPow(2.0, -2 ));
    }

    public static double myPow(double x, int n) {
        //if(x == 0) return 0;
        if(n == 0) return 1;

        if( n < 0){
            if( n == Integer.MIN_VALUE){
                n /= 2;
                n = -n;
                x = (1/x)*(1/x);
            }else{
                n = Math.abs(n);
                x = 1 / x;
            }
        }

        return (n % 2 == 0) ? myPow(x * x, n/2) : x * myPow(x * x, n/2);
    }
}

/**
 * TC : O(log n)  , every time n is becoming half
 * SC : O(log n)  , max call stack.
 */
