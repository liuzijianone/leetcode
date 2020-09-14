package algorithm.leetcode.Test48;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/12 9:41
 */
public class Test48 {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0 ){
            return;
        }

        int sC = 0;
        int sR = 0;
        int eR = matrix.length - 1;
        int eC = matrix[0].length - 1;

        while (sC < eC && sR < eR){
            rotatePrint(matrix, sR++, sC++, eR-- , eC--);
        }

    }

    public static void rotatePrint(int[][] nums, int sR, int sC, int eR, int eC) {
        int times = eR - sR;
        for (int i = 0; i < times; i++){
            int temp = nums[sR][sC + i];
            nums[sR][sC + i] = nums[eR - i][sC];
            nums[eR - i][sC] = nums[eR][eC - i];
            nums[eR][eC - i] = nums[sR + i][eC];
            nums[sR + i][eC] = temp;
        }
    }
}
