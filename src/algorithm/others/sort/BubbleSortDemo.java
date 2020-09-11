package algorithm.others.sort;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/6 10:11
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
//        int nums[] = {5, 7, 1, 8, 9, 6, 4, 2};
        int nums[] = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(bubbleSortInsc(nums)));
        System.out.println(Arrays.toString(bubbleSortDesc(nums)));
    }

    public static int[] bubbleSortInsc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1 ; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (false == flag) {
                return array;
            }
        }
        return array;
    }

    public static int[] bubbleSortDesc(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1 ; j++) {
                if (array[j] <array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (false == flag) {
                return array;
            }
        }
        return array;
    }



}
