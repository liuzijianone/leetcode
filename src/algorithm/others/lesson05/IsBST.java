package algorithm.others.lesson05;

import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/14 16:51
 */
public class IsBST {
    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));

    }

    public static boolean isBST(Node root) {
        if (root == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node node = root;
        int number = Integer.MIN_VALUE;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (node.value > number) {
                    number = node.value;
                    node = node.right;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int x){
            this.value = x;
        }
    }


    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();

    }
}
