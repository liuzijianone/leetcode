package algorithm.others.basic.lesson04;

import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/11 9:24
 */
public class isPalindromeDemo {
    public static void main(String[] args) {
//        Node n7 = new Node(1, null);
//        Node n6 = new Node(2, n7);
//        Node n5 = new Node(3, n6);
//        Node n4 = new Node(4, n5);
//        Node n3 = new Node(9, n4);
//        Node n2 = new Node(2, n3);
//        Node n1 = new Node(1, n2);
//
//        System.out.println(isPalindrome02(n1));
        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");


    }

    public static boolean isPalindrome1(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp != null){
            stack.add(temp);
            temp = temp.next;
        }
        temp = head;

        while(!stack.isEmpty()){
            if (stack.pop().data != temp.data){
                return false;
            }
            temp = temp.next;
        }
        return  true;
    }

    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node right = head;
        Node left = right;
        while (right.next != null && right.next.next != null){
            right = right.next.next;
            left = left.next;
        }

        if (right.next != null){
            right = right.next;
        }

        Node medium = left;


        left = left.next;
        medium.next = null;

        while (left != null){
            Node node = left.next;
            left.next = medium.next;
            medium.next = left;
            left = node;
        }

        left = head;
        Node temp = medium.next;
        while (temp != null){
            // while (left != medium) 错误
            if (left.data != temp.data){
                return  false;
            }
            left = left.next;
            temp = temp.next;
        }

        medium.next = null;

        while (right != null){
            Node node = right.next;
            right.next = medium.next;
            medium.next = right;
            right = node;
        }

        return true;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

}

class Node{
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }
}
