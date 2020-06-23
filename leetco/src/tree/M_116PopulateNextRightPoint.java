package tree;

public class M_116PopulateNextRightPoint {
    //solution1 preorder + levelorder
    public Node connect(Node root) {
        Node start = root;
        while (start != null) {
            Node cur = start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
        return root;
    }

    //solution2 queue
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(queue.size()>0){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                Node node = queue.poll();
                if(i < size - 1){
                    node.next = queue.peek();
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
