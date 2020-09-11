package algorithm.CodingInterviews.Test35;

import java.util.HashMap;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/2 17:29
 */
public class Test35 {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Node node = head;
        HashMap<Node, Node> map = new HashMap<>();

        while (node != null){
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;

        while (node != null){
            map.get(node).random = map.get(node.random);
            map.get(node).next = map.get(node.next);
            node = node.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}