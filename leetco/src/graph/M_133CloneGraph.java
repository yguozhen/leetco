package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
//solution1 hashmap + arraylist to deep copy
public class M_133CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        HashMap<Node, Node> map = new HashMap<>();
        List<Node> array = new ArrayList<>();
        array.add(node);
        map.put(node, new Node(node.val));
        int start = 0;
        while(start < array.size()){
            Node head = array.get(start++);
            for(int i = 0; i < head.neighbors.size(); i++){
                Node temp = head.neighbors.get(i);
                if(!map.containsKey(temp)){
                    map.put(temp, new Node(temp.val));
                    array.add(temp);
                }
            }
        }

        for(int i = 0; i < array.size(); i++){
            Node newnode = map.get(array.get(i));
            for(int j = 0; j < array.get(i).neighbors.size(); j++){
                newnode.neighbors.add(map.get(array.get(i).neighbors.get(j)));
            }
        }
        return map.get(node);


    }
}
