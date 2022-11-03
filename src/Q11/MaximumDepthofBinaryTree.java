package Q11;

/*
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 */

public class MaximumDepthofBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + (lh > rh ? lh : rh);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));
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
 * TC: O(n)
 */