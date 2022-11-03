package Q15;

/*
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * 
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * 
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * Input: root = [2,1,3]
 * Output: true
 * 
 */
public class ValidateBinarySearchTree {
    public static boolean isValid(TreeNode node, Integer min, Integer max){
        if(node == null)return true;
        
        if(min != null  && node.val <= min)return false;
        if(max != null  && node.val >= max)return false;
        
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
    public static boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);   
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(isValidBST(root));
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
 * Time complexity : O(N) since we visit each node exactly once.
 * Space complexity : O(N) since we keep up to the entire tree.
 */
