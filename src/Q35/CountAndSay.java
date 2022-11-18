
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Recursion]
     The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

     countAndSay(1) = "1"
     countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
     To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit.
     Then for each substring, say the number of digits, then say the digit.
     Finally, concatenate every said digit.

     Input: n = 1
     Output: "1"
     Explanation: This is the base case.

     Input: n = 4
     Output: "1211"
     Explanation:
     countAndSay(1) = "1"
     countAndSay(2) = say "1" = one 1 = "11"
     countAndSay(3) = say "11" = two 1's = "21"
     countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

     link:  https://leetcode.com/problems/count-and-say/description/


 **/

package Q35;


public class CountAndSay {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String pre = countAndSay(n - 1);

        int count = 0;
        char temp = '0';
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < pre.length(); i++){
            if(i == 0){
                count++;
                temp = pre.charAt(i);
                continue;
            }

            if(pre.charAt(i) == pre.charAt(i-1))
                count++;
            else{
                sb.append(count).append(temp);
                temp = pre.charAt(i);
                count = 1;
            }

        }
        sb.append(count).append(temp);
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println("count and say for n = 4 ");
        System.out.print("final string will be :  " + countAndSay(4));

    }

}

//Complexity Analysis:
/**
 *
 *
 * TC : O(n * 2^n) , finding previous calls answer and iterating over it to find current answer
 * SC : O(2^n), result string length depends on n
 */
