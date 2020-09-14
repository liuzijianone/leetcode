package algorithm.others.lesson04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/10 13:57
 */
public class PrintMatrixSpiralOrder {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        spiralOrderPrint(nums);

    }

    public static void spiralOrderPrint(int[][] nums){
        int sRow = 0;
        int sColumn = 0;
        int eRow = nums.length - 1;
        int eColumn =nums[0].length - 1;

        while (sRow <= eRow && sColumn <= eColumn){
            printEdge(nums, sRow++, sColumn++, eRow--, eColumn--);
        }

    }

    public static void printEdge(int nums[][], int sRow, int sColumn, int eRow, int eColumn){
        if (sRow == eRow){
            for (int i = sColumn; i < eColumn; i++){
                System.out.print(nums[sRow][i] + " ");
            }
        }else if (sColumn == eColumn){
            for (int i = sRow; i < eRow; i++){
                System.out.print(nums[i][sColumn]+ " ");
            }
        }else {
            int cRow = sRow;
            int cColumn = sColumn;
            while (cColumn < eColumn){
                System.out.print(nums[cRow][cColumn++] + " ");
            }

            while (cRow < eRow){
                System.out.print(nums[cRow++][cColumn] + " ");
            }

            while (cColumn > sColumn){
                System.out.print(nums[cRow][cColumn--] + " ");
            }

            while (cRow > sRow){
                System.out.print(nums[cRow--][cColumn] + " ");
            }


        }
    }
}
