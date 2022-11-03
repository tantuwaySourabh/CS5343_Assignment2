package Q14;
/*
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Given two integer arrays preorder and inorder where 
 * preorder is the preorder traversal of a binary tree and inorder is the inorder traversal 
 * of the same tree, 
 * construct and return the binary tree.
 * 
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */

public class ConstructBinaryTreefromPreorderAndInorder {
    static int preIdx = 0;
    static void printTree(TreeNode root) {
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.val+",");
        printTree(root.right);
    }
    public static int findIndex(int[] arr, int s, int e, int val){
        for(int i=s;i<=e;i++){
            if(arr[i] == val)return i;
        }
        return -1;
    }
    public static TreeNode bTree(int [] preorder, int [] inorder, int start, int end){
        if(start > end)return null;
        TreeNode tn = new TreeNode(preorder[preIdx++]);
        if(start == end)return tn;
        int i = findIndex(inorder, start, end, preorder[preIdx-1]);
        tn.left = bTree(preorder,inorder, start, i-1);
        tn.right = bTree(preorder,inorder, i+1,end);
        return tn;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        int n = preorder.length;
        TreeNode t = bTree(preorder, inorder, 0, n-1);    
        return t;
    }
    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.println("In order tree traversal");
        printTree(root);
        System.out.println();
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
 * SC: O(n)
 */
