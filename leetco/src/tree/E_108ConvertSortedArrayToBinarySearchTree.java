package tree;

public class E_108ConvertSortedArrayToBinarySearchTree {

    //solution1
    int[] nums;

    public TreeNode helper(int left, int right){
        if(left > right){
            return null;
        }
        int p = (left + right) / 2;
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p -1);
        root.right = helper(p + 1, right);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }
    //solution 2
    Node pre = null;

     public Node treeToDoublyList(Node root) {
         if (root == null) return null;
         Node dummy = new Node(0, null, null);
         pre = dummy;
         helper(root);
         pre.right = dummy.right;
         dummy.right.left = pre;

         return dummy.right;

     }
     public void helper(Node root) {
         if (root == null) return;
         helper(root.left);
         pre.right = root;
         root.left = pre;
         pre = root;
         helper(root.right);
     }
}
