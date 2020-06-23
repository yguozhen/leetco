package tree;

public class M_230KthSmallestElementInABST {

    //solution 1 iteration
    int i = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list.get(k-1);

    }

    //solution 2 recursive
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    //solution3
    int count;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        res = 0;
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right);
    }

}
