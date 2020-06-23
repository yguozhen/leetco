package tree;

public class H_428SerializeAndDeserialize {
    class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            List<String> list = new LinkedList<>();
            serializeHelper(root, list);
            return String.join(",", list);
        }

        private void serializeHelper(Node root, List<String> list) {
            if (root == null) return;
            list.add(String.valueOf(root.val));
            list.add(String.valueOf(root.children.size()));
            for (Node child : root.children) {
                serializeHelper(child, list);
            }
        }

        // Decodes your encoded data to tree.
        // [1,3,3,2,5,0,6,0,2,0,4,0]
        public Node deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] s = data.split(",");
            Queue<String> queue = new LinkedList<>(Arrays.asList(s));
            return deserializeHelper(queue);
        }

        private Node deserializeHelper(Queue<String> queue) {
            Node root = new Node();
            root.val = Integer.parseInt(queue.poll());
            int size = Integer.parseInt(queue.poll());
            root.children = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root.children.add(deserializeHelper(queue));
            }
            return root;

        }
    }

}
