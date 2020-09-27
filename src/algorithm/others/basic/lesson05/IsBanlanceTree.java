package algorithm.others.basic.lesson05;




/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/14 15:36
 */
public class IsBanlanceTree {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalancedTree(head));


    }

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int x) {
            this.val = x;
        }
    }

    public static class Result{
        int depth;
        boolean flag;

        public Result(int depth, boolean flag) {
            this.depth = depth;
            this.flag = flag;
        }
    }

    public static boolean isBalancedTree(Node root){
        if (root == null){
            return true;
        }

        Result leftReturn = jugdeBalanceTree(root.left);
        Result rightReturn = jugdeBalanceTree(root.right);

        if (leftReturn.flag  && rightReturn.flag){
            if (Math.abs(leftReturn.depth - rightReturn.depth) <= 1){
                return true;
            }
        }
        return false;
    }

    private static Result jugdeBalanceTree(Node node) {
        if (node == null){
            return new Result(0, true);
        }

        Result left = jugdeBalanceTree(node.left);
        Result right = jugdeBalanceTree(node.right);

        if (left.flag  && right.flag){
            if (Math.abs(left.depth - right.depth) <= 1){
                return new Result(Math.max(left.depth, right.depth) + 1, true);
            }
        }
        return new Result(0, false);

    }
}
