package tree;

public class E_404sumOfLeftLeaves {
    /**
     * 把res 写成全球变量
     */
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null )  {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            }
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return res;

    }

    /**
     * 不把res 写成全球变量
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.left != null )  {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
        }
        res += sumOfLeftLeaves(root.right);
        return res;
    }
}
