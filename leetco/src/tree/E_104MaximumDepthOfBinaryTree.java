package tree;

public class E_104MaximumDepthOfBinaryTree {


      public class TreeNode {
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
    class Solution {

        //solution1 recursive dfs
        public int maxDepth1(TreeNode root) {
            if(root == null) return 0;
            return helper(root, 0);

        }
        public int helper(TreeNode root, int level){
            if(root == null) return 0;
            if(root.left == null && root.right == null) return level +1;

            return Math.max(helper(root.left, level + 1), helper(root.right, level +1));
         }

         //solution2 divided and conquer
         public int maxDepth2(TreeNode root) {
             if(root == null){
                 return 0;
             }
             int left = maxDepth2(root.left);
             int right = maxDepth2(root.right);
             return Math.max(left, right) + 1;
         }

         //solution3
    }
}
