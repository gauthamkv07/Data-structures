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
    private class NodeVisitPair{
        Node node;
        boolean isVisited;

        NodeVisitPair(Node node, boolean isVisited) {
            this.node = node;
            this.isVisited = isVisited;
        }
    }

    public List<Integer> postorder(Node root) {
        Stack<NodeVisitPair> stack = new Stack<>();

        List<Integer> list = new ArrayList<>();

        if(root == null) return list;
        stack.push(new NodeVisitPair(root, false));

        while(!stack.isEmpty()) {
            NodeVisitPair pair = stack.pop();

            if(pair.isVisited) {
                list.add(pair.node.val);
                continue;
            }

            pair.isVisited = true;
            stack.push(pair);

            List<Node> children = pair.node.children;
            for(int i = children.size() - 1; i >= 0; i--) stack.push(new NodeVisitPair(children.get(i), false));
        }

        return list;
    }
}