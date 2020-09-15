package algorithm.CodingInterviews.Test54;

import algorithm.CodingInterviews.Test55.Test55;

import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/15 15:56
 *  剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class Test54 {
    public int kthLargest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        Stack <TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        int count = 0;
        while(!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.right;
            }
            else{
                temp = stack.pop();
                count ++;
                if(count == k){
                    return temp.val;
                }
                temp = temp.left;
            }
        }
        return  -1;
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
