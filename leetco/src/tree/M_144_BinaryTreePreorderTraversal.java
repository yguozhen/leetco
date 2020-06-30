package tree;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Time: O(n)
//Space:O(h)
public class M_144_BinaryTreePreorderTraversal {


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
    /*递归 recursive*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);

    }

    /*迭代 iteration*/
    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            /*
            stack是先进后出，所以应该先right再，left
             */
            if (cur.right !=null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }

        return res;
    }
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }

        //divided
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        //conquer
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }
}
