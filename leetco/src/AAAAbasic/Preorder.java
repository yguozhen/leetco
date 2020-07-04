package AAAAbasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {

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
    //solution1 stack + list, iteration
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.right != null){
                stack.add(temp.right);
            }
            if(temp.left != null){
                stack.add(temp.left);
            }
        }
        return res;
    }

    //solution 2 recursive use helper
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    public void helper(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    //solution 3 divided and conquer
    // create list every time
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> left = preorderTraversal3(root.left);
        List<Integer> right = preorderTraversal3(root.right);
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }

}
