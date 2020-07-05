package tree;

public class E_559MaximumDepthOfNaryTree {
    private int max = 1;
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        helper(root, 1);
        return max;
    }

    private void helper(Node root, int level){
        if(root == null){
            return;
        }
        if(level > max){
            max = level;
        }
        for(Node node : root.children){
            helper(node, level + 1);
        }
    }
}
