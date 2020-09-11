package algorithm.others.lesson04;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/10 20:37
 */
public class ZigZagPrintMatrix {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrixZigZag(nums);
    }

    public static void printMatrixZigZag(int[][] nums){
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = nums.length - 1;
        int endC = nums[0].length - 1;
        boolean direction = false;
        while(aR <= endR){
            printlevel(nums, aR, aC, bR, bC, direction);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bC = bR == endR ? bC+1 : bC;
            bR = bR == endR ?  bR : bR + 1;
            direction = ! direction;
        }
    }

    private static void printlevel(int[][] nums, int aR, int aC, int bR, int bC, boolean flag) {
        if (flag){
            while (bR >= aR){
                System.out.print(nums[aR++][aC--] + " ");
            }

        }else {
            while (aR <= bR){
                System.out.print(nums[bR--][bC++] + " ");
            }

        }
    }
}
