package tree;

public class M_173BinarySearchTreeIterator {
    ist<Integer> res = new ArrayList<>();
    int index;

    public void inOrder(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

    }
    public BSTIterator(TreeNode root) {
        this.inOrder(root);
        this.index = - 1;
}

    /** @return the next smallest number */
    public int next() {
        return this.res.get(++this.index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index + 1< this.res.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
