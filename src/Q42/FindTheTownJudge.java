package Q42;

/*
 * https://leetcode.com/problems/find-the-town-judge/
 * 
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is
 * secretly the town judge. If the town judge exists, then:
 * 
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai
 * trusts the person labeled bi.
 * 
 * Return the label of the town judge if the town judge exists and can be identified, or return -1
 * otherwise.
 * 
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 * 
 */
public class FindTheTownJudge {
    public static int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1) {
            return -1;
        }
        
        int[] trustScores = new int[N + 1];
    
        for (int[] relation : trust) {
            trustScores[relation[0]]--;
            trustScores[relation[1]]++; 
        }
        
        for (int i = 1; i <= N; i++) {
            if (trustScores[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 2;
        int[][] trust = {{1,2}};
        System.out.println(findJudge(n, trust));
    }
}

/*
 * Let N be the number of people, and E be the number of edges (trust relationships).
 * Time Complexity: O(E)
 * Space Complexity: O(N)
 */
