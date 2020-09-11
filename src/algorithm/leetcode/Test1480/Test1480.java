package algorithm.leetcode.Test1480;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/8 18:44
 */
public class Test1480 {
    public static void main(String[] args) {

    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
