package tree;

public class E_530MInimumAbsoluteDifferenceinBST {
    //solution1 迭代
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int temp = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        for(int i = 0; i < list.size() - 1; i++){
            if(Math.abs(list.get(i) - list.get(i+1)) < temp){

                temp = Math.abs(list.get(i) - list.get(i+1));
            }
        }

        return temp;

    }

    //solution2 递归
    /*递归*/
    int res = Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        helper(root.right);
    }
}
