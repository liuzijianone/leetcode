package algorithm.CodingInterviews.Test55;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/14 16:25
 * <p>
 * 01: 求二叉树深度
 * 02：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Test55 {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Result leftReturn = jugdeBalanceTree(root.left);
        Result rightReturn = jugdeBalanceTree(root.right);

        if (leftReturn.flag && rightReturn.flag) {
            if (Math.abs(leftReturn.depth - rightReturn.depth) <= 1) {
                return true;
            }
        }
        return false;
    }

    public static class Result {
        int depth;
        boolean flag;

        public Result(int depth, boolean flag) {
            this.depth = depth;
            this.flag = flag;
        }
    }

    private static Result jugdeBalanceTree(TreeNode node) {
        if (node == null) {
            return new Result(0, true);
        }

        Result left = jugdeBalanceTree(node.left);
        Result right = jugdeBalanceTree(node.right);

        if (left.flag && right.flag) {
            if (Math.abs(left.depth - right.depth) <= 1) {
                return new Result(Math.max(left.depth, right.depth) + 1, true);
            }
        }
        return new Result(0, false);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
