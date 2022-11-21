
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Recursion]
     You are climbing a staircase. It takes n steps to reach the top.
     Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

     Input: n = 3
     Output: 3
     Explanation: There are three ways to climb to the top.
     1. 1 step + 1 step + 1 step
     2. 1 step + 2 steps
     3. 2 steps + 1 step


 link: https://leetcode.com/problems/climbing-stairs/description/

 **/

package Q24;
public class ClimbingStairs {

    public static int climbStairs(int n){
        int arr[] =  new int[n + 1];
        arr[n] = climbRecursively(arr, n);
        return arr[n];
    }

    public static int climbRecursively(int arr[], int n){

        if(n == 1){
            arr[1] = 1;
            return 1;
        }
        if(n == 2){
            arr[n - 1] = 1;
            arr[n] = 2;
            return 2;
        }

        if(arr[n] != 0)
            return arr[n];
        else{
            arr[n] = climbRecursively(arr, n - 1) + climbRecursively(arr, n - 2);
            return arr[n];
        }
    }

    public static void main(String[] args){

        System.out.println("Number of ways, stair of size 5 will be climbed is : " + climbStairs(5));

    }
}

/**
 * TC : O(n)
 * SC : O(n)  n size array
 */
