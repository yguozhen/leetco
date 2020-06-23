package tree;

public class E_590NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            res.addFirst(cur.val);
            for(Node temp : cur.children){
                if(temp != null) stack.push(temp);
            }
        }
        return res;
    }
}
