package tree;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
public class E_617MergeTwoBinaryTree {
    //solution1 recursive
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode result = new TreeNode();
        return helper(result, t1, t2);
    }
    private TreeNode helper(TreeNode result, TreeNode t1, TreeNode t2){
        if(t1 == null){
            result = t2;
            return result;
        }
        if(t2 == null){
            result = t1;
            return result;
        }
        result = new TreeNode(t1.val + t2.val);
        result.left = helper(result.left, t1.left, t2.left);
        result.right = helper(result.right, t1.right, t2.right);
        return result;
    }
}
