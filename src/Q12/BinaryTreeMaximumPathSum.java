package Q12;

/*
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes 
 * in the sequence has an edge connecting them. A node can only appear 
 * in the sequence at most once. Note that the path does not need to pass through the root.
 * 
 * The path sum of a path is the sum of the node's values in the path.
 * 
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * 
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * 
 */
public class BinaryTreeMaximumPathSum {
    private static int ans;
    public static int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }
    
    private static int helper(TreeNode root) {
        if(root == null) return 0;
        
        int lsum = helper(root.left);
        int rsum = helper(root.right);
        
        ans = Math.max(ans, root.val);
        ans = Math.max(ans, Math.max(lsum, rsum) + root.val);
        ans = Math.max(ans, lsum+rsum+root.val);
        
        if(lsum < 0) lsum = 0;
        if(rsum < 0) rsum = 0;
        
        return Math.max(lsum, rsum) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*
 * Time complexity: O(N), where N is number of nodes, since we visit each node not more than 2 times.
 * Space complexity: O(H), where H is a tree height, to keep the recursion stack.
 * 
 */
