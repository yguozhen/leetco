package tree;

public class E_589_N_aryTreePreorderTraversal {

    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public List<Integer> preorder(Node root) {
            ArrayList<Integer> output = new ArrayList<Integer>();
            LinkedList<Node> cache = new LinkedList<Node>();
            if(root == null) return output;
            cache.add(root);
            while(!cache.isEmpty()){
                Node current = cache.pollLast();
                output.add(current.val);
                Collections.reverse(current.children);
                for (Node item : current.children){
                    cache.add(item);

                }
            }
            return output;



        }
    }
}
