
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Divide and Conquor, Recursion, BST]

     Given an integer array nums where the elements are sorted in ascending order, convert it to a
     height-balanced binary search tree.

     Example:
     Input: nums = [-10,-3,0,5,9]
     Output: [0,-3,9,-10,5]    {level order traversal of BST.}
     Explanation: [0,-10,5,null,-3,null,9] is also accepted:


 link:https: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

 **/

package Q27;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayToBST {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args){

        System.out.println("tree for sorted array [-10,-3,0,5,9] is  : " );
        System.out.print("level order traversal for BST  : " );
        print(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }

    public static void print(TreeNode root){  //for printing level order traversal for BST
        List<List<Integer>> nodes = new ArrayList<>();
        if(root == null){
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(queue.size() != 0){
            int size = queue.size();
            List<Integer> layer_vals = new ArrayList<Integer>();

            while(size != 0){
                TreeNode temp = queue.poll();
                layer_vals.add(temp.val);

                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
                size--;
            }

            nodes.add(layer_vals);

        }

        for (List<Integer> l1 : nodes) {
            for (Integer n : l1) {
                System.out.print(n + ", ");
            }

        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode head = createTree(nums, 0, n - 1);
        return head;
    }

    public static TreeNode createTree(int[] nums, int left, int right){
        if(right < left) return null;

        if(left == right){
            return new TreeNode(nums[left]);
        }

        int mid  = (left + right) / 2;

        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = createTree(nums, left, mid - 1);
        newNode.right = createTree(nums, mid + 1, right);

        return newNode;

    }


}

//Complexity Analysis:
/**
 * TC : O(n)  , where n will be the nodes
 * SC : O(n)  , to store the tree
 */
