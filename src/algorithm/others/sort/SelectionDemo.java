package algorithm.others.sort;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/6 10:26
 */
public class SelectionDemo {
    public static void main(String[] args) {
        int[] nums = {7, 6, 5, 1, 2, 5, 8, 9, 4};
        System.out.println(Arrays.toString(selectionSort(nums)));
    }

    public static int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
