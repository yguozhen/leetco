package tree;

public class E_538ConvertBSTToGreaterTree {
    //solution1 迭代
    public TreeNode convertBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)  return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        helper(root, list);
        return root;

    }
    public void helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        int sum = 0;
        for(int i = list.indexOf(root.val);i < list.size(); i++){
            sum = sum + list.get(i);
        }
        root.val = sum;
        helper(root.left,list);
        helper(root.right,list);
    }

    //solution2 迭代优化
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null)  return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
    //solution3 递归
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }


}
