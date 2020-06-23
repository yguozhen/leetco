package tree;

public class E_226_inverse {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if( root == null) return null;
            swipe(root);
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

        public void swipe(TreeNode root){
            TreeNode temp = new TreeNode();
            if(root.left != null || root.right != null){
                temp = root.left;
                root.left = root.right;
                root.right = temp;
            }

        }
    }
}
