package tree;

public class M_236LowestCommonAncestorOfABinaryTree {


   //solution 1 DFS
    TreeNode node = new TreeNode();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == null) return q;
        if(q == null) return p;

        helper(root, p, q);
        return node;

    }
    public Boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;

        //recustive case

        int left = helper(root.left, p, q)? 1 : 0;
        int right = helper(root.right, p, q)? 1 : 0;

        int mid = (root == p || root ==q)? 1:0;
        if(mid + left + right >= 2){
            node = root;
        }
        return (mid + left + right > 0);

    }

    //solution 2

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

}
