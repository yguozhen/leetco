package tree;

public class E_437PathSum {
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
    //solution1
    class Solution {
        public int number = 0;
        public int pathSum(TreeNode root, int sum) {
            if(root == null) return 0;

            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.add(root);
            while(!stack.isEmpty()){
                TreeNode current = stack.pop();
                Sum(current, sum);
                if(current.left!=null) stack.add(current.left);
                if(current.right != null) stack.add(current.right);
            }
            return number;



        }
        public void Sum(TreeNode root, int sum){
            if(root == null) return;
            sum = sum - root.val;
            if(sum == 0){
                number ++;
            }
            if(root.left == null && root.right == null){
                return ;
            }
            Sum(root.left,sum);
            Sum(root.right,sum);
        }
    }
    //recursive 2
    class Solution {

        public int pathSum(TreeNode root, int sum) {
            if (root == null) return 0;
            return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        public int helper(TreeNode root, int sum) {
            int res = 0;
            if (root == null) return res;
            if (sum == root.val) res++;
            res += helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
            return res;
        }
    }

    //hashmap 3
    // map :(0, 1) (10, 1/0) (15, 1/0) (18, 1/0/1/0/1/0) (21, 1/0) (16, 1/0) (17, 1/0) (7, 1/0)
    // res : 10( 5( 3 (1 + 0) + 2 (0 + 1)) + -3 (0 + 1)) = 3
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //如果是0的话至少有一条路径
        return helper(root, 0, sum, map);
    }

    public int helper(TreeNode root, int curSum, int sum, HashMap<Integer, Integer> map) {
        if (root == null) return 0;
        curSum += root.val;
        int res = map.getOrDefault(curSum - sum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        res += helper(root.left, curSum, sum, map) + helper(root.right, curSum, sum, map);
        map.put(curSum, map.get(curSum) - 1);
        return res;
    }

}
}
