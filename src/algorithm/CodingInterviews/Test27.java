package algorithm.CodingInterviews;

import algorithm.CodingInterviews.Test55.Test55;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/15 15:58
 *
 *  二叉树的镜像
 */
public class Test27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
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
