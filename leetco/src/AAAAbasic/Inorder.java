package AAAAbasic;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
    public class TreeNode {
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
    //solution1 iteration with stack and two while
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !stack.isEmpty()){
            while(temp != null){
                stack.add(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            res.add(temp.val);
            temp = temp.right;
        }
        return res;
    }

    //solution2 recursive with self
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

    //solution3 divided and conquer
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> left = inorderTraversal3(root.left);
        List<Integer> right = inorderTraversal3(root.right);

        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        return res;
    }
}
