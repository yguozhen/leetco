package tree;

public class M_513_FindBottomLeftTreeValue {
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
        public int findBottomLeftValue(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res.get(res.size()).get(0);
            helper(res, root, 0);
            return res.get(res.size()-1).get(0);
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
