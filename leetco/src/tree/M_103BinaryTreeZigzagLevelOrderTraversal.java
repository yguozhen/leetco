package tree;

public class M_103BinaryTreeZigzagLevelOrderTraversal {
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
    //recursive
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            helper(res, root, 0);
            traverse(res, 0);
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
        public static void traverse(List<List<Integer>> res, int level){
            if(res == null) return;
            if(level >= res.size()) return;
            if(level%2 == 1){
                Collections.reverse(res.get(level));
            }
            level ++;
            traverse(res, level);
        }

    }
    //iteration
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean x = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                if (x) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }

            }
            res.add(list);
            x = x ? false : true;

        }
        return res;
    }


}
