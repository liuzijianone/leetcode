package algorithm.CodingInterviews.Test07;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/31 20:28
 */
public class Test07 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

//        int[] preorder = {1,2,3,4,5};
//        int[] inorder = {1,2,3,4,5};

        TreeNode root = buildTree(preorder, inorder);

        preOrder(root);
        inOrder(root);


    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }

        if (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }


        int i = 0;
        TreeNode root = new TreeNode(preorder[0]);
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                break;
            }
        }

        int[] leftInorder = new int[i];
        for (int j = 0; j < i; j++) {
            leftInorder[j] = inorder[j];
        }

        int[] rightInorder = new int[inorder.length - i - 1];
        for (int j = i + 1; j < inorder.length; j++) {
            rightInorder[j - i -1] = inorder[j];
        }

//        System.out.println(Arrays.toString(leftInorder));
//        System.out.println(Arrays.toString(rightInorder));


        int[] leftPreorder = new int[i];
        int[] rightPreorder = new int[inorder.length - i - 1];

//        int count = 0;
//        for (int j = 1; j < preorder.length; j++){
//            for (int k =0; k < i && count < leftPreorder.length; k++){
//                if (preorder[j] == inorder[k]){
//                    leftPreorder[count] = preorder[j];
//                    count++;
//                }
//            }
//        }
        for (int j =0; j < i; j++){
            leftPreorder[j] = preorder[j + 1];
        }

        for (int j = i + 1; j < preorder.length; j++){
            rightPreorder[j - i -1] = preorder[j];
        }
//        count = 0;
//
//        for (int j = 1; j < preorder.length; j++){
//            for (int k = i + 1; k < inorder.length && count < rightPreorder.length; k++){
//                if (preorder[j] == inorder[k]){
//                    rightPreorder[count] = preorder[j];
//                    count++;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(leftPreorder));
//        System.out.println(Arrays.toString(rightPreorder));



        TreeNode left = buildTree(leftPreorder,leftInorder);
        TreeNode right = buildTree(rightPreorder,rightInorder);

        root.left = left;
        root.right = right;

        return root;
    }

    public static void preOrder(TreeNode node){
        if (node == null) {
            return;
        }
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);

    }

    public static void inOrder(TreeNode node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);

    }

static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }


    }
}
