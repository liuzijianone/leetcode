package algorithm.CodingInterviews.Test21;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/4 20:13
 */
public class Test21 {
    public static void main(String[] args) {
        int nums[] = {10, 5, 6, 9, 5, 7, 8, 4, 2, 36, 5};
        System.out.println(Arrays.toString(exchange(nums)));
        System.out.println(Arrays.toString(exchange01(nums)));

    }

    public static int[] exchange01(int[] nums){
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }

        int left = -1;
        int cur = 0;
        while (cur < nums.length){
            if (nums[cur] % 2 != 0){
                swap(nums, cur, ++left);
                cur++;
            }
            else{
                cur ++;
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

    }

    public static int[] exchange(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (nums[left] % 2 != 0) {
                left++;
                if (left > nums.length - 1) {
                    return nums;
                }
            }
            while (nums[right] % 2 == 0) {
                right--;
                if (right < 0) {
                    return nums;
                }
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

            }
        }
        return nums;
    }
}
