package tree;

public class E_104MaximumDepthOfBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            return helper(root, 0);

        }
        public int helper(TreeNode root, int level){
            if(root == null) return 0;
            if(root.left == null && root.right == null) return level +1;

            return Math.max(helper(root.left, level + 1), helper(root.right, level +1));



        }
    }
}
