package algorithm.CodingInterviews.Test42;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/5 19:03
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
