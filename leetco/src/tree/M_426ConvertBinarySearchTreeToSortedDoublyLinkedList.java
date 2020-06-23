package tree;

public class M_426ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        ArrayList<Node> res = new ArrayList<>();
        if(root == null) return null;
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node);
            node = node.right;
        }
        for(int i = 0; i < res.size() - 1; i ++){
            res.get(i).right = res.get(i + 1);
            res.get(i + 1).left = res.get(i);
        }
        res.get(res.size() - 1).right = res.get(0);
        res.get(0).left = res.get(res.size() - 1);
        return res.get(0);

    }
}
