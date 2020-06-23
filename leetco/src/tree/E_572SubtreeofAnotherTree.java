package tree;

public class E_572SubtreeofAnotherTree {
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) return false;
            if (isSametree(s, t)) return true;
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        public boolean isSametree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;

            return isSametree(p.left, q.left) && isSametree(p.right, q.right);
        }
    }
}
