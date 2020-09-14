package algorithm.CodingInterviews.Test04;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/30 19:35
 *  在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *  请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 */
public class Test04 {
    public static void main(String[] args) {
        int[][] array = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 24, 17, 24}, {18, 21, 23, 26, 30}};

//        int [][] array = {{-5}};

//        System.out.println(array[0].length);

        System.out.println(findNumber(array, 52));
    }

    public static boolean findNumber(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;

        if (matrix[row][column] == target) {
            return true;
        }

        while(column >=0 && row <= matrix.length -1){
            if (matrix[row][column] > target){
                column--;
            }
            else if(matrix[row][column] < target){
                row ++;
            }
            else {
                return true;
            }
        }

        return false;

    }
}




