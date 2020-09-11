package algorithm.leetcode.Test102;

import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/6 14:54
 */
public class Test102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        TreeNode temp = root;
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int newCount = 0;
            List<Integer> list1 = new ArrayList<>();
            while (count > 0) {
                temp = queue.remove();
                list1.add(temp.val);
                count--;
                if (temp.left != null) {
                    queue.add(temp.left);
                    newCount++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    newCount++;
                }
            }
            list.add(list1);
            count = newCount;
        }
        return list;
    }
}

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}

