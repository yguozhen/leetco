package tree;

public class E_101_SymmetricTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> left = new LinkedList<>();
            Queue<TreeNode> right = new LinkedList<>();
            if (root == null) return true;
            if (root.left != null && root.right != null) {
                left.add(root.left);
                right.add(root.right);
            } else if (root.left != null || root.right != null) {
                return false;
            }


            while (!left.isEmpty() && !right.isEmpty()) {
                TreeNode l = left.poll();
                TreeNode r = right.poll();

                if (l.val != r.val) {
                    return false;
                }


                if (l.left != null && r.right != null) {
                    left.add(l.left);
                    right.add(r.right);
                } else if (l.left != null || r.right != null) {
                    return false;
                }
                if (l.right != null && r.left != null) {
                    left.add(l.right);
                    right.add(r.left);
                } else if (l.right != null || r.left != null) {
                    return false;
                }


            }
            return true;


        }
    }
}