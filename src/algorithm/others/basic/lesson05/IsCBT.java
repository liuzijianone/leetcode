package algorithm.others.basic.lesson05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/15 14:21
 */
public class IsCBT {
    public static void main(String[] args) {

        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.right = new Node(5);
        printTree(head);
        System.out.println(isCBT(head));

    }

    public static boolean isCBT(Node root){
        if (root == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        Node temp = root;
        queue.add(temp);

        while(!queue.isEmpty()){
            temp = queue.poll();
            if (temp != null){
                queue.add(temp.left);
                queue.add(temp.right);
            }else {
                break;
            }
        }
        while(!queue.isEmpty()){
            temp = queue.poll();
            if (temp != null){
                return false;
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
