package algorithm.others.lesson05;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/13 10:50
 */
public class TreeRecur {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        postOrderRecur(head);
        System.out.println();


    }
    public static void preOrderRecur(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.val + " ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    public static void inOrderRecur(Node node){
        if (node == null){
            return;
        }
        preOrderRecur(node.left);
        System.out.print(node.val + " ");
        preOrderRecur(node.right);
    }

    public static void postOrderRecur(Node node){
        if (node == null){
            return;
        }

        preOrderRecur(node.left);
        preOrderRecur(node.right);
        System.out.print(node.val + " ");
    }

}

class Node{
    int val;
    Node left;
    Node right;

    public Node(int x){
        this.val = x;
    }
}