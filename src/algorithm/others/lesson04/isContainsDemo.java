package algorithm.others.lesson04;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/11 11:50
 */
public class isContainsDemo {
    public static void main(String[] args) {
        int[][] array = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 24, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(isContains(array, 20));
    }

    public static boolean isContains(int[][] array, int value){
        if (array.length == 0 || array[0].length == 0){
            return false;
        }

        int row = 0;
        int column = array[0].length - 1;
        while (row <= array.length - 1 && column >= 0) {
            if (array[row][column] == value){
                return true;
            }else if(array[row][column] < value){
                row++;
            }else if (array[row][column] > value){
                column--;
            }
        }
        return false;
    }
}
