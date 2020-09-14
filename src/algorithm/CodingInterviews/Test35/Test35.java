package algorithm.CodingInterviews.Test35;

import java.util.HashMap;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/2 17:29
 *
 *  请实现 copyRandomList 函数，复制一个复杂链表。
 *  在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 */
public class Test35 {
    public static void main(String[] args) {

    }

    public Node copyRandomList01(Node head) {
        if (head == null){
            return null;
        }else if (head.next == null){
            if (head.random == null){
                return new Node(head.val);
            }
            else{
                Node node = new Node(head.val);
                node.random = node;
                return node;
            }
        }

        Node temp = head;
        while(temp != null){
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }

        temp = head;

        while (temp != null){
            Node node = temp.next;
            if (temp.random != null){
                node.random = temp.random.next;
            }
            temp = node.next;
        }

        temp = head;
        Node newHead = head.next;
        Node node = newHead;

        head.next = node.next;
        head = head.next;

        while (head != null){
            node.next = head.next;
            node = node.next;
            head.next = node.next;
            head = head.next;
        }
        return newHead;
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