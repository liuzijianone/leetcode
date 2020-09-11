package algorithm.others.sort;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/6 10:48
 */
public class InsertSortDemo {
    public static void main(String[] args) {
        int[] nums = {1,5,8,2,4,10,5,12,6,9};
        System.out.println(Arrays.toString(insertSort(nums)));
    }

    public static int[] insertSort(int[] nums){
        if (nums.length == 0 || nums.length ==1){
            return nums;
        }

        for (int i = 1; i < nums.length; i++){
            for (int j = i - 1 ; j >= 0 ; j--){
                if (nums[j + 1] < nums[j]){
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
