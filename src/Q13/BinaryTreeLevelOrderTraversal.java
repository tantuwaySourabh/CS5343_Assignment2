package Q13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {   
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null)return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        List<Integer> ls = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp == null){
                ans.add(new ArrayList<>(ls));
                ls.clear();
                if(!q.isEmpty())q.add(null);
            }else{
                ls.add(tmp.val);
                if(tmp.left != null)q.add(tmp.left);
                if(tmp.right != null)q.add(tmp.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));

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
