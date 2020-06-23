package tree;

public class M_285InOrderSuccessorInBST {
    //solution1 iteration
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (p.right != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int temp = Integer.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (temp == p.val) return root;
            temp = root.val;
            root = root.right;
        }
        return null;
    }
}
