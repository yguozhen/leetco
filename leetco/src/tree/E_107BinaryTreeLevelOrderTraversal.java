package tree;

public class E_107BinaryTreeLevelOrderTraversal {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            helper(res, root, 0);
            Collections.reverse(res);
            return res;
        }

        public static void helper(List<List<Integer>> res, TreeNode root, int level) {
            if (root == null ) return;
            if (level >= res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            helper(res, root.left, level + 1);
            helper(res, root.right, level + 1);
        }



    }
}
