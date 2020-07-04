package AAAAbasic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Postorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
        //solution1 iteration use addFirst and left and right
        public List<Integer> postorderTraversal1(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                res.addFirst(temp.val);
                if (temp.left != null) {
                    stack.add(temp.left);
                }
                if (temp.right != null) {
                    stack.add(temp.right);
                }
            }

            return res;
        }

        //solution2 recursive
        public List<Integer> postorderTraversal2(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(res, root);
            return res;
        }

        public void helper(List<Integer> res, TreeNode root) {
            if (root == null) {
                return;
            }

            helper(res, root.left);
            helper(res, root.right);
            res.add(root.val);
        }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        List<Integer> left = postorderTraversal3(root.left);
        List<Integer> right = postorderTraversal3(root.right);
        res.addAll(left);
        res.addAll(right);
        res.add(root.val);
        return res;
    }



}

