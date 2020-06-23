package tree;

public class M_366FindLeavesOfBinaryTree {

    //solution1; postorder
    List<List<Integer>> result = new ArrayList<>();
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int max = Math.max(left,right);
        if(result.size() <= max){
            result.add(new ArrayList());
        }
        result.get(max).add(root.val);
        return max + 1;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null) return Arrays.asList();

        helper(root);
        return result;
    }
}
