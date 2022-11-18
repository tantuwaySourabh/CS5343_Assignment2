
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Array]
     You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
     The digits are ordered from most significant to least significant in left-to-right order.
     The large integer does not contain any leading 0's.
     Increment the large integer by one and return the resulting array of digits.

     Input: digits = [1,2,3]
     Output: [1,2,4]
     Explanation: The array represents the integer 123.
     Incrementing by one gives 123 + 1 = 124.
     Thus, the result should be [1,2,4].

    link: https://leetcode.com/problems/plus-one/description/


 **/

package Q40;


public class PlusOne {

    public static int[] plusOne(int[] digits) {

        int carry = 1;
        int i = digits.length - 1;
        while(i > 0){
            if(digits[i] == 9 && carry == 1){
                digits[i] = 0; carry = 1;
            }else{
                digits[i] += carry;
                carry = 0;
            }

            i--;
        }

        if(digits[i] == 9 && carry == 1){
            digits[i] = 0;
            int temp[] = new int[digits.length + 1];
            temp[0] = 1;
            for(int j = 1; j < digits.length; j++){
                temp[j] = digits[j];
            }

            return temp;
        }else{
            digits[i] += carry;
            return digits;
        }



    }


    public static void main(String[] args){
        int[] digits = {1,2,3};

        System.out.println("for number = [1,2,3]" );
        int[] result = plusOne(digits);
        System.out.println("result after adding 1 is  "   );

        for(int i= 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println("");

    }

}

//Complexity Analysis:
/**
 *
 * TC : O(n) , one traversal only.
 * SC : O(n), array required
 */
