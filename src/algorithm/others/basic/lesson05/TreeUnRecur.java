package algorithm.others.basic.lesson05;

import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/13 10:59
 */
public class TreeUnRecur {
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

        preOrderUnrecur(head);
        inOrderUnrecur(head);
        postOrderUnrecur(head);


    }
    public static void preOrderUnrecur(Node node){
        if (node == null){
            return;
        }
        Node temp = node;
        Stack<Node> stack = new Stack<>();
        stack.push(temp);

        while (!stack.isEmpty()){
            temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){


                stack.push(temp.left);
            }
        }
    }

    public static void inOrderUnrecur(Node node){
        if (node == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    public static void postOrderUnrecur(Node node){
        if (node == null){
            return;
        }
        Node temp = node;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(temp);

        while (!stack1.isEmpty()){
            temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null){
                stack1.push(temp.left);
            }
            if (temp.right != null){
                stack1.push(temp.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop() + " ");
        }

    }
}
