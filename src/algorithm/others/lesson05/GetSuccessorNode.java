package algorithm.others.lesson05;



/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/13 14:56
 */
public class GetSuccessorNode {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(6);
        head.parent = null;
        head.left = new TreeNode(3);
        head.left.parent = head;
        head.left.left = new TreeNode(1);
        head.left.left.parent = head.left;
        head.left.left.right = new TreeNode(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new TreeNode(4);
        head.left.right.parent = head.left;
        head.left.right.right = new TreeNode(5);
        head.left.right.right.parent = head.left.right;
        head.right = new TreeNode(9);
        head.right.parent = head;
        head.right.left = new TreeNode(8);
        head.right.left.parent = head.right;
        head.right.left.left = new TreeNode(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new TreeNode(10);
        head.right.right.parent = head.right;

        TreeNode test = head.left.left;
        System.out.println(test.val + " next: " + getSuccseeorNode(test).val);
        test = head.left.left.right;
        System.out.println(test.val + " next: " + getSuccseeorNode(test).val);
        test = head.left;
        System.out.println(test.val + " next: " + getSuccseeorNode(test).val);
        test = head.left.right;
        System.out.println(test.val + " next: " + getSuccseeorNode(test).val);
        test = head.left.right.right;
        System.out.println(test.val + " next: " + getSuccseeorNode(test).val);
        test = head;
        System.out.println(test.val + " next: " + getSuccseeorNode(test).val);
        test = head.right.left.left;
        System.out.println(test.val + " next: " + getSuccseeorNode(test).val);
        test = head.right.left;
        System.out.println(test.val + " next: " + getSuccseeorNode(test).val);
        test = head.right;
        System.out.println(test.val + " next: " + getSuccseeorNode(test).val);
        test = head.right.right; // 10's next is null
        System.out.println(test.val + " next: " + getSuccseeorNode(test));

    }
    public static TreeNode getSuccseeorNode(TreeNode node){
        if (node == null){
            return node;
        }
        if (node.right != null ){
            return getMostLeft(node.right);
        }
        else{
            TreeNode parent = node.parent;
            while (parent != null ){
                if (parent.left == node){
                    return parent;
                }
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }


    private static TreeNode getMostLeft(TreeNode node) {
        if (node == null){
            return null;
        }
        while (node.left != null){
            node = node.left;
        }

        return node;
    }
}

class TreeNode{
    int val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
        this.val = x;
    }
}
