
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Stack, Binary Tree]

    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     Input: root = [1,2,2,3,4,4,3] {it is array representation of tree}
     Output: true


 link:  https://leetcode.com/problems/symmetric-tree/description/

 **/

package Q28;

import Q27.ArrayToBST;
import Q31.ReverseLL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SymmetricTree{

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
    public static boolean isSymmetric(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.empty()){
            TreeNode left  = stack.pop();
            TreeNode right = stack.pop();

            if(left == null && right == null ) continue;
            else if ( left == null || right == null || right.val != left.val) return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);


        }

        return true;

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

    public static void main(String[] args){
        //generating a tree
        TreeNode root = new TreeNode(1);

        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        root.left = a; root.right = b;

        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        a.left = c; a.right = d;

        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(3);

        b.left = e; b.right = f;
        System.out.print("checking for symmetricity of  tree ");
        print(root);

        //checking if sysmmetric
        System.out.print("\nsymmetric " + isSymmetric(root) );

    }


}

//Complexity Analysis:
/**
 * TC : O(n)  ,  number of nodes
 * SC : O(n)  , stack size at any time
 */
