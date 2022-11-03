package Q16;
/*
 * Given the root of a binary search tree, and an integer k, 
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * 
 * Input: root = [3,1,4,null,2], k = 2
 * Output: 2
 */

import java.util.LinkedList;

public class KthSmallestElementInBST {
    public static int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
          while (root != null) {
            stack.push(root);
            root = root.left;
          }
          root = stack.pop();
          if (--k == 0) return root.val;
          root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        System.out.println(kthSmallest(root, 2));
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
 * Time complexity: O(H+k), where H is a tree height. 
 * This complexity is defined by the stack, which contains at least H + k elements, 
 * since before starting to pop out one has to go down to a leaf. 
 * This results in O(log N + k) for the balanced tree and O(N + k)O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
 * 
 * Space complexity: O(H) to keep the stack, 
 * where H is a tree height. 
 * That makes O(N) in the worst case of the skewed tree, 
 * and O(logN) in the average case of the balanced tree.
 */
