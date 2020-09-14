package algorithm.others.lesson04;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/11 22:09
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        nums = rotate(nums);
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] rotate(int[][] nums){
        if (nums.length == 0 || nums[0].length == 0 ){
            return null;
        }

        int sC = 0;
        int sR = 0;
        int eR = nums.length - 1;
        int eC = nums[0].length - 1;

        while (sC < eC && sR < eR){
            rotatePrint(nums, sR++, sC++, eR-- , eC--);
        }

        return nums;
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
