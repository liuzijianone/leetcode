package algorithm.CodingInterviews.Test57;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/7 19:36
 */
public class Test57 {
    public static void main(String[] args) {


    }
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] + nums[right] == target){
                return new int[]{nums[left] , nums[right]};
            }
            else if (nums[left] + nums[right] < target){
                left++;
            }
            else {
                right ++;
            }
        }
        return new int[0];

    }

}
