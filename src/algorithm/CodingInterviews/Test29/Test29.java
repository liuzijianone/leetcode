package algorithm.CodingInterviews.Test29;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/10 14:19
 */
public class Test29 {
    public static void main(String[] args) {
//        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] nums = {{1,2,3,4},{5,6,7,8}};
        System.out.println(Arrays.toString(spiralOrder(nums)));

    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] array = new int[matrix.length * matrix[0].length];
        int count = 0;

        int sRow = 0;
        int sColumn = 0;
        int eRow = matrix.length - 1;
        int eColumn = matrix[0].length - 1;

        while (sRow <= eRow && sColumn <= eColumn) {
//            addEdges(array, sRow++, sColumn++, eRow-- , eColumn--);

            if (sRow == eRow) {
                for (int i = sColumn; i <= eColumn; i++) {
                    array[count++] = matrix[sRow][i];
                }
            } else if (sColumn == eColumn) {
                for (int i = sRow; i <= eRow; i++) {
                    array[count++] = matrix[i][sColumn];
                }
            } else {
                int cRow = sRow;
                int cColumn = sColumn;

                while (cColumn < eColumn) {
                    array[count++] = matrix[cRow][cColumn++];
                }

                while (cRow < eRow) {
                    array[count++] = matrix[cRow++][cColumn];
                }

                while (cColumn > sColumn) {
                    array[count++] = matrix[cRow][cColumn--];
                }

                while (cRow > sRow) {
                    array[count++] = matrix[cRow--][cColumn];
                }

            }
            sRow++;
            sColumn++;
            eRow--;
            eColumn--;
        }
        return array;
    }

}
