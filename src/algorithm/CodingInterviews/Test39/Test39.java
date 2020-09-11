package algorithm.CodingInterviews.Test39;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/4 20:53
 */
public class Test39 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,5,4,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int nums[]){
        int count = 0;
        int value = nums[0];

        for (int num : nums) {
            if (num == value){
                count ++;
            }
            else{
                count--;
            }
            if (count < 0){
                count =0;
                value = num;
            }
        }
        return value;
    }
}
