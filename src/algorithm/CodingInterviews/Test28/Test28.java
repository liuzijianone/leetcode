package algorithm.CodingInterviews.Test28;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/15 15:59
 */
public class Test28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return judgeSymmetric(root.left, root.right);
    }

    public boolean judgeSymmetric(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null){
            return true;
        }
        if(n1 == null || n2 == null || n1.val != n2.val){
            return false;
        }
        return judgeSymmetric(n1.left, n2.right) && judgeSymmetric(n1.right, n2.left);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
