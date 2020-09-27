package algorithm.others.basic.lesson05.TestSerial;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/13 21:51
 */
public class SerializeAndReconstructTree {
    public static void main(String[] args) {

        Node head = null;
        printTree(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = unserialByPre(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        String level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = unserialByLevel(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);



        System.out.println("====================================");

        head = new Node(1);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = unserialByPre(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);



        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = unserialByLevel(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = unserialByPre(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);



        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = unserialByLevel(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = unserialByPre(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);


        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = unserialByLevel(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");


    }
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int x){
            this.value = x;
        }
    }

    public static String serialByPre(Node root){
        if (root == null){
            return "#_";
        }
        String res = String.valueOf(root.value)+"_";
        res += serialByPre(root.left);
        res += serialByPre(root.right);
        return res;
    }

    public static Node unserialByPre(String res) {
        String[] values = res.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String value : values) {
            queue.add(value);
        }
        return generateTreeByPre(queue);
    }

    public static Node generateTreeByPre(Queue<String> queue){
        if (queue.isEmpty()){
            return null;
        }
        String value = queue.poll();
        if ("#".equals(value)){
            return null;
        }
        Node node = new Node(Integer.parseInt(value));
        node.left = generateTreeByPre(queue);
        node.right = generateTreeByPre(queue);

        return node;
    }



    public static String serialByLevel(Node node){
        if (node == null){
            return "#_";
        }
        Node temp = node;
        String res = "";
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            temp = queue.poll();
            if (temp == null){
                res += "#_";
            }else{
                res += String.valueOf(temp.value) + "_";
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return res;
    }

    public static Node unserialByLevel(String res){
        String[] values = res.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String value : values) {
            queue.add(value);
        }
        return generateTreeByLevel(queue);
    }

    private static Node generateTreeByLevel(Queue<String> queue) {
        if (queue.isEmpty()){
            return null;
        }
        Queue<Node> queueNode = new LinkedList<>();
        Node head = generateNodeByString(queue);

        if (head != null){
            queueNode.add(head);
        }

        while(!queue.isEmpty()){
            Node node = queueNode.poll();
            node.left = generateNodeByString(queue);
            node.right = generateNodeByString(queue);
            if (node.left != null){
                queueNode.add(node.left);
            }
            if (node.right != null){
                queueNode.add(node.right);
            }
        }
        return head;
    }

    private static Node generateNodeByString(Queue<String> queue){
        if (queue.isEmpty()){
            return null;
        }
        String value = queue.poll();
        if ("#".equals(value)){
            return null;
        }
        return new Node(Integer.parseInt(value));
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
