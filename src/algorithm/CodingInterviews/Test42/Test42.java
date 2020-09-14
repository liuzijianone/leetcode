package algorithm.CodingInterviews.Test42;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/5 19:03
 *
 *  输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 *
 */
public class Test42 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums){
        if (nums.length == 0){
            return -1;
        }
        int value = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++){
            if (value + nums[i] > nums[i]){
                value = value + nums[i];
            }
            else
            {
                value = nums[i];
            }
            if (value > max){
                max = value;
            }
        }
        return max;
    }
}
