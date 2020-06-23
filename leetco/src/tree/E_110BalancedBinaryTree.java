package tree;

public class E_110BalancedBinaryTree {
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

    //solution 1
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(Math.abs(helper(node.left, 0) - helper(node.right, 0)) >1){
                    return false;
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            return true;


        }

        public int helper(TreeNode root, int level){
            if(root == null) return 0;
            if(root.left == null && root.right == null) return level + 1;
            return Math.max(helper(root.left, level + 1), helper(root.right, level + 1));
        }
    }

    //solution2

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
