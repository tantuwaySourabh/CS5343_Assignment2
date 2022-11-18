
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Dynamic Programming]
     You are climbing a staircase. It takes n steps to reach the top.
     Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

     Input: n = 3
     Output: 3
     Explanation: There are three ways to climb to the top.
     1. 1 step + 1 step + 1 step
     2. 1 step + 2 steps
     3. 2 steps + 1 step


 link:https://leetcode.com/problems/climbing-stairs/description/

 **/

package Q24;
public class ClimbingStairs {


    public static void main(String[] args){

        System.out.println("Number of ways, stair of size 5 will be climbed is : " + climbStairs(5));

    }

    public static int climbStairs(int n){
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2; i<n+1; i++)
            dp[i]=dp[i-1]+dp[i-2];

        return dp[n];
    }
}

/**
 * TC : O(n)
 * SC : O(n)  n size array
 */
