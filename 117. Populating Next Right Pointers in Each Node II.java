//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/?envType=study-plan-v2&envId=top-interview-150
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Queue<Node> nextQueue = new LinkedList<>();
        Node predecessor = null;
        while(!queue.isEmpty()) {
            Node element = queue.poll();
            Node left = element.left;
            if (left != null) nextQueue.add(left);
            Node right = element.right;
            if (right != null) nextQueue.add(right);
            if (predecessor == null) predecessor = element;
            else {
                predecessor.next = element;
                predecessor = predecessor.next;
            }
            if (queue.isEmpty()) {
                predecessor = null;
                queue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }
        return root;
    }
}
