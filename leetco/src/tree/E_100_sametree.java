package tree;

public class E_100_sametree {
    /**
     * Definition for a binary tree node.
     *
     **/
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

    // recursive1
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null&& q == null){
                return true;
            }
            if((p == null&&q != null) || (q ==null &&p!= null)||p.val != q.val  ){
                return false;
            }
            return isSameTree(p.left,q.left)&&isSameTree(p.right, q.right);
        }
    }
    //recursive2
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {

            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
    //2,iteration
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            LinkedList<TreeNode> pp = new LinkedList<TreeNode>();
            LinkedList<TreeNode> qq = new LinkedList<TreeNode>();
            pp.add(p);
            qq.add(q);

            while(!pp.isEmpty() && !qq.isEmpty()){
                TreeNode curr_p = pp.pollLast();
                TreeNode curr_q = qq.pollLast();
                if(curr_p == null && curr_q == null){
                    return true;
                }
                if(curr_p == null || curr_q == null ||curr_p.val != curr_q.val){
                    return false;
                }
                if(curr_p.left != null && curr_q.left != null) {
                    pp.add(curr_p.left);
                    qq.add(curr_q.left);
                }else if(curr_p.left != null || curr_q.left != null ){
                    return false;
                }
                if(curr_p.right != null && curr_q.right != null) {
                    pp.add(curr_p.right);
                    qq.add(curr_q.right);
                }else if(curr_p.right != null || curr_q.right != null){
                    return false;
                }

            }
            return true;
        }
    }
}
