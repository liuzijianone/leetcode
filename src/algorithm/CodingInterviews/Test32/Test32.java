package algorithm.CodingInterviews.Test32;

import org.junit.Test;

import java.util.*;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/6 21:32
 */
public class Test32 {
    @Test
    public List<List<Integer>> test02(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.add(temp);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list1 = new ArrayList<>();
            while (count > 0){
                temp = queue.remove();
                count--;
                list1.add(temp.val);
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
            }
            list.add(list1);
        }
        return  list;
    }


    @Test
    public int[] test01(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.add(root);
        while (!queue.isEmpty()){
            node = queue.remove();
            list.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right !=null){
                queue.add(node.right);
            }
        }
        int[] array = new int[list.size()];

        ListIterator iterator = list.listIterator();
        int i =0;
        while (iterator.hasNext()){
            array[i++]= (int) iterator.next();
        }

        return array;
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
